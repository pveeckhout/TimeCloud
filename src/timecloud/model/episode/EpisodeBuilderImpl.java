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

import org.joda.time.DateTime;
import timecloud.enums.TriageLevel;

/**
 *
 * Implementation for the Builder paradigm on the episode model
 *
 * @author Pieter Van Eeckhout
 */
public class EpisodeBuilderImpl implements EpisodeBuilder {

    private long episodeID;
    private String patientID;
    private DateTime intakeTimestamp;
    private boolean meg;
    private DateTime triageTimestamp;
    private TriageLevel triageLevel;

    @Override
    public EpisodeBuilderImpl setEpisodeID(long episodeID) {
        this.episodeID = episodeID;
        return this;
    }

    @Override
    public EpisodeBuilderImpl setPatientID(String patientID) {
        this.patientID = patientID;
        return this;
    }

    @Override
    public EpisodeBuilderImpl setIntakeTimestamp(DateTime intakeTimestamp) {
        this.intakeTimestamp = intakeTimestamp;
        return this;
    }

    @Override
    public EpisodeBuilderImpl setMeg(boolean meg) {
        this.meg = meg;
        return this;
    }

    @Override
    public EpisodeBuilderImpl setTriageTimestamp(DateTime triageTimestamp) {
        this.triageTimestamp = triageTimestamp;
        return this;
    }

    @Override
    public EpisodeBuilderImpl setTriageLevel(TriageLevel triageLevel) {
        this.triageLevel = triageLevel;
        return this;
    }

    @Override
    public EpisodeImpl createEpisode() {
        return new EpisodeImpl(episodeID, patientID, intakeTimestamp, meg, triageTimestamp, triageLevel);
    }

}
