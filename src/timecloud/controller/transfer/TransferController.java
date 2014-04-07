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
import java.util.Observer;
import timecloud.dto.transfer.TransferDTO;
import timecloud.model.transfer.Transfer;

/**
 *
 * Controller interface defining the available operations on Transfers
 *
 * @author Pieter Van Eeckhout
 */
public interface TransferController extends Observer {

    /**
     *
     * Save an transfer to the DB and the repository
     *
     * @param episodeID the id of the episode of the transfer
     * @param transferDTO The data of the transfer to be saved. If the
     * transferID is set, the transfer will be updated. Else it will be created.
     * @throws java.sql.SQLException
     * @see Transfer
     * @see TransferDTO
     */
    void save(long episodeID, TransferDTO transferDTO) throws SQLException;

    /**
     *
     * Fills the transfer collection with all the transfers stored in the
     * database.
     *
     * @throws java.sql.SQLException
     * @see Transfer
     */
    void getAllFromDB() throws SQLException;

    /**
     *
     * Returns the transfer with the supplied ID.
     *
     * @param transferNumber the ID of the requested transfer.
     * @return An Transfer object.
     * @throws java.sql.SQLException
     * @see Transfer
     */
    Transfer getTransfer(long transferNumber) throws SQLException;

    /**
     *
     * Returns a collection of all the transfers stored in the database the episode.
     *
     * @param episodeID the id of the episode of the transfers
     * @return Collection containing the Transfers.
     * @throws java.sql.SQLException
     * @see Transfer
     */
    Collection<Transfer> getAllTransfers(long episodeID) throws SQLException;

    /**
     *
     * Deletes the transfer with the supplied ID.
     *
     * @param transferID The ID of the transfer to delete.
     * @throws java.sql.SQLException
     */
    void delete(long transferID) throws SQLException;
    
}
