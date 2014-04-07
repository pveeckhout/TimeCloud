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
package timecloud.controller.file.data.emergency;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import timecloud.controller.episode.EpisodeControllerImpl;
import timecloud.controller.transfer.TransferControllerImpl;
import timecloud.dao.episode.EpisodeDAO;
import timecloud.dao.transfer.TransferDAO;
import timecloud.model.transfer.Transfer;

/**
 *
 * Controller interface defining the available operations for datafile
 * interactions
 *
 * @author Pieter Van Eeckhout
 */
public class EmergencyDataFileControllerImpl extends EmergencyDataFileController {
    
    public EmergencyDataFileControllerImpl(EpisodeDAO episodeDao, TransferDAO transferDao) {
        super(episodeDao, transferDao);
    }


    @Override
    public void readEpisodesFromFile(File file) throws IOException, SQLException {
        try {
            episodes = new ArrayList<>();
            long startTime = System.nanoTime();
            episodes.addAll(episodeDao.batchProcess(fileReader.getEpisodes(file)));
            this.notifyObservers(episodes);
            System.out.println("Episodes add from file time taken: " + (System.nanoTime() - startTime));
        } catch (IOException ex) {
            Logger.getLogger(EpisodeControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void readTransfersFromFile(File file) throws IOException, SQLException {
        try {
            transfers = new HashMap<>();
            long startTime = System.nanoTime();
            transfers.putAll(transferDao.batchAddEpisodes(fileReader.getTransfers(file)));
            this.notifyObservers(transfers);
            System.out.println("Transfers add from file time taken: " + (System.nanoTime() - startTime));
        } catch (IOException ex) {
            Logger.getLogger(TransferControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
