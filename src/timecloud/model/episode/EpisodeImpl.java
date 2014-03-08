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
package timecloud.model.episode;

import java.util.Collection;
import java.util.Objects;
import org.joda.time.DateTime;
import timecloud.dto.episode.EpisodeDTO;
import timecloud.enums.TriageLevel;
import timecloud.model.transfer.Transfer;

/**
 *
 * Implementation of Episode
 *
 * @see Episode
 *
 * @author Pieter Van Eeckhout
 */
public final class EpisodeImpl implements Episode {

    public static final long serialVersionUID = 54154515L;

    long episodeID;
    String patientID;
    DateTime intakeTimestamp;
    boolean meg;
    DateTime triageTimestamp;
    TriageLevel triageLevel;

    Collection<Transfer> transfers;

    /**
     *
     * Default constructor
     *
     */
    public EpisodeImpl() {
    }

    /**
     *
     * Constructor
     *
     * @param episodeID the episodeID value
     * @param patientID the patientID value
     * @param intakeTimestamp the intake timestamp value
     * @param meg whether or not the MEG/MUG was used
     * @param triageTimestamp the triage timestamp value
     * @param triageLevel the triage level
     * @param transfers collection of all the transfers associated with this
     * episode
     */
    EpisodeImpl(long episodeID, String patientID, DateTime intakeTimestamp, boolean meg, DateTime triageTimestamp, TriageLevel triageLevel, Collection<Transfer> transfers) {
        this.episodeID = episodeID;
        this.patientID = patientID;
        this.intakeTimestamp = intakeTimestamp;
        this.meg = meg;
        this.triageTimestamp = triageTimestamp;
        this.triageLevel = triageLevel;
        this.transfers = transfers;
    }

    /**
     *
     * Constructor
     *
     * @param episodeDTO The data from which this episode will be made
     * @see EpisodeDTO
     */
    public EpisodeImpl(EpisodeDTO episodeDTO) {
        this.setEpisodeID(episodeDTO.getEpisodeID());
        this.setPatientID(episodeDTO.getpatientID());
        this.setIntakeTimestamp(episodeDTO.getIntakeTimestamp());
        this.setMeg(episodeDTO.getMeg());
        this.setTriageTimestamp(episodeDTO.getTriageTimestamp());
        this.setTriageLevel(episodeDTO.getTriageLevel());
    }

    @Override
    public void setEpisodeID(long episodeID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getEpisodeID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPatientID(String patientID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getpatientID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIntakeTimestamp(DateTime intakeTimestamp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DateTime getIntakeTimestamp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMeg(boolean meg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getMeg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTriageTimestamp(DateTime triageTimestamp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DateTime getTriageTimestamp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTriageLevel(TriageLevel triageLevel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TriageLevel getTriageLevel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Transfer> getTransfers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.episodeID ^ (this.episodeID >>> 32));
        hash = 83 * hash + Objects.hashCode(this.patientID);
        hash = 83 * hash + Objects.hashCode(this.intakeTimestamp);
        hash = 83 * hash + (this.meg ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.triageTimestamp);
        hash = 83 * hash + Objects.hashCode(this.triageLevel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EpisodeImpl other = (EpisodeImpl) obj;
        if (this.episodeID != other.episodeID) {
            return false;
        }
        if (!Objects.equals(this.patientID, other.patientID)) {
            return false;
        }
        if (!Objects.equals(this.intakeTimestamp, other.intakeTimestamp)) {
            return false;
        }
        if (this.meg != other.meg) {
            return false;
        }
        if (!Objects.equals(this.triageTimestamp, other.triageTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.triageLevel, other.triageLevel)) {
            return false;
        }
        return true;
    }
}
