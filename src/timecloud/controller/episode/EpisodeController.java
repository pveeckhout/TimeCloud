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
package timecloud.controller.episode;

import java.util.Collection;
import java.util.Map;
import timecloud.model.episode.Episode;
import timecloud.dto.episode.EpisodeDTO;

/**
 *
 * Controller interface defining the available operations on Episodes
 *
 * @author Pieter Van Eeckhout
 */
public interface EpisodeController {

    /**
     *
     * Save an episode to the DB and the repository
     *
     * @param episodeDTO The data of the episode to be saved. If the episodeID
     * is set, the episode will be updated. Else it will be created.
     * @see Episode
     * @see EpisodeDTO
     */
    void save(EpisodeDTO episodeDTO);

    /**
     *
     * Returns map of all the episodes stored in the database.
     *
     * @return Map containing the Episodes, with the episodeIDs as key values.
     * @see Episode
     */
    Map<Long, Episode> getAllFromDB();

    /**
     *
     * Returns the episode with the supplied ID.
     *
     * @param episodeNumber the ID of the requested episode.
     * @return An Episode object.
     * @see Episode
     */
    public Episode getEpisode(long episodeNumber);

    /**
     *
     * Returns a collection of all the episodes stored in the database.
     *
     * @return Collection containing the Episodes.
     * @see Episode
     */
    public Collection<Episode> getAllEpisodes();

    /**
     *
     * Deletes the episode with the supplied ID.
     *
     * @param episodeID The ID of the episode to delete.
     */
    public void delete(long episodeID);
}
