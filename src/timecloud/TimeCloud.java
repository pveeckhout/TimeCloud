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
package timecloud;

import java.util.logging.Level;
import java.util.logging.Logger;
import timecloud.controller.database.DatabaseController;
import timecloud.controller.database.DatabaseControllerSQLiteImpl;
import timecloud.controller.episode.EpisodeController;
import timecloud.controller.episode.EpisodeControllerImpl;
import timecloud.controller.transfer.TransferController;
import timecloud.controller.transfer.TransferControllerImpl;
import timecloud.dao.episode.EpisodeDAO;
import timecloud.dao.episode.EpisodeDaoImpl;
import timecloud.dao.transfer.TransferDAO;
import timecloud.dao.transfer.TransferDaoImpl;

/**
 * This is the startup class for the TimeCloud program
 *
 * @author Pieter Van Eeckhout
 */
public class TimeCloud {
    
    /**
     *
     * Startup method of TimeCloud
     *
     * @param args the command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            DatabaseController databaseController = new DatabaseControllerSQLiteImpl("D:\\Users\\Pieter Van Eeckhout\\Code\\TimeCloud\\database\\TimeCloud.sqlite");
            EpisodeDAO episodeDao = new EpisodeDaoImpl(databaseController);
            TransferDAO transferDao = new TransferDaoImpl(databaseController);
            EpisodeController episodeController = new EpisodeControllerImpl(episodeDao);
            TransferController transferController = new TransferControllerImpl(transferDao);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeCloud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
