/*
 *   The MIT License (MIT)
 *
 *   Copyright (c) 2014 Pieter Van Eeckhout
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy of
 *   this software and associated documentation files (the "Software"), to deal in
 *   the Software without restriction, including without limitation the rights to
 *   use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 *   the Software, and to permit persons to whom the Software is furnished to do so,
 *   subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 *   FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 *   COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 *   IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *   CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package timecloud.controller.transfer;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import timecloud.dao.transfer.TransferDAO;
import timecloud.dto.transfer.TransferDTO;
import timecloud.model.transfer.Transfer;
import timecloud.model.transfer.TransferImpl;
import timecloud.util.excelreaders.EmergencyExcelFileReader;

/**
 *
 * Implementation of TransferController
 *
 * @see TransferController
 *
 * @author Pieter Van Eeckhout
 */
public final class TransferControllerImpl implements TransferController {

    private final TransferDAO transferDAO;
    private Map<Long, Map<Long, Transfer>> transfers;

    /**
     *
     * Constructor
     *
     * @param transferDAO The class responsible for persisting Transfer
     */
    public TransferControllerImpl(TransferDAO transferDAO) {
        this.transferDAO = transferDAO;
    }

    @Override
    public void save(long episodeID, TransferDTO transferDTO) throws SQLException {
        try {
            if (transfers == null) {
                getAllFromDB();
            }
            Transfer transfer;
            if (transferDTO.getTransferID() == 0L && !existsTransfer(transferDTO.getTransferID()) && !existsTransfer(new TransferImpl(transferDTO))) {
                transfer = transferDAO.create(episodeID, transferDTO);
            } else {
                transfer = transferDAO.update(transferDTO);
            }
            if (transfer != null) {
                if (!transfers.containsKey(episodeID)) {
                    transfers.put(episodeID, new TreeMap<Long, Transfer>());
                }
                transfers.get(episodeID).put(transfer.getTransferID(), transfer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransferControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void getAllFromDB() throws SQLException {
        transfers = new TreeMap<>();
        Map<Long, Collection<Transfer>> result = transferDAO.readAll();

        for (Map.Entry<Long, Collection<Transfer>> entry : result.entrySet()) {
            Long episodeID = entry.getKey();
            Collection<Transfer> transferCollection = entry.getValue();
            transfers.put(episodeID, new TreeMap<Long, Transfer>());
            for (Transfer transfer : transferCollection) {
                transfers.get(episodeID).put(transfer.getTransferID(), transfer);
            }
        }
    }

    @Override
    public Transfer getTransfer(long transferNumber) throws SQLException, IllegalArgumentException {
        try {
            if (transfers == null) {
                getAllFromDB();
            }
            for (Map<Long, Transfer> transferMap : transfers.values()) {
                if (transferMap.containsKey(transferNumber)) {
                    return transferMap.get(transferNumber);
                }
            }
            throw new IllegalArgumentException("transfer not found");
        } catch (SQLException ex) {
            Logger.getLogger(TransferControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    private boolean existsTransfer(long transferNumber) throws SQLException {
        try {
            getTransfer(transferNumber);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    private boolean existsTransfer(Transfer transfer) {
        for (Map.Entry<Long, Map<Long, Transfer>> entry : transfers.entrySet()) {
            Map<Long, Transfer> map = entry.getValue();
            for (Map.Entry<Long, Transfer> entry1 : map.entrySet()) {
                Transfer transfer1 = entry1.getValue();
                if (transfer.equals(transfer1)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Collection<Transfer> getAllTransfers(long episodeID) throws SQLException {
        if (transfers == null) {
            getAllFromDB();
        }
        return transfers.get(episodeID).values();
    }

    @Override
    public void delete(long transferID) throws SQLException {
        try {
            if (transfers == null) {
                getAllFromDB();
            }
            transferDAO.delete(transferID);
            transfers.remove(transferID);
        } catch (SQLException ex) {
            Logger.getLogger(TransferControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void addFromFile(File file) throws IOException, SQLException {
        try {
            EmergencyExcelFileReader fileReader = new EmergencyExcelFileReader();
            Map<Long, Collection<TransferDTO>> transferDtoMap = fileReader.getTransfers(file);
            for (Map.Entry<Long, Collection<TransferDTO>> entry : transferDtoMap.entrySet()) {
                Long episodeID = entry.getKey();
                Collection<TransferDTO> transferDtos = entry.getValue();
                for (TransferDTO transferDto : transferDtos) {
                    this.save(episodeID, transferDto);
                }
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(TransferControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
