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
package timecloud.controller.request;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Observer;
import timecloud.dto.request.RequestDTO;
import timecloud.model.request.Request;

/**
 *
 * Controller interface defining the available operations on Requests
 *
 * @author Pieter Van Eeckhout
 */
public interface RequestController extends Observer {

    /**
     *
     * Save an request to the DB and the repository
     *
     * @param episodeID the id of the episode of the request
     * @param requestDTO The data of the request to be saved. If the
     * requestID is set, the request will be updated. Else it will be created.
     * @throws java.sql.SQLException
     * @see Request
     * @see RequestDTO
     */
    void save(long episodeID, RequestDTO requestDTO) throws SQLException;

    /**
     *
     * Fills the request collection with all the requests stored in the
     * database.
     *
     * @throws java.sql.SQLException
     * @see Request
     */
    void getAllFromDB() throws SQLException;

    /**
     *
     * Returns the request with the supplied ID.
     *
     * @param requestNumber the ID of the requested request.
     * @return An Request object.
     * @throws java.sql.SQLException
     * @see Request
     */
    Request getRequest(long requestNumber) throws SQLException;

    /**
     *
     * Returns a collection of all the requests stored in the database the episode.
     *
     * @param episodeID the id of the episode of the requests
     * @return Collection containing the Requests.
     * @throws java.sql.SQLException
     * @see Request
     */
    Collection<Request> getAllRequests(long episodeID) throws SQLException;

    /**
     *
     * Deletes the request with the supplied ID.
     *
     * @param requestID The ID of the request to delete.
     * @throws java.sql.SQLException
     */
    void delete(long requestID) throws SQLException;
    
}
