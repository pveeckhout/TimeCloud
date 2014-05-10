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
package timecloud.controller.file.data.cod;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import timecloud.dao.request.RequestDAO;
import timecloud.model.request.Request;
import timecloud.util.excelreaders.CodExcelDataFileReader;

/**
 *
 * @author Pieter Van Eeckhout
 */
public abstract class CodDataFileController extends Observable {

    protected CodExcelDataFileReader fileReader;

    protected RequestDAO requestDao;

    protected Map<Long, Request> requests;

    public CodDataFileController(RequestDAO requestDao) {
        this.requestDao = requestDao;
        fileReader = new CodExcelDataFileReader();
    }
    
    public void readCodDataFile(String pathToFile, String... files) {
        for (int i = 0; i < files.length; i++) {
            try {
                Logger.getLogger(CodDataFileController.class.getName()).log(Level.INFO, null, "processing file " + (i + 1) + " of " + files.length);
                File file = new File(pathToFile + files[i]);
                readRequestsFromFile(file);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(CodDataFileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    abstract void readRequestsFromFile(File file) throws IOException, SQLException;
}
