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
package timecloud.dao.request;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import timecloud.dto.request.RequestDTO;
import timecloud.model.request.Request;

/**
 *
 * DAO interface defining the available CRUD operations on Requests
 *
 * @author Pieter Van Eeckhout
 */
public interface RequestDAO {

    /**
     * Save a new episode to the database
     *
     * @param episodeID the ID of the episode of this request
     * @param requestDTO The data of the episode to be saved.
     * @return The episode object created by saving the RequestDTO to the
     * database
     * @throws java.sql.SQLException
     * @see Request
     * @see RequestDTO
     */
    Request create(long episodeID, RequestDTO requestDTO) throws SQLException;

    /**
     *
     * gets a single Request from the database
     *
     * @param requestID The data of the request to be updated.
     * @return The request object linked to the ID
     * @throws java.sql.SQLException
     * @see Request
     */
    Request find(long requestID) throws SQLException;

    /**
     *
     * Update an existing Request in the database
     *
     * @param episodeID the id of the episode to which this request belongs
     * @param requestDTO The data of the request to be updated.
     * @return The episode object created by saving the RequestDTO to the
     * database
     * @throws java.sql.SQLException
     * @see Request
     * @see RequestDTO
     */
    Request update(long episodeID, RequestDTO requestDTO) throws SQLException;

    /**
     * Returns a collection of all the requests stored in the database, grouped
     * by episodeID.
     *
     * @return Collection containing the Request.
     * @throws java.sql.SQLException
     * @see Request
     */
    Map<Long, Collection<Request>> readAll() throws SQLException;

    /**
     * Deletes the request with the supplied ID from the database.
     *
     * @param requestID The ID of the episode to delete.
     * @throws java.sql.SQLException
     */
    void delete(long requestID) throws SQLException;
    
    /**
     *
     * @param episodeID  the ID of the episode of the requests
     * @return
     * @throws java.sql.SQLException
     */
    Collection<Request> getFromEpisode(long episodeID) throws SQLException;

    /**
     *  Add a whole batch of requests
     * 
     * @param requests the requests to add
     * @return a collection of the added requests grouped by episodeID
     * @throws java.sql.SQLException
     * @see RequestDTO
     * @see Request
     */
    public Map<Long, Request> batchAddRequests(Map<Long, RequestDTO> requests) throws SQLException;
}
