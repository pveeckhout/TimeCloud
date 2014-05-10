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
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.joda.time.DateTime;
import timecloud.dto.request.RequestDTO;
import timecloud.dto.request.RequestDtOBuilderImpl;
import timecloud.dto.request.RequestDtoBuilder;

public class CodExcelDataFileReader extends ExcelDataFileReader {
    public static final Integer PATIENTID_COL = 0;
    public static final Integer EPISODEID_COL = 1;
    public static final Integer EPISODEKIND_COL = 2;
    public static final Integer INTAKETIME_COL = 3;
    public static final Integer ENDDEPARTMENT_COL = 4;
    public static final Integer ENDMEDICALDEPARTMENT_COL = 5;
    public static final Integer REQUESTTIME_COL = 6;
    public static final Integer RESPONSETIME_COL = 7;
    public static final Integer TRANSFERTIME_COL = 8;
    public static final Integer INTAKERDATE_COL = 12;
    public static final Integer OWNDEPARTMENT_COL = 13;

    private void primeData(File file) throws IOException {
        setExcelFile(file);
        processStoredData();
    }
    
    public Map<Long, RequestDTO> getRequests(File file) throws IOException {
        long startTime = System.nanoTime();
        primeData(file);
        Map<Long, RequestDTO> requests = new TreeMap<>();
        for (Row row : sheet) {
            if (row.getCell(EPISODEID_COL).getCellType() != HSSFCell.CELL_TYPE_NUMERIC) {
                    continue;
            }
            RequestDTO requestDTO = getRequestData(row);
            requests.put(requestDTO.getEpisodeID(), requestDTO);
        }
        
        System.out.println("getRequests from file time taken: " +  (System.nanoTime() - startTime)/1000000 + " miliseconds");
        return requests;
    }

    private RequestDTO getRequestData(Row row) {
        RequestDtoBuilder requestDtoBuilder = new RequestDtOBuilderImpl();
        requestDtoBuilder.setPatientID(row.getCell(PATIENTID_COL).getStringCellValue());
        long episodeID = (long) row.getCell(EPISODEID_COL).getNumericCellValue();
        requestDtoBuilder.setEpisodeID(episodeID);
        requestDtoBuilder.setIntakeTimestamp(new DateTime(row.getCell(INTAKETIME_COL).getDateCellValue().getTime()));
        requestDtoBuilder.setEndDepartment(row.getCell(ENDDEPARTMENT_COL).getStringCellValue());
        requestDtoBuilder.setEndMedicalDeparment(row.getCell(ENDMEDICALDEPARTMENT_COL).getStringCellValue());
        requestDtoBuilder.setRequestTimestamp(new DateTime(row.getCell(REQUESTTIME_COL).getDateCellValue().getTime()));
        requestDtoBuilder.setResponseTimestamp(new DateTime(row.getCell(RESPONSETIME_COL).getDateCellValue().getTime()));
        requestDtoBuilder.setTransferTimestamp(new DateTime(row.getCell(TRANSFERTIME_COL).getDateCellValue().getTime()));

        String dateSt = row.getCell(INTAKERDATE_COL).getStringCellValue();
        String date[] = dateSt.split("-");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        requestDtoBuilder.setIntakeDate(new DateTime(year, month, day, 0 ,0));
        requestDtoBuilder.setOwnDepartment(row.getCell(OWNDEPARTMENT_COL).getStringCellValue());
        
        return requestDtoBuilder.createRequestDto();
    }
}
