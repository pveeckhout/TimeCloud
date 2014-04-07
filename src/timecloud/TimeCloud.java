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
import timecloud.controller.file.data.emergency.EmergencyDataFileController;
import timecloud.controller.file.data.emergency.EmergencyDataFileControllerImpl;
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
            DatabaseController databaseController = new DatabaseControllerSQLiteImpl("C:\\TEMP\\TimeCloud.sqlite");
            EpisodeDAO episodeDao = new EpisodeDaoImpl(databaseController);
            TransferDAO transferDao = new TransferDaoImpl(databaseController);
            EpisodeController episodeController = new EpisodeControllerImpl(episodeDao);
            TransferController transferController = new TransferControllerImpl(transferDao);
            EmergencyDataFileController emergencyDataFileController = new EmergencyDataFileControllerImpl(episodeDao, transferDao);
            emergencyDataFileController.addObserver(episodeController);
            emergencyDataFileController.addObserver(transferController);
            
            String path = "D:\\Users\\Pieter Van Eeckhout\\Dropbox\\Database voor data masterproef\\Kwantitatief onderzoek masterproef\\Data spoed\\";
            String files[] = {"Opnames op periode 03.03-10.03.xls","Opnames op periode 10.03 -17.03.xls","Opnames op periode 17.02 -03.04.xls","Opnames op periode 17.03 tot 02.04.xls"};
            
            
            
        } catch (Exception ex) {//here we do want to catch the all
            Logger.getLogger(TimeCloud.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
    }

}