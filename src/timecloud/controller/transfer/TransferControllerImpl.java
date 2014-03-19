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

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import timecloud.dao.transfer.TransferDAO;
import timecloud.dto.transfer.TransferDTO;
import timecloud.model.transfer.Transfer;

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
    private Map<Long, Transfer> transfers;

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
    public void save(TransferDTO transferDTO) throws SQLException {
        try {
            if (transfers == null) {
                getAllFromDB();
            }
            Transfer transfer;
            if (!transfers.containsKey(transferDTO.getTransferID())) {
                transfer = transferDAO.create(transferDTO);
            } else {
                transfer = transferDAO.update(transferDTO);
            }
            if (transfer != null) {
                transfers.put(transfer.getTransferID(), transfer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransferControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void getAllFromDB() throws SQLException {
        transfers = new TreeMap<>();
        Collection<Transfer> result = transferDAO.readAll();

        for (Transfer transfer : result) {
            transfers.put(transfer.getTransferID(), transfer);
        }
    }

    @Override
    public Transfer getTransfer(long transferNumber) throws SQLException {
        try {
            if (transfers == null) {
                getAllFromDB();
            }
            return transfers.get(transferNumber);
        } catch (SQLException ex) {
            Logger.getLogger(TransferControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Collection<Transfer> getAllTransfers() throws SQLException {
        if (transfers == null) {
            getAllFromDB();
        }
        return transfers.values();
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
}
