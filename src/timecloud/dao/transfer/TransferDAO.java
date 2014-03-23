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
package timecloud.dao.transfer;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import timecloud.dto.transfer.TransferDTO;
import timecloud.model.transfer.Transfer;

/**
 *
 * DAO interface defining the available CRUD operations on Transfers
 *
 * @author Pieter Van Eeckhout
 */
public interface TransferDAO {

    /**
     * Save a new episode to the database
     *
     * @param episodeID the ID of the episode of this transfer
     * @param transferDTO The data of the episode to be saved.
     * @return The episode object created by saving the TransferDTO to the
     * database
     * @throws java.sql.SQLException
     * @see Transfer
     * @see TransferDTO
     */
    Transfer create(long episodeID, TransferDTO transferDTO) throws SQLException;

    /**
     *
     * gets a single Episode from the database
     *
     * @param transferID The data of the transfer to be updated.
     * @return The transfer object linked to the ID
     * @throws java.sql.SQLException
     * @see Transfer
     */
    Transfer find(long transferID) throws SQLException;

    /**
     *
     * Update an existing Episode in the database
     *
     * @param transferDTO The data of the transfer to be updated.
     * @return The episode object created by saving the TransferDTO to the
     * database
     * @throws java.sql.SQLException
     * @see Transfer
     * @see TransferDTO
     */
    Transfer update(TransferDTO transferDTO) throws SQLException;

    /**
     * Returns a collection of all the transfers stored in the database, grouped
     * by episodeID.
     *
     * @return Collection containing the Transfer.
     * @throws java.sql.SQLException
     * @see Transfer
     */
    Map<Long, Collection<Transfer>> readAll() throws SQLException;

    /**
     * Deletes the transfer with the supplied ID from the database.
     *
     * @param transferID The ID of the episode to delete.
     * @throws java.sql.SQLException
     */
    void delete(long transferID) throws SQLException;
    
    /**
     *
     * @param episodeID  the ID of the episode of the transfers
     * @return
     * @throws java.sql.SQLException
     */
    Collection<Transfer> getFromEpisode(long episodeID) throws SQLException;
}
