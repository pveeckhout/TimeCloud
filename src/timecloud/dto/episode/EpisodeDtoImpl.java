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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import org.joda.time.DateTime;
import timecloud.dto.transfer.TransferDtoImpl;
import timecloud.enums.TriageLevel;
import timecloud.model.episode.Episode;
import timecloud.model.transfer.Transfer;
import timecloud.model.transfer.TransferImpl;

/**
 *
 * Implementation of EpisodeDTO
 *
 * @see EpisodeDTO
 *
 * @author Pieter Van Eeckhout
 */
public class EpisodeDtoImpl extends EpisodeDTO {

    /**
     *
     * Constructor
     *
     * @param episode The episode from which to build this DTO
     * @see Episode
     */
    EpisodeDtoImpl(Episode episode) {
        super(episode);
    }

    @Override
    public long getEpisodeID() {
        return episode.getEpisodeID();
    }

    @Override
    public String getpatientID() {
        return episode.getpatientID();
    }

    @Override
    public DateTime getIntakeTimestamp() {
        return episode.getIntakeTimestamp();
    }

    @Override
    public boolean getMeg() {
        return episode.getMeg();
    }

    @Override
    public DateTime getTriageTimestamp() {
        return episode.getTriageTimestamp();
    }

    @Override
    public TriageLevel getTriageLevel() {
        return episode.getTriageLevel();
    }

    @Override
    public Collection<Transfer> getTransfers() {
        Collection<Transfer> transfers = new ArrayList<>(episode.getTransfers().size());
        for (Transfer transfer : episode.getTransfers()) {
            transfers.add(new TransferImpl(new TransferDtoImpl(transfer)));
        }
        return transfers;
    }

    @Override
    public void addTransfer(Transfer transfer) {
        episode.getTransfers().add(transfer);
    }

    @Override
    public void addTransfers(Collection<Transfer> transfers) {
        episode.getTransfers().addAll(transfers);
    }
}
