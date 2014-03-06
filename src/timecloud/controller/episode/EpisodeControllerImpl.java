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
import java.util.TreeMap;
import timecloud.controller.EpisodeController;
import timecloud.dao.EpisodeDAO;
import timecloud.model.episode.Episode;
import timecloud.dto.EpisodeDTO;

/**
 *
 * Implementation of EpisodeController
 * 
 * @see EpisodeController
 * 
 * @author Pieter Van Eeckhout
 */
public final class EpisodeControllerImpl implements EpisodeController {
    
    private final EpisodeDAO episodeDAO;
    private final Map<Long, Episode> episodes;

    /**
     * 
     * Constructor
     * 
     * @param episodeDAO The class responsible for persisting Episode
     */
    public EpisodeControllerImpl(EpisodeDAO episodeDAO) {
        this.episodeDAO = episodeDAO;
        episodes = new TreeMap<>();
        episodes.putAll(getAllFromDB());
    }
    
    @Override
    public void save(EpisodeDTO episodeDTO) {
        Episode episode;
        if (!episodes.containsKey(episodeDTO.getEpisodeID())) {
            episode = episodeDAO.create(episodeDTO);
        } else {
            episode = episodeDAO.update(episodeDTO);
        }
        if (episode != null) { 
            episodes.put(episode.getEpisodeID(), episode);
        }
    }
    
    @Override
    public Map<Long, Episode> getAllFromDB() {
        Collection<Episode> result = episodeDAO.readAll();
        
        Map<Long, Episode> resultEpisodes = new TreeMap<>();
        
        for (Episode episode : result) {
            resultEpisodes.put(episode.getEpisodeID(), episode);
        }
        
        return resultEpisodes;
    }
    
    @Override
    public Episode getEpisode(long episodeNumber) {
        return episodes.get(episodeNumber);
    }
    
    @Override
    public Collection<Episode> getAllEpisodes() {
        return episodes.values();
    }
    
    @Override
    public void delete(long episodeID) {
        episodeDAO.delete(episodeID);
        episodes.remove(episodeID);
    }
}
