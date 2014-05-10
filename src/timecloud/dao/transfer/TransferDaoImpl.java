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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
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
    public Transfer create(long episodeID, TransferDTO transferDTO) throws SQLException {
        try {
//            //build the statement SQL string
//            StringBuilder queryBuilder = new StringBuilder();
//            //insert new item
//            queryBuilder.append("INSERT INTO").append(" ");
//            //table name
//            queryBuilder.append("Transfers").append(" ");
//            //table collumns
//            queryBuilder.append("(episode_id, transfer_time, start_department, start_bed, start_medical_department, end_department, end_bed, end_medical_department) ");
//            //values keyword
//            queryBuilder.append("VALUES(");
//
//            //the object values
//            //the episode foreign key
//            queryBuilder.append(episodeID).append(", ");
//            //the transfer time
//            //string values so surrounded by quotes, formatted like YYYY-MM-DD HH:MM:SS.SSS
//            queryBuilder.append("\"").append(transferDTO.getTransferTimestamp().toString("yyyy-MM-dd HH:mm:ss")).append("\", ");
//            //the start department
//            //string values so surrounded by quotes
//            queryBuilder.append("\"").append(transferDTO.getStartDepartment()).append("\", ");
//            //the start bed
//            //string values so surrounded by quotes
//            queryBuilder.append("\"").append(transferDTO.getStartBed()).append("\", ");
//            //the start medical department
//            //string values so surrounded by quotes
//            queryBuilder.append("\"").append(transferDTO.getStartMedicalDepartment()).append("\", ");
//            //the end department
//            //string values so surrounded by quotes
//            queryBuilder.append("\"").append(transferDTO.getEndDepartment()).append("\", ");
//            //the end bed
//            //string values so surrounded by quotes
//            queryBuilder.append("\"").append(transferDTO.getEndBed()).append("\", ");
//            //the end medical department
//            //string values so surrounded by quotes
//            queryBuilder.append("\"").append(transferDTO.getEndMedicalDepartment()).append("\"");
//
//            //closing th values tag
//            queryBuilder.append(")");
//
//            Statement statement = databaseController.createStatement();
//            statement.executeUpdate(queryBuilder.toString());            
//            ResultSet rs = statement.getGeneratedKeys();

            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatments.INSERT);

            statement.setLong(1, transferDTO.getTransferID());
            statement.setLong(2, episodeID);
            statement.setString(3, transferDTO.getTransferTimestamp().toString("yyyy-MM-dd HH:mm:ss"));
            statement.setString(4, transferDTO.getStartDepartment());
            statement.setString(5, transferDTO.getStartBed());
            statement.setString(6, transferDTO.getStartMedicalDepartment());
            statement.setString(7, transferDTO.getEndDepartment());
            statement.setString(8, transferDTO.getEndBed());
            statement.setString(9, transferDTO.getEndMedicalDepartment());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                return find(rs.getLong(1));
            }
            throw new SQLException("inserted transfer could not be retrieved, generated keys returned empty");
        } catch (SQLException ex) {
            Logger.getLogger(TransferDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Transfer find(long transferID) throws SQLException {
        try {
//            //build the statement SQL string
//            StringBuilder queryBuilder = new StringBuilder();
//            //insert new item
//            queryBuilder.append("SELECT * FROM").append(" ");
//            //table name
//            queryBuilder.append("Transfers").append(" ");
//            //WHERE keyword
//            queryBuilder.append("WHERE 1 = 1").append(" ");
//
//            //the values to filter on
//            //the episode ID
//            queryBuilder.append("AND ");
//            queryBuilder.append("transfer_id").append(" = ").append(transferID);
//
//            Statement statement = databaseController.createStatement();
//            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatments.FIND);
            statement.setLong(1, transferID);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                TransferBuilder transferBuilder = new TransferBuilderImpl();

                transferBuilder.setTransferID(rs.getLong("transfer_id"));
                transferBuilder.setTransferTimestamp(StringDateTimeConverter.stringToDateTime(rs.getString("transfer_time")));
                transferBuilder.setStartDepartment(rs.getString("start_department"));
                transferBuilder.setStartBed(rs.getString("start_bed"));
                transferBuilder.setStartMedicalDepartment(rs.getString("start_medical_department"));
                transferBuilder.setEndDepartment(rs.getString("end_department"));
                transferBuilder.setEndBed(rs.getString("end_bed"));
                transferBuilder.setEndMedicalDepartment(rs.getString("end_medical_department"));

                return transferBuilder.createTransfer();
            }
            throw new SQLException("Transfer with id (" + transferID + ") could not be found");
        } catch (SQLException ex) {
            Logger.getLogger(TransferDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Transfer update(long episodeID, TransferDTO transferDTO) throws SQLException {
        try {
//            //build the statement SQL string
//            StringBuilder queryBuilder = new StringBuilder();
//            //insert new item
//            queryBuilder.append("UPDATE").append(" ");
//            //table name
//            queryBuilder.append("Transfers").append(" ");
//            //values keyword
//            queryBuilder.append("SET").append(" ");
//
//            //the object values
//            //keep the transferID
//            queryBuilder.append("transfer_id").append(" = ");
//            queryBuilder.append(transferDTO.getTransferID()).append(", ");
//            //the intake time
//            //string values so surrounded by quotes, formatted like YYYY-MM-DD HH:MM:SS.SSS
//            queryBuilder.append("transfer_time").append(" = ");
//            queryBuilder.append("'").append(transferDTO.getTransferTimestamp().toString("yyyy-MM-dd HH:mm:ss")).append("', ");
//            //the start department
//            queryBuilder.append("start_department").append(" = ");
//            queryBuilder.append("'").append(transferDTO.getStartDepartment()).append("', ");
//            //the start bed
//            queryBuilder.append("start_bed").append(" = ");
//            queryBuilder.append("'").append(transferDTO.getStartBed()).append("', ");
//            //the start medical department
//            queryBuilder.append("start_medical_department").append(" = ");
//            queryBuilder.append("'").append(transferDTO.getStartMedicalDepartment()).append("', ");
//            //the end bed
//            queryBuilder.append("end_bed").append(" = ");
//            queryBuilder.append("'").append(transferDTO.getEndBed()).append("', ");
//            //the end medical department
//            queryBuilder.append("end_medical_department").append(" = ");
//            queryBuilder.append("'").append(transferDTO.getEndMedicalDepartment()).append("' ");
//
//            //WEHER keyword
//            queryBuilder.append("WHERE 1 = 1").append(" ");
//
//            //the values to filter on
//            //the episode ID
//            //queryBuilder.append("AND ");
//            //queryBuilder.append("episode_id").append(" = ").append(episodeID).append(" ");
//            //the transfer ID
//            queryBuilder.append("AND ");
//            queryBuilder.append("transfer_id").append(" = ").append(transferDTO.getTransferID());
//
//            Statement statement = databaseController.createStatement();
//            System.out.println(queryBuilder.toString());
//            statement.executeUpdate(queryBuilder.toString());

            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatments.UPDATE);

            statement.setLong(1, transferDTO.getTransferID());
            statement.setString(2, transferDTO.getTransferTimestamp().toString("yyyy-MM-dd HH:mm:ss"));
            statement.setString(3, transferDTO.getStartDepartment());
            statement.setString(4, transferDTO.getStartBed());
            statement.setString(5, transferDTO.getStartMedicalDepartment());
            statement.setString(6, transferDTO.getEndDepartment());
            statement.setString(7, transferDTO.getEndBed());
            statement.setString(8, transferDTO.getEndMedicalDepartment());
            //the filter
            statement.setLong(9, transferDTO.getTransferID());

            return find(transferDTO.getTransferID());
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(transferDTO.toString());
            throw ex;

        }
    }

    @Override
    public Map<Long, Collection<Transfer>> readAll() throws SQLException {
        try {
//            //build the statement SQL string
//            StringBuilder queryBuilder = new StringBuilder();
//            //insert new item
//            queryBuilder.append("SELECT * FROM").append(" ");
//            //table name
//            queryBuilder.append("Transfers");
//
//            Statement statement = databaseController.createStatement();
//            ResultSet rs = statement.executeQuery(queryBuilder.toString());
            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatments.FINDALL);
            ResultSet rs = statement.executeQuery();
            Map<Long, Collection<Transfer>> transfers = new TreeMap<>();
            while (rs.next()) {
                long episodeID = rs.getLong("episode_id");

                if (transfers.get(episodeID) == null) {
                    transfers.put(episodeID, new ArrayList<Transfer>());
                }

                TransferBuilder transferBuilder = new TransferBuilderImpl();

                transferBuilder.setTransferID(rs.getLong("transfer_id"));
                transferBuilder.setTransferTimestamp(StringDateTimeConverter.stringToDateTime(rs.getString("transfer_time")));
                transferBuilder.setStartDepartment(rs.getString("start_department"));
                transferBuilder.setStartBed(rs.getString("start_bed"));
                transferBuilder.setStartMedicalDepartment(rs.getString("start_medical_department"));
                transferBuilder.setEndDepartment(rs.getString("end_department"));
                transferBuilder.setEndBed(rs.getString("end_bed"));
                transferBuilder.setEndMedicalDepartment(rs.getString("end_medical_department"));

                transfers.get(episodeID).add(transferBuilder.createTransfer());
            }
            return transfers;
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void delete(long transferID) throws SQLException {
        try {
//            //build the statement SQL string
//            StringBuilder queryBuilder = new StringBuilder();
//            //insert new item
//            queryBuilder.append("DELETE * FROM").append(" ");
//            //table name
//            queryBuilder.append("Transfers").append(" ");
//            //WHERE keyword
//            queryBuilder.append("WHERE 1 = 1").append(" ");
//
//            //the values to filter on
//            //the episode ID
//            queryBuilder.append("AND ");
//            queryBuilder.append("transfer_id").append(" = ").append(transferID);
//
//            Statement statement = databaseController.createStatement();
//            statement.executeUpdate(queryBuilder.toString());

            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatments.DELETE);
            statement.setLong(1, transferID);
            statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Collection<Transfer> getFromEpisode(long episodeID) throws SQLException {
        try {
//            //build the statement SQL string
//            StringBuilder queryBuilder = new StringBuilder();
//            //insert new item
//            queryBuilder.append("SELECT * FROM").append(" ");
//            //table name
//            queryBuilder.append("Transfers").append(" ");
//            //WHERE keyword
//            queryBuilder.append("WHERE 1 = 1").append(" ");
//
//            //the values to filter on
//            //the episode ID
//            queryBuilder.append("AND ");
//            queryBuilder.append("episode_id").append(" = ").append(episodeID);
//
//            Statement statement = databaseController.createStatement();
//            ResultSet rs = statement.executeQuery(queryBuilder.toString());

            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatments.FINDFOREPISODE);
            statement.setLong(1, episodeID);
            ResultSet rs = statement.executeQuery();
            ArrayList<Transfer> transfers = new ArrayList<>();
            while (rs.next()) {
                TransferBuilder transferBuilder = new TransferBuilderImpl();

                transferBuilder.setTransferID(rs.getLong("transfer_id"));
                transferBuilder.setTransferTimestamp(StringDateTimeConverter.stringToDateTime("transfer_time"));
                transferBuilder.setStartDepartment(rs.getString("start_department"));
                transferBuilder.setStartBed(rs.getString("start_bed"));
                transferBuilder.setStartMedicalDepartment(rs.getString("start_medical_department"));
                transferBuilder.setEndDepartment(rs.getString("end_department"));
                transferBuilder.setEndBed(rs.getString("end_bed"));
                transferBuilder.setEndMedicalDepartment(rs.getString("end_medical_department"));

                transfers.add(transferBuilder.createTransfer());
            }
            return transfers;
        } catch (SQLException ex) {
            Logger.getLogger(TransferDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Map<Long, Collection<Transfer>> batchAddTransfers(Map<Long, Collection<TransferDTO>> transfers) throws SQLException {
        try {
            Map<Long, Collection<Transfer>> savedTransfers = new HashMap<>();
            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatments.INSERT);
            for (Map.Entry<Long, Collection<TransferDTO>> entry : transfers.entrySet()) {
                Long episodeID = entry.getKey();
                Collection<TransferDTO> transferCol = entry.getValue();
                for (TransferDTO transferDto : transferCol) {
                    statement.setLong(1, episodeID);
                    statement.setString(2, transferDto.getTransferTimestamp().toString("yyyy-MM-dd HH:mm:ss"));
                    statement.setString(3, transferDto.getStartDepartment());
                    statement.setString(4, transferDto.getStartBed());
                    statement.setString(5, transferDto.getStartMedicalDepartment());
                    statement.setString(6, transferDto.getEndDepartment());
                    statement.setString(7, transferDto.getEndBed());
                    statement.setString(8, transferDto.getEndMedicalDepartment());

                    statement.addBatch();
                }
            }
            statement.executeBatch();
            ResultSet rs = statement.getGeneratedKeys();

            return savedTransfers;
        } catch (SQLException ex) {
            Logger.getLogger(TransferDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    private final class PreparedStatments {

        static final String INSERT = "INSERT INTO [Transfers] ([episode_id],[transfer_time],start_department,start_bed,start_medical_department,end_department,end_bed,end_medical_department) values (?,?,?,?,?,?,?,?);";
        static final String UPDATE = "UPDATE [Transfers] SET [transfer_id] = ?,[transfer_time] = ?,start_department = ?,start_bed = ?,start_medical_department = ?,end_bed = ?,end_department = ?,end_bed = ?,end_medical_department = ? WHERE 1 = 1 AND [transfer_id] = ?;";
        static final String DELETE = "DELETE * FROM [Transfers] WHERE 1 = 1 AND [transfer_id] = ?;";
        static final String FIND = "SELECT * FROM [Transfers]  WHERE [transfer_id] = ?;";
        static final String FINDALL = "SELECT * FROM [Transfers]";
        static final String FINDFOREPISODE = "SELECT * FROM [Transfers] WHERE 1 = 1 AND [episode_id] = ?;";
        static final String FINDBATCH = "SELECT * FROM [Transfers] WHERE 1 = 1 AND [transfer_id] IN (?);";
    }
}
