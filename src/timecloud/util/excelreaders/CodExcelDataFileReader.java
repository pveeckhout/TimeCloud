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
package timecloud.util.excelreaders;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import timecloud.dto.request.RequestDTO;

public class CodExcelDataFileReader extends ExcelDataFileReader {
    public static final Integer EPISODEID_ROW = 1;

    private void primeData(File file) throws IOException {
        setExcelFile(file);
        processStoredData();
    }
    
    public Map<Long, RequestDTO> getRequests(File file) throws IOException {
        long startTime = System.nanoTime();
        primeData(file);
        Map<Long, RequestDTO> requests = new TreeMap<>();
        for (Row row : sheet) {
            if (row.getCell(EPISODEID_ROW).getCellType() != HSSFCell.CELL_TYPE_NUMERIC || row.getCell(EPISODEID_ROW).getCellType() != HSSFCell.CELL_TYPE_STRING) {
                    continue;
            }
            RequestDTO requestDTO = getRequestData(row);
            requests.put(requestDTO.getEpisodeID(), requestDTO);
        }
        
        System.out.println("getRequests from file time taken: " +  (System.nanoTime() - startTime)/1000000000 + " seconds");
        return requests;
    }

    private RequestDTO getRequestData(Row row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
