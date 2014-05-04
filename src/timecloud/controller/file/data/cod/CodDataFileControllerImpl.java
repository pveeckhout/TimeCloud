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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import timecloud.dao.request.RequestDAO;

public class CodDataFileControllerImpl extends CodDataFileController {

    public CodDataFileControllerImpl(RequestDAO requestDao) {
        super(requestDao);
    }

    @Override
    public void readRequestsFromFile(File file) throws IOException, SQLException {
        try {
            long startTime = System.nanoTime();
            requests = new HashMap<>();
            requests.putAll(requestDao.batchAddRequests(fileReader.getRequests(file)));
            this.notifyObservers(requests);
            System.out.println("Requests add from file time taken: " + (System.nanoTime() - startTime)/1000000000 + " seconds");
        } catch (IOException ex) {
            Logger.getLogger(CodDataFileControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
