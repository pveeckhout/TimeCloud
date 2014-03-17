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
package timecloud.dto.episode;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import timecloud.dto.Immutable;
import timecloud.enums.TriageLevel;
import timecloud.model.episode.Episode;

/**
 *
 * Abstract class as interface for the DTO paradigm on the episode model
 *
 * @see Episode
 * @see Immutable
 *
 * @author Pieter Van Eeckhout
 */
public abstract class EpisodeDTO implements Episode, Immutable {

    final Episode episode;

    /**
     *
     * Constructor
     *
     * @param episode The episode from which to build this DTO
     * @see Episode
     */
    public EpisodeDTO(Episode episode) {
        this.episode = episode;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public final void setEpisodeID(long episodeID) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setEpisodeID is disabled");
        Logger.getLogger(EpisodeDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setPatientID(String patientID) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setPatientID is disabled");
        Logger.getLogger(EpisodeDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setIntakeTimestamp(DateTime intakeTimestamp) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setIntakeTimestamp is disabled");
        Logger.getLogger(EpisodeDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setMeg(boolean meg) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setMeg is disabled");
        Logger.getLogger(EpisodeDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setTriageTimestamp(DateTime triageTimestamp) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setTriageTimestamp is disabled");
        Logger.getLogger(EpisodeDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setTriageLevel(TriageLevel triageLevel) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setTriageLevel is disabled");
        Logger.getLogger(EpisodeDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }       
}
