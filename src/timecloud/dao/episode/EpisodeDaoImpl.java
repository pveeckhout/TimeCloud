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
        PreparedStatement statement = null;
        try {
            statement = databaseController.createPreparedStatement(PreparedStatements.INSERT);
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
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                databaseController.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Episode find(long episodeID) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = databaseController.createPreparedStatement(PreparedStatements.FIND);
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
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                databaseController.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Episode update(EpisodeDTO episodeDTO) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = databaseController.createPreparedStatement(PreparedStatements.UPDATE);
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
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                databaseController.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Collection<Episode> readAll() throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = databaseController.createPreparedStatement(PreparedStatements.FINDALL);
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
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                databaseController.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void delete(long episodeID) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = databaseController.createPreparedStatement(PreparedStatements.DELETE);
            statement.setLong(1, episodeID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                databaseController.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Collection<Episode> batchProcess(Collection<EpisodeDTO> episodes) throws SQLException {
        PreparedStatement insertStatement = null;
        PreparedStatement findStatement = null;
        try {
            insertStatement = databaseController.createPreparedStatement(PreparedStatements.INSERT);
            for (EpisodeDTO episodeDTO : episodes) {
                insertStatement.setLong(1, episodeDTO.getEpisodeID());
                insertStatement.setString(2, episodeDTO.getpatientID());
                insertStatement.setString(3, episodeDTO.getIntakeTimestamp().toString("yyyy-MM-dd HH:mm:ss"));
                insertStatement.setBoolean(4, episodeDTO.getMeg());
                if (episodeDTO.getTriageTimestamp() == null) {
                    insertStatement.setString(5, "");
                } else {
                    insertStatement.setString(5, episodeDTO.getTriageTimestamp().toString("yyyy-MM-dd HH:mm:ss"));
                }
                insertStatement.setInt(6, episodeDTO.getTriageLevel().getTriageLevel());

                insertStatement.addBatch();
            }
            insertStatement.executeBatch();
//            ResultSet insertRs = insertStatement.getGeneratedKeys();
            findStatement = databaseController.createPreparedStatement(PreparedStatements.FIND);
            Collection<Episode> savedEpisodes = new ArrayList();
             for (EpisodeDTO episodeDTO : episodes) {
                 findStatement.setLong(1, episodeDTO.getEpisodeID());
             }
            findStatement.executeBatch();
            ResultSet findRs = insertStatement.getResultSet();
            while (findRs != null && findRs.next()) {
                EpisodeBuilder episodeBuilder = new EpisodeBuilderImpl();

                episodeBuilder.setEpisodeID(findRs.getLong("episode_id"));
                episodeBuilder.setPatientID(findRs.getString("patient_id"));
                episodeBuilder.setIntakeTimestamp(new DateTime(StringDateTimeConverter.stringToDateTime(findRs.getString("intake_time"))));
                episodeBuilder.setMeg(findRs.getBoolean("meg"));
                episodeBuilder.setTriageTimestamp(new DateTime(StringDateTimeConverter.stringToDateTime(findRs.getString("triage_time"))));
                episodeBuilder.setTriageLevel(TriageLevel.fromInteger(findRs.getInt("triage_level")));

                savedEpisodes.add(episodeBuilder.createEpisode());
            }
            return savedEpisodes;
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } finally {
            try {
                if (insertStatement != null) {
                    insertStatement.close();
                }
                if (findStatement != null) {
                    findStatement.close();
                }
                databaseController.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EpisodeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static final class PreparedStatements {

        static final String INSERT = "INSERT OR REPLACE INTO Episodes (episode_id,patient_id,intake_time,meg,triage_time,triage_level) values (?,?,?,?,?,?);";
        static final String UPDATE = "UPDATE OR ROLBACK Episodes SET episode_id = ?,patient_id = ?,intake_time = ?,meg = ?,triage_time = ?,triage_level = ? WHERE 1 = 1 AND episode_id = ?;";
        static final String DELETE = "DELETE * FROM Episodes WHERE 1 = 1 AND episode_id = ?;";
        static final String FIND = "SELECT * FROM Episodes WHERE 1 = 1 AND episode_id = ?;";
        static final String FINDALL = "SELECT * FROM Episodes;";
    }
}
