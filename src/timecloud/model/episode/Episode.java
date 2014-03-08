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

import java.io.Serializable;
import java.util.Collection;
import org.joda.time.DateTime;
import timecloud.enums.TriageLevel;
import timecloud.model.transfer.Transfer;

/**
 *
 * Model interface defining the available getters, setters, constructors and
 * operations for Episode
 *
 * @see Serializable
 *
 * @author Pieter Van Eeckhout
 */
public interface Episode extends Serializable {

    /**
     *
     * Sets the episodeID value
     *
     * @param episodeID
     */
    void setEpisodeID(long episodeID);

    /**
     *
     * Returns the episodeID value
     *
     * @return the episodeID
     */
    long getEpisodeID();

    /**
     *
     * Sets the patientID value
     *
     * @param patientID
     */
    void setPatientID(String patientID);

    /**
     *
     * Returns the patientID value
     *
     * @return the patientID
     */
    String getpatientID();

    /**
     *
     * Sets the intake timestamp value
     *
     * @param intakeTimestamp
     * @see DateTime
     */
    void setIntakeTimestamp(DateTime intakeTimestamp);

    /**
     *
     * Returns the intake timestamp value
     *
     * @return the intake timestamp
     * @see DateTime
     */
    DateTime getIntakeTimestamp();

    /**
     *
     * Sets whether or not the MEG/MUG was used
     *
     * @param meg
     */
    void setMeg(boolean meg);

    /**
     *
     * Returns whether or not the MEG/MUG was used
     *
     * @return boolean value
     */
    boolean getMeg();

    /**
     *
     * Sets the triage timestamp value
     *
     * @param triageTimestamp
     * @see DateTime
     */
    void setTriageTimestamp(DateTime triageTimestamp);

    /**
     *
     * Returns the triage timestamp value
     *
     * @return the triage timestamp
     * @see DateTime
     */
    DateTime getTriageTimestamp();

    /**
     *
     * Sets the triage level
     *
     * @param triageLevel
     * @see TriageLevel
     */
    void setTriageLevel(TriageLevel triageLevel);

    /**
     * Returns the triage level
     *
     * @return the triage level
     * @see TriageLevel
     */
    TriageLevel getTriageLevel();

    /**
     *
     * Returns a collection of all the transfers associated with this episode
     *
     * @return a collection of all the transfers
     * @see Transfer
     */
    Collection<Transfer> getTransfers();
}
