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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import timecloud.controller.database.DatabaseController;
import timecloud.dao.episode.EpisodeDaoImpl;
import timecloud.dto.transfer.TransferDTO;
import timecloud.model.transfer.Transfer;
import timecloud.model.transfer.TransferBuilder;
import timecloud.model.transfer.TransferBuilderImpl;
import timecloud.util.converters.StringDateTimeConverter;

public class TransferDaoImpl implements TransferDAO {

    private final DatabaseController databaseController;

    public TransferDaoImpl(DatabaseController databaseController) {
        this.databaseController = databaseController;
    }

    @Override
    public Transfer create(TransferDTO transferDTO) throws SQLException {
        try {
            //build the statement SQL string
            StringBuilder queryBuilder = new StringBuilder();
            //insert new item
            queryBuilder.append("INSERT INTO").append(" ");
            //table name
            queryBuilder.append("Episode").append(" ");
            //values keyword
            queryBuilder.append("VALUES(");

            //the object values
            //the transfer ID
            queryBuilder.append(transferDTO.getTransferID()).append(", ");
            //the episode foreign key
            //queryBuilder.append(transferDTO.getEpisode().getEpisodeID()).append(", ");
            queryBuilder.append("-1, ");
            //the transfer time
            //string values so surrounded by quotes, formatted like YYYY-MM-DD HH:MM:SS.SSS
            queryBuilder.append("\"").append(transferDTO.getTransferTimestamp().toString("yy-MM-dd HH:mm:ss")).append("\", ");
            //the start department
            //string values so surrounded by quotes
            queryBuilder.append("\"").append(transferDTO.getStartDepartment()).append("\", ");
            //the start bed
            //string values so surrounded by quotes
            queryBuilder.append("\"").append(transferDTO.getStartBed()).append("\", ");
            //the start medical department
            //string values so surrounded by quotes
            queryBuilder.append("\"").append(transferDTO.getStartMedicalDeparment()).append("\", ");
            //the end department
            //string values so surrounded by quotes
            queryBuilder.append("\"").append(transferDTO.getEndDepartment()).append("\", ");
            //the end bed
            //string values so surrounded by quotes
            queryBuilder.append("\"").append(transferDTO.getEndBed()).append("\", ");
            //the end medical department
            //string values so surrounded by quotes
            queryBuilder.append("\"").append(transferDTO.getEndMedicalDepartment()).append("\", ");

            //closing th values tag
            queryBuilder.append(")");

            Statement statement = databaseController.createStatement();
            statement.executeUpdate(queryBuilder.toString());
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                return find(rs.getLong("transfer_id"));
            }
            throw new SQLException("inserted transfer could not be retrieved, generated keys returned empty");
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Transfer find(long transferID) throws SQLException {
        try {
            //build the statement SQL string
            StringBuilder queryBuilder = new StringBuilder();
            //insert new item
            queryBuilder.append("SELECT * FROM").append(" ");
            //table name
            queryBuilder.append("Transfer").append(" ");
            //WHERE keyword
            queryBuilder.append("WHERE 1 = 1").append(" ");

            //the values to filter on
            //the episode ID
            queryBuilder.append("AND ");
            queryBuilder.append("transfer_id").append(" = ").append(transferID);

            Statement statement = databaseController.createStatement();
            ResultSet rs = statement.executeQuery(queryBuilder.toString());
            if (rs.next()) {
                TransferBuilder transferBuilder = new TransferBuilderImpl();

                transferBuilder.setTransferID(rs.getLong("transfer_id"));
                transferBuilder.setTransferTimestamp(StringDateTimeConverter.stringToDateTime("transfer_time"));
                transferBuilder.setStartDepartment(rs.getString("start_department"));
                transferBuilder.setStartBed(rs.getString("start_bed"));
                transferBuilder.setStartMedicalDepartment(rs.getString("start_medical_department"));
                transferBuilder.setEndDepartment(rs.getString("end_department"));
                transferBuilder.setEndBed(rs.getString("end_bed"));
                transferBuilder.setEndMedicalDepartment(rs.getString("end_medical_department"));
                
                return transferBuilder.createTransfer();
            }
            throw new SQLException("Episode with id (" + transferID + ") could not be found");
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Transfer update(TransferDTO transferDTO) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Long, Collection<Transfer>> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long transferID) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
