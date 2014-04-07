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

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import timecloud.dao.episode.EpisodeDAO;
import timecloud.dto.episode.EpisodeDTO;
import timecloud.model.episode.Episode;

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
    private Map<Long, Episode> episodes;

    /**
     *
     * Constructor
     *
     * @param episodeDAO The class responsible for persisting Episode
     */
    public EpisodeControllerImpl(EpisodeDAO episodeDAO) {
        this.episodeDAO = episodeDAO;
    }

    @Override
    public void save(EpisodeDTO episodeDTO) throws SQLException {
        try {
            if (episodes == null) {
                getAllFromDB();
            }
            Episode episode;
            if (!episodes.containsKey(episodeDTO.getEpisodeID())) {
                episode = episodeDAO.create(episodeDTO);
            } else {
                episode = episodeDAO.update(episodeDTO);
                System.out.println("update an episode");
            }
            if (episode != null) {
                episodes.put(episode.getEpisodeID(), episode);
            } else {
                Logger.getLogger(EpisodeControllerImpl.class.getName()).log(Level.FINE, null, "episode added was null");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void getAllFromDB() throws SQLException {
        episodes = new TreeMap<>();
        Collection<Episode> result = episodeDAO.readAll();

        for (Episode episode : result) {
            episodes.put(episode.getEpisodeID(), episode);
        }
    }

    @Override
    public Episode getEpisode(long episodeNumber) throws SQLException {
        try {
            if (episodes == null) {
                getAllFromDB();
            }
            return episodes.get(episodeNumber);
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public Collection<Episode> getAllEpisodes() throws SQLException {
        if (episodes == null) {
            getAllFromDB();
        }
        return episodes.values();
    }

    @Override
    public void delete(long episodeID) throws SQLException {
        try {
            if (episodes == null) {
                getAllFromDB();
            }
            episodeDAO.delete(episodeID);
            episodes.remove(episodeID);
        } catch (SQLException ex) {
            Logger.getLogger(EpisodeControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
