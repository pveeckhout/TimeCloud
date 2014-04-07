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
package timecloud.dao.episode;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import timecloud.controller.database.DatabaseController;
import timecloud.dto.episode.EpisodeDTO;
import timecloud.enums.TriageLevel;
import timecloud.model.episode.Episode;
import timecloud.model.episode.EpisodeBuilder;
import timecloud.model.episode.EpisodeBuilderImpl;
import timecloud.util.converters.StringDateTimeConverter;

/**
 *
 * Implementation of EpisodeDAO
 *
 * @see EpisodeDAO
 *
 * @author Pieter Van Eeckhout
 */
public class EpisodeDaoImpl implements EpisodeDAO {

    private final DatabaseController databaseController;

    public EpisodeDaoImpl(DatabaseController databaseController) {
        this.databaseController = databaseController;
    }

    @Override
    public Episode create(EpisodeDTO episodeDTO) throws SQLException {
        try {
//            String query = buildCreateQuery(episodeDTO);
//            Statement statement = databaseController.createStatement();
//            statement.executeUpdate(query);
//            ResultSet rs = statement.getGeneratedKeys();
            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatements.INSERT);
            statement.setLong(1, episodeDTO.getEpisodeID());
            statement.setString(2, episodeDTO.getpatientID());
            statement.setString(3, episodeDTO.getIntakeTimestamp().toString("yyyy-MM-dd HH:mm:ss"));
            statement.setBoolean(4, episodeDTO.getMeg());
            if (episodeDTO.getTriageTimestamp() == null) {
                statement.setString(5, "");
            } else {
                statement.setString(5, episodeDTO.getTriageTimestamp().toString("yyyy-MM-dd HH:mm:ss"));
            }
            statement.setInt(6, episodeDTO.getTriageLevel().getTriageLevel());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                return find(rs.getLong(1));
            }
            throw new SQLException("inserted Episode could not be retrieved, generated keys returned empty");
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Episode find(long episodeID) throws SQLException {
        try {
//            //build the statement SQL string
//            StringBuilder queryBuilder = new StringBuilder();
//            //insert new item
//            queryBuilder.append("SELECT * FROM").append(" ");
//            //table name
//            queryBuilder.append("Episodes").append(" ");
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
            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatements.FIND);
            statement.setLong(1, episodeID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                EpisodeBuilder episodeBuilder = new EpisodeBuilderImpl();

                episodeBuilder.setEpisodeID(rs.getLong("episode_id"));
                episodeBuilder.setPatientID(rs.getString("patient_id"));
                episodeBuilder.setIntakeTimestamp(new DateTime(StringDateTimeConverter.stringToDateTime(rs.getString("intake_time"))));
                episodeBuilder.setMeg(rs.getBoolean("meg"));
                episodeBuilder.setTriageTimestamp(new DateTime(StringDateTimeConverter.stringToDateTime(rs.getString("triage_time"))));
                episodeBuilder.setTriageLevel(TriageLevel.fromInteger(rs.getInt("triage_level")));

                return episodeBuilder.createEpisode();
            }
            throw new SQLException("Episode with id (" + episodeID + ") could not be found");
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Episode update(EpisodeDTO episodeDTO) throws SQLException {
        try {
//            String query = buildUpdateQuery(episodeDTO);
//            Statement statement = databaseController.createStatement();
//            statement.executeUpdate(query);

            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatements.UPDATE);
            statement.setLong(1, episodeDTO.getEpisodeID());
            statement.setString(2, episodeDTO.getpatientID());
            statement.setString(3, episodeDTO.getIntakeTimestamp().toString("yyyy-MM-dd HH:mm:ss"));
            statement.setBoolean(4, episodeDTO.getMeg());
            if (episodeDTO.getTriageTimestamp() == null) {
                statement.setString(5, "");
            } else {
                statement.setString(5, episodeDTO.getTriageTimestamp().toString("yyyy-MM-dd HH:mm:ss"));
            }
            statement.setInt(6, episodeDTO.getTriageLevel().getTriageLevel());
            statement.setLong(7, episodeDTO.getEpisodeID());

            return find(episodeDTO.getEpisodeID());
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Collection<Episode> readAll() throws SQLException {
        try {
//            //build the statement SQL string
//            StringBuilder queryBuilder = new StringBuilder();
//            //insert new item
//            queryBuilder.append("SELECT * FROM").append(" ");
//            //table name
//            queryBuilder.append("Episodes");
//
//            Statement statement = databaseController.createStatement();
//            ResultSet rs = statement.executeQuery(queryBuilder.toString());
            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatements.FINDALL);
            ResultSet rs = statement.executeQuery();
            Collection<Episode> episodes = new ArrayList<>();
            while (rs.next()) {
                EpisodeBuilder episodeBuilder = new EpisodeBuilderImpl();

                episodeBuilder.setEpisodeID(rs.getLong("episode_id"));
                episodeBuilder.setPatientID(rs.getString("patient_id"));
                episodeBuilder.setIntakeTimestamp(new DateTime(StringDateTimeConverter.stringToDateTime(rs.getString("intake_time"))));
                episodeBuilder.setMeg(rs.getBoolean("meg"));
                episodeBuilder.setTriageTimestamp(new DateTime(StringDateTimeConverter.stringToDateTime(rs.getString("triage_time"))));
                episodeBuilder.setTriageLevel(TriageLevel.fromInteger(rs.getInt("triage_level")));

                episodes.add(episodeBuilder.createEpisode());
            }
            return episodes;
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void delete(long episodeID) throws SQLException {
        try {
//            String query = buildDeleteQuery(episodeID);
//            Statement statement = databaseController.createStatement();
//            statement.executeUpdate(query);
            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatements.DELETE);
            statement.setLong(1, episodeID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

//    private String buildCreateQuery(EpisodeDTO episodeDTO) {
//        //build the statement SQL string
//        StringBuilder queryBuilder = new StringBuilder();
//        //insert new item
//        queryBuilder.append("INSERT INTO").append(" ");
//        //table name
//        queryBuilder.append("Episodes").append(" ");
//        //values keyword
//        queryBuilder.append("VALUES(");
//
//        //the object values
//        //the episode ID
//        queryBuilder.append(episodeDTO.getEpisodeID()).append(", ");
//        //the patient ID
//        //string values so surrounded by quotes
//        queryBuilder.append("'").append(episodeDTO.getpatientID()).append("', ");
//        //the intake time
//        //string values so surrounded by quotes, formatted like YYYY-MM-DD HH:MM:SS.SSS
//        queryBuilder.append("'").append(episodeDTO.getIntakeTimestamp().toString("yyyy-MM-dd HH:mm:ss")).append("', ");
//        //whether or not the MEG was used
//        if (episodeDTO.getMeg()) {
//            queryBuilder.append(1).append(", ");
//        } else {
//            queryBuilder.append(0).append(", ");
//        }
//        //the triage time
//        //string values so surrounded by quotes, formatted like YYYY-MM-DD HH:MM:SS.SSS
//        if (episodeDTO.getTriageTimestamp() != null) {
//            queryBuilder.append("'").append(episodeDTO.getTriageTimestamp().toString("yyyy-MM-dd HH:mm:ss")).append("', ");
//        } else {
//            queryBuilder.append("'', ");
//        }
//        //the triage level
//        queryBuilder.append(episodeDTO.getTriageLevel().getTriageLevel());
//
//        //closing th values tag
//        queryBuilder.append(")");
//
//        return queryBuilder.toString();
//    }
//    private String buildUpdateQuery(EpisodeDTO episodeDTO) {
//        //build the statement SQL string
//        StringBuilder queryBuilder = new StringBuilder();
//        //insert new item
//        queryBuilder.append("UPDATE").append(" ");
//        //table name
//        queryBuilder.append("Episodes").append(" ");
//        //values keyword
//        queryBuilder.append("SET").append(" ");
//
//        //the object values
//        //the patient ID
//        //string values so surrounded by quotes
//        queryBuilder.append("patient_id").append(" = ");
//        queryBuilder.append("'").append(episodeDTO.getpatientID()).append("', ");
//        //the intake time
//        //string values so surrounded by quotes, formatted like YYYY-MM-DD HH:MM:SS.SSS
//        queryBuilder.append("intake_time").append(" = ");
//        queryBuilder.append("'").append(episodeDTO.getIntakeTimestamp().toString("yyyy-MM-dd HH:mm:ss")).append("', ");
//        //whether or not the MEG was used
//        queryBuilder.append("meg").append(" = ");
//        if (episodeDTO.getMeg()) {
//            queryBuilder.append(1).append(", ");
//        } else {
//            queryBuilder.append(0).append(", ");
//        }
//        //the triage time
//        //string values so surrounded by quotes, formatted like YYYY-MM-DD HH:MM:SS.SSS
//        queryBuilder.append("triage_time").append(" = ");
//        if (episodeDTO.getTriageTimestamp() != null) {
//            queryBuilder.append("'").append(episodeDTO.getTriageTimestamp().toString("yyyy-MM-dd HH:mm:ss")).append("', ");
//        } else {
//            queryBuilder.append("'', ");
//        }
//        //the triage level
//        queryBuilder.append("triage_level").append(" = ");
//        queryBuilder.append(episodeDTO.getTriageLevel().getTriageLevel()).append(" ");
//
//        //WEHER keyword
//        queryBuilder.append("WHERE 1 = 1").append(" ");
//
//        //the values to filter on
//        //the episode ID
//        queryBuilder.append("AND ");
//        queryBuilder.append("episode_id").append(" = ").append(episodeDTO.getEpisodeID());
//
//        return queryBuilder.toString();
//    }
//    private String buildDeleteQuery(long episodeID) {
//        //build the statement SQL string
//        StringBuilder queryBuilder = new StringBuilder();
//        //insert new item
//        queryBuilder.append("DELETE * FROM").append(" ");
//        //table name
//        queryBuilder.append("Episodes").append(" ");
//        //WHERE keyword
//        queryBuilder.append("WHERE 1 = 1").append(" ");
//
//        //the values to filter on
//        //the episode ID
//        queryBuilder.append("AND ");
//        queryBuilder.append("episode_id").append(" = ").append(episodeID);
//
//        return queryBuilder.toString();
//    }
    @Override
    public Collection<Episode> batchProcess(Collection<EpisodeDTO> episodes) throws SQLException {
        try {
            PreparedStatement statement = databaseController.createPreparedStatement(PreparedStatements.INSERT);
            Collection<Episode> savedEpisodes = new ArrayList();
            for (EpisodeDTO episodeDTO : episodes) {
                statement.setLong(1, episodeDTO.getEpisodeID());
                statement.setString(2, episodeDTO.getpatientID());
                statement.setString(3, episodeDTO.getIntakeTimestamp().toString("yyyy-MM-dd HH:mm:ss"));
                statement.setBoolean(4, episodeDTO.getMeg());
                if (episodeDTO.getTriageTimestamp() == null) {
                    statement.setString(5, "");
                } else {
                    statement.setString(5, episodeDTO.getTriageTimestamp().toString("yyyy-MM-dd HH:mm:ss"));
                }
                statement.setInt(6, episodeDTO.getTriageLevel().getTriageLevel());

                statement.addBatch();
                //statement.clearParameters();
            }
            statement.executeBatch();
            ResultSet rs = statement.getGeneratedKeys();
            throw new UnsupportedOperationException("to be implemented further");
            //return savedEpisodes;
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    private final class PreparedStatements {

        static final String INSERT = "INSERT INTO Episodes (episode_id,patient_id,intake_time,meg,triage_time,triage_level) values (?,?,?,?,?,?);";
        static final String UPDATE = "UPDATE Episodes SET episode_id = ?,patient_id = ?,intake_time = ?,meg = ?,triage_time = ?,triage_level = ? WHERE 1 = 1 AND episode_id = ?;";
        static final String DELETE = "DELETE * FROM Episodes WHERE 1 = 1 AND episode_id = ?;";
        static final String FIND = "SELECT * FROM Episodes WHERE 1 = 1 AND episode_id = ?;";
        static final String FINDALL = "SELECT * FROM Episodes;";
        static final String FINDBATCH = "SELECT * FROM Episodes WHERE 1 = 1 AND episode_id IN (?);";
    }
}
