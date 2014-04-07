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

import java.sql.SQLException;
import java.util.Collection;
import timecloud.dto.episode.EpisodeDTO;
import timecloud.model.episode.Episode;

/**
 *
 * DAO interface defining the available CRUD operations on Episodes
 *
 * @author Pieter Van Eeckhout
 */
public interface EpisodeDAO {

    /**
     * Save a new episode to the database
     *
     * @param episodeDTO The data of the episode to be saved.
     * @return The episode object created by saving the EpisodeDTO to the
     * database
     * @throws java.sql.SQLException
     * @see Episode
     * @see EpisodeDTO
     */
    Episode create(EpisodeDTO episodeDTO) throws SQLException;
    
    /**
     *
     * gets a single Episode from the database
     *
     * @param episodeID The data of the episode to be updated.
     * @return The episode object linked to the ID
     * @throws java.sql.SQLException
     * @see Episode
     */
    Episode find(long episodeID) throws SQLException;

    /**
     *
     * Update an existing Episode in the database
     *
     * @param episodeDTO The data of the episode to be updated.
     * @return The episode object created by saving the EpisodeDTO to the
     * database
     * @throws java.sql.SQLException
     * @see Episode
     * @see EpisodeDTO
     */
    Episode update(EpisodeDTO episodeDTO) throws SQLException;

    /**
     * Returns a collection of all the episodes stored in the database.
     *
     * @return Collection containing the Episodes.
     * @throws java.sql.SQLException
     * @see Episode
     */
    Collection<Episode> readAll() throws SQLException;

    /**
     * Deletes the episode with the supplied ID from the database.
     *
     * @param episodeID The ID of the episode to delete.
     * @throws java.sql.SQLException
     */
    void delete(long episodeID) throws SQLException;

    /**
     * Add a whole batch of episodes
     * 
     * @param episodes the episodes to add
     * @return a collection of the added episodes
     * @see EpisodeDTO
     * @see Episode
     */
    public Collection<Episode> batchProcess(Collection<EpisodeDTO> episodes) throws SQLException;
}
