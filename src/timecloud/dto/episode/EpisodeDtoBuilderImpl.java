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

import java.util.Collection;
import org.joda.time.DateTime;
import timecloud.dto.transfer.TransferDTO;
import timecloud.enums.TriageLevel;
import timecloud.model.episode.EpisodeBuilder;
import timecloud.model.episode.EpisodeBuilderImpl;

public class EpisodeDtoBuilderImpl implements EpisodeDtoBuilder {

    private final EpisodeBuilder episodeBuilder;

    public EpisodeDtoBuilderImpl() {
        episodeBuilder = new EpisodeBuilderImpl();
    }

    @Override
    public EpisodeDtoBuilderImpl setEpisodeID(long episodeID) {
        this.episodeBuilder.setEpisodeID(episodeID);
        return this;
    }

    @Override
    public EpisodeDtoBuilderImpl setPatientID(String patientID) {
        this.episodeBuilder.setPatientID(patientID);
        return this;
    }

    @Override
    public EpisodeDtoBuilderImpl setIntakeTimestamp(DateTime intakeTimestamp) {
        this.episodeBuilder.setIntakeTimestamp(intakeTimestamp);
        return this;
    }

    @Override
    public EpisodeDtoBuilderImpl setMeg(boolean meg) {
        this.episodeBuilder.setMeg(meg);
        return this;
    }

    @Override
    public EpisodeDtoBuilderImpl setTriageTimestamp(DateTime triageTimestamp) {
        this.episodeBuilder.setTriageTimestamp(triageTimestamp);
        return this;
    }

    @Override
    public EpisodeDtoBuilderImpl setTriageLevel(TriageLevel triageLevel) {
        this.episodeBuilder.setTriageLevel(triageLevel);
        return this;
    }

    @Override
    public EpisodeDtoImpl createEpisodeDto() {
        return new EpisodeDtoImpl(episodeBuilder.createEpisode());
    }

}
