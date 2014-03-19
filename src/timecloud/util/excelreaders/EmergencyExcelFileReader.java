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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.joda.time.DateTime;
import timecloud.dto.episode.EpisodeDtoBuilder;
import timecloud.dto.episode.EpisodeDtoBuilderImpl;
import timecloud.dto.transfer.TransferDtoBuilder;
import timecloud.dto.transfer.TransferDtoBuilderImpl;
import timecloud.enums.TriageLevel;
import timecloud.model.transfer.Transfer;

/**
 *
 * Implementation of ExcelFileReader
 *
 * @author Pieter Van Eeckhout
 */
public class EmergencyExcelFileReader extends ExcelFileReader {

    public void readEmergencyData(File file) throws IOException {
        try {
            setExcelFile(file);
            processStoredData();

            EpisodeDtoBuilder episodeDtoBuilder = new EpisodeDtoBuilderImpl();
            TransferDtoBuilder transferDtoBuilder = new TransferDtoBuilderImpl();

            Collection<Transfer> transfers = new ArrayList<>();

            int x = 0, y = 0;
            for (HSSFCell[] cellRow : sheetData) {
                if (cellRow != null) {
                    y++;
                    x = 0;
                    for (HSSFCell cell : cellRow) {
                        x++;
                        if (y == 1) {
                            if (cell != null && cell.getCellType() != HSSFCell.CELL_TYPE_BLANK) {
                                System.out.println(cell.getStringCellValue());
                            }
                        } else {
                            if (cell != null && cell.getCellType() != HSSFCell.CELL_TYPE_BLANK) {
                                System.out.println(cell.toString());
                                switch (x) {
                                    case 1:
                                        episodeDtoBuilder.setPatientID(cell.getStringCellValue());
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        episodeDtoBuilder.setEpisodeID((long) Math.floor(cell.getNumericCellValue()));
                                        break;
                                    case 5:
                                        break;
                                    case 6:
                                        break;
                                    case 7:
                                        break;
                                    case 8:
                                        break;
                                    case 9:
                                        episodeDtoBuilder.setIntakeTimestamp(new DateTime(cell.getDateCellValue().getTime()));
                                        break;
                                    case 10:
                                        break;
                                    case 11:
                                        episodeDtoBuilder.setMeg(cell.getStringCellValue().equalsIgnoreCase("ja"));
                                        break;
                                    case 12:
                                        break;
                                    case 13:
                                        break;
                                    case 14:
                                        break;
                                    case 15:
                                        episodeDtoBuilder.setTriageTimestamp(new DateTime(cell.getDateCellValue().getTime()));
                                        break;
                                    case 16:
                                        break;
                                    case 17:
                                        episodeDtoBuilder.setTriageLevel(TriageLevel.fromString(cell.getStringCellValue()));
                                        break;
                                    case 18:
                                        transferDtoBuilder.setTransferTimestamp(new DateTime(cell.getDateCellValue().getTime()));
                                        break;
                                    case 19:
                                        transferDtoBuilder.setStartDepartment(cell.getStringCellValue());
                                        break;
                                    case 20:
                                        transferDtoBuilder.setStartBed(cell.getStringCellValue());
                                        break;
                                    case 21:
                                        transferDtoBuilder.setStartMedicalDepartment(cell.getStringCellValue());
                                        break;
                                    case 22:
                                        transferDtoBuilder.setEndDepartment(cell.getStringCellValue());
                                        break;
                                    case 23:
                                        transferDtoBuilder.setEndBed(cell.getStringCellValue());
                                        break;
                                    case 24:
                                        transferDtoBuilder.setEndMedicalDepartment(cell.getStringCellValue());
                                        break;
                                    default:
                                        throw new IOException("could not consolidate column number");
                                }

                                transfers.add(transferDtoBuilder.createTransferDto());
                            }
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(EmergencyExcelFileReader.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
