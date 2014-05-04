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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import timecloud.controller.database.DatabaseController;
import timecloud.dto.request.RequestDTO;
import timecloud.model.request.Request;
import timecloud.model.request.RequestBuilder;
import timecloud.model.request.RequestBuilderImpl;

public class RequestDaoImpl implements RequestDAO {

    private final DatabaseController databaseController;

    public RequestDaoImpl(DatabaseController databaseController) {
        this.databaseController = databaseController;
    }

    @Override
    public Request create(long episodeID, RequestDTO requestDTO) throws SQLException {
        try {
            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatments.INSERT);

            //TODO: build prepared Statement
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            //statement.executeUpdate();
            //ResultSet rs = statement.getGeneratedKeys();

            //if (rs.next()) {
            //    return find(rs.getLong(1));
            //}
            //throw new SQLException("inserted request could not be retrieved, generated keys returned empty");
        } catch (SQLException ex) {
            Logger.getLogger(RequestDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Request find(long requestID) throws SQLException {
        try {
            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatments.FIND);
            statement.setLong(1, requestID);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                RequestBuilder requestBuilder = new RequestBuilderImpl();

                //TODO: request builder invocation
                
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                //return requestBuilder.createRequest();
            }
            throw new SQLException("Request with id (" + requestID + ") could not be found");
        } catch (SQLException ex) {
            Logger.getLogger(RequestDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Request update(long episodeID, RequestDTO requestDTO) throws SQLException {
        try {
            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatments.UPDATE);

            //TODO: build prepared Statement
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            //return find(requestDTO.getRequestID());
        } catch (SQLException ex) {
            Logger.getLogger(RequestDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(requestDTO.toString());
            throw ex;

        }
    }

    @Override
    public Map<Long, Collection<Request>> readAll() throws SQLException {
        try {
            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatments.FINDALL);
            ResultSet rs = statement.executeQuery();
            Map<Long, Collection<Request>> requests = new TreeMap<>();
            while (rs.next()) {
                long requestID = rs.getLong("request_id");

                if (requests.get(requestID) == null) {
                    requests.put(requestID, new ArrayList<Request>());
                }

                RequestBuilder requestBuilder = new RequestBuilderImpl();

                //TODO: request builder invocation
                
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                //requests.get(requestID).add(requestBuilder.createRequest());
            }
            return requests;
        } catch (SQLException ex) {
            Logger.getLogger(RequestDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void delete(long requestID) throws SQLException {
        try {
            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatments.DELETE);
            statement.setLong(1, requestID);
            statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(RequestDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Collection<Request> getFromEpisode(long episodeID) throws SQLException {
        try {
            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatments.FINDFOREPISODE);
            statement.setLong(1, episodeID);
            ResultSet rs = statement.executeQuery();
            ArrayList<Request> requests = new ArrayList<>();
            while (rs.next()) {
                RequestBuilder requestBuilder = new RequestBuilderImpl();

                //TODO: request builder invocation
                
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                //requests.add(requestBuilder.createRequest());
            }
            return requests;
        } catch (SQLException ex) {
            Logger.getLogger(RequestDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Map<Long, Request> batchAddRequests(Map<Long, RequestDTO> requests) throws SQLException {
        //TODO
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    private final class PreparedStatments {

        static final String INSERT = "INSERT INTO [Requests] ([request_id], [patient_id], [episode_id], [intake_kind], [intake_time], [start_department], [start_medical_department], [request_time], [response_time], [transfer_time], [intake_date], [own_department]) values (?,?,?,?,?,?,?,?,?,?,?,?);";
        static final String UPDATE = "UPDATE [Requests] SET [request_id] = ?, [patient_id] = ?, [episode_id] = ?, [intake_kind] = ?, [intake_time] = ?, [start_department] = ?, [start_medical_department] = ?, [request_time] = ?, [response_time] = ?, [transfer_time] = ?, [intake_date] = ?, [own_department] = ? WHERE 1 = 1 AND [request_id] = ?";
        static final String DELETE = "DELETE * FROM [Requests] WHERE 1 = 1 AND [request_id] = ?;";
        static final String FIND = "SELECT * FROM [Requests]  WHERE [request_id] = ?;";
        static final String FINDALL = "SELECT * FROM [Requests]";
        static final String FINDFOREPISODE = "SELECT * FROM [Requests] WHERE 1 = 1 AND [episode_id] = ?;";
        static final String FINDBATCH = "SELECT * FROM [Requests] WHERE 1 = 1 AND [request_id] IN (?);";
    }
}
