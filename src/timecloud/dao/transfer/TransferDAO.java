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

import java.util.Collection;
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
     * @param transferDTO The data of the episode to be saved.
     * @return The episode object created by saving the TransferDTO to the
     * database
     * @see Transfer
     * @see TransferDTO
     */
    Transfer create(TransferDTO transferDTO);

    /**
     *
     * Update an existing Episode in the database
     *
     * @param transferDTO The data of the transfer to be updated.
     * @return The episode object created by saving the TransferDTO to the
     * database
     * @see Transfer
     * @see TransferDTO
     */
    Transfer update(TransferDTO transferDTO);

    /**
     * Returns a collection of all the transfers stored in the database.
     *
     * @return Collection containing the Transfer.
     * @see Transfer
     */
    Collection<Transfer> readAll();

    /**
     * Deletes the transfer with the supplied ID from the database.
     *
     * @param transferID The ID of the episode to delete.
     */
    void delete(long transferID);
}