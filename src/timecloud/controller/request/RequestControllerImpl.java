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
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import timecloud.dao.request.RequestDAO;
import timecloud.dto.request.RequestDTO;
import timecloud.model.request.Request;
import timecloud.model.request.RequestImpl;

/**
 *
 * Implementation of RequestController
 *
 * @see RequestController
 *
 * @author Pieter Van Eeckhout
 */
public final class RequestControllerImpl implements RequestController {

    private final RequestDAO requestDAO;
    private Map<Long, Map<Long, Request>> requests;

    /**
     *
     * Constructor
     *
     * @param requestDAO The class responsible for persisting Request
     */
    public RequestControllerImpl(RequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    @Override
    public void save(long episodeID, RequestDTO requestDTO) throws SQLException {
        try {
            if (requests == null) {
                getAllFromDB();
            }
            Request request;
            if (requestDTO.getRequestID() == 0L && !existsRequest(requestDTO.getRequestID())) {
                request = requestDAO.create(episodeID, requestDTO);
            } else {
                if (existsRequest(new RequestImpl(requestDTO))) {
                    request = requestDAO.update(episodeID, requestDTO);
                    System.out.println("update a request");
                } else {
                    throw new SQLException("how could this happen???");
                }
            }
            if (request != null) {
                if (!requests.containsKey(episodeID)) {
                    requests.put(episodeID, new TreeMap<Long, Request>());
                }
                requests.get(episodeID).put(request.getRequestID(), request);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void getAllFromDB() throws SQLException {
        requests = new TreeMap<>();
        Map<Long, Collection<Request>> result = requestDAO.readAll();

        for (Map.Entry<Long, Collection<Request>> entry : result.entrySet()) {
            Long episodeID = entry.getKey();
            Collection<Request> requestCollection = entry.getValue();
            requests.put(episodeID, new TreeMap<Long, Request>());
            for (Request request : requestCollection) {
                requests.get(episodeID).put(request.getRequestID(), request);
            }
        }
    }

    @Override
    public Request getRequest(long requestNumber) throws SQLException, IllegalArgumentException {
        try {
            if (requests == null) {
                getAllFromDB();
            }
            for (Map<Long, Request> requestMap : requests.values()) {
                if (requestMap.containsKey(requestNumber)) {
                    return requestMap.get(requestNumber);
                }
            }
            throw new IllegalArgumentException("request not found");
        } catch (SQLException ex) {
            Logger.getLogger(RequestControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    private boolean existsRequest(long requestNumber) throws SQLException {
        try {
            getRequest(requestNumber);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    private boolean existsRequest(Request request) {
        for (Map.Entry<Long, Map<Long, Request>> entry : requests.entrySet()) {
            Map<Long, Request> map = entry.getValue();
            for (Map.Entry<Long, Request> entry1 : map.entrySet()) {
                Request request1 = entry1.getValue();
                if (request.equals(request1)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Collection<Request> getAllRequests(long episodeID) throws SQLException {
        if (requests == null) {
            getAllFromDB();
        }
        return requests.get(episodeID).values();
    }

    @Override
    public void delete(long requestID) throws SQLException {
        try {
            if (requests == null) {
                getAllFromDB();
            }
            requestDAO.delete(requestID);
            requests.remove(requestID);
        } catch (SQLException ex) {
            Logger.getLogger(RequestControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
