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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.joda.time.DateTime;
import timecloud.dto.episode.EpisodeDTO;
import timecloud.dto.episode.EpisodeDtoBuilder;
import timecloud.dto.episode.EpisodeDtoBuilderImpl;
import timecloud.dto.transfer.TransferDTO;
import timecloud.dto.transfer.TransferDtoBuilder;
import timecloud.dto.transfer.TransferDtoBuilderImpl;
import timecloud.enums.TriageLevel;

/**
 *
 * Implementation of ExcelDataFileReader
 *
 * @author Pieter Van Eeckhout
 */
public class EmergencyExcelDataFileReader extends ExcelDataFileReader {

    public static final Integer PATIENTID_ROW = 0;
    public static final Integer EPISODEID_ROW = 3;
    public static final Integer INTAKETIME_ROW = 8;
    public static final Integer MEG_ROW = 10;
    public static final Integer TRIAGETIME_ROW = 14;
    public static final Integer TRIAGELEVEL_ROW = 16;
    public static final Integer TRANSFERTIME_ROW = 17;
    public static final Integer STARTDEPARTMENT_ROW = 18;
    public static final Integer STARTBED_ROW = 19;
    public static final Integer STARTMEDICALDEPARTMENT_ROW = 20;
    public static final Integer ENDDEPARTMENT_ROW = 21;
    public static final Integer ENDBED_ROW = 22;
    public static final Integer ENDMEDICALDEPARTMENT_ROW = 23;

    private void primeData(File file) throws IOException {
        setExcelFile(file);
        processStoredData();
    }

    public Collection<EpisodeDTO> getEpisodes(File file) throws IOException {
        long startTime = System.nanoTime();
        primeData(file);
        Map<Long, EpisodeDTO> episodes = new TreeMap<>();
        for (Row row : sheet) {
            if (row.getCell(EPISODEID_ROW).getCellType() != HSSFCell.CELL_TYPE_NUMERIC) {
                continue;
            }
            EpisodeDTO episodeDto = getEpisodeData(row);
            episodes.put(episodeDto.getEpisodeID(), episodeDto);
        }
        
        System.out.println("getEpisode from file time taken: " +  (System.nanoTime() - startTime));
        return episodes.values();
    }

    private EpisodeDTO getEpisodeData(Row row) {
        EpisodeDtoBuilder episodeDtoBuilder = new EpisodeDtoBuilderImpl();
        episodeDtoBuilder.setEpisodeID((long) row.getCell(EPISODEID_ROW).getNumericCellValue()); //casting simply truncates, which is what we want.
        episodeDtoBuilder.setPatientID(row.getCell(PATIENTID_ROW).getStringCellValue());
        episodeDtoBuilder.setIntakeTimestamp(new DateTime(row.getCell(INTAKETIME_ROW).getDateCellValue().getTime()));
        //this can be empty or null
        if (row.getCell(MEG_ROW) != null) {
            episodeDtoBuilder.setMeg(row.getCell(MEG_ROW).getStringCellValue().equalsIgnoreCase("ja"));
        }
        //this can be empty or null
        if (row.getCell(TRIAGETIME_ROW) != null) {
            episodeDtoBuilder.setTriageTimestamp(new DateTime(row.getCell(TRIAGETIME_ROW).getDateCellValue().getTime()));
        }
        TriageLevel triageLevel = (row.getCell(TRIAGELEVEL_ROW) == null || row.getCell(TRIAGELEVEL_ROW).getCellType() == HSSFCell.CELL_TYPE_BLANK) ? TriageLevel.UNDEFINED : TriageLevel.fromString(row.getCell(TRIAGELEVEL_ROW).getStringCellValue());
        episodeDtoBuilder.setTriageLevel(triageLevel);

        return episodeDtoBuilder.createEpisodeDto();
    }

    public Map<Long, Collection<TransferDTO>> getTransfers(File file) throws IOException {
        long startTime = System.nanoTime();
        primeData(file);
        Map<Long, Collection<TransferDTO>> transfers = new TreeMap<>();
        for (Row row : sheet) {
            if (row.getCell(EPISODEID_ROW).getCellType() != HSSFCell.CELL_TYPE_NUMERIC) {
                continue;
            }
            long episodeID = (long) row.getCell(EPISODEID_ROW).getNumericCellValue();
            if (transfers.get(episodeID) == null) {
                transfers.put(episodeID, new ArrayList<TransferDTO>());
            }
            transfers.get(episodeID).add(getTransfersData(row));
        }

        System.out.println("getTransfers from file time taken: " +  (System.nanoTime() - startTime));
        return transfers;
    }

    private TransferDTO getTransfersData(Row row) {
        TransferDtoBuilder transferDtoBuilder = new TransferDtoBuilderImpl();
        transferDtoBuilder.setTransferTimestamp(new DateTime(row.getCell(TRANSFERTIME_ROW).getDateCellValue().getTime()));
        transferDtoBuilder.setStartDepartment(row.getCell(STARTDEPARTMENT_ROW).getStringCellValue());
        if (row.getCell(STARTBED_ROW).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            transferDtoBuilder.setStartBed(row.getCell(STARTBED_ROW).getNumericCellValue() + "");
        } else {
            transferDtoBuilder.setStartBed(row.getCell(STARTBED_ROW).getStringCellValue());
        }
        transferDtoBuilder.setStartMedicalDepartment(row.getCell(STARTMEDICALDEPARTMENT_ROW).getStringCellValue());
        transferDtoBuilder.setEndDepartment(row.getCell(ENDDEPARTMENT_ROW).getStringCellValue());
        if (row.getCell(ENDBED_ROW).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            transferDtoBuilder.setEndBed(row.getCell(ENDBED_ROW).getNumericCellValue() + "");
        } else {
            transferDtoBuilder.setEndBed(row.getCell(ENDBED_ROW).getStringCellValue());
        }
        transferDtoBuilder.setEndMedicalDepartment(row.getCell(ENDMEDICALDEPARTMENT_ROW).getStringCellValue());

        return transferDtoBuilder.createTransferDto();
    }
}
