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
 *//*
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * Abstract class implementing basic functionality for the reading of excel
 * files
 *
 * @author Pieter Van Eeckhout
 */
public abstract class ExcelFileReader {

    HSSFWorkbook ExcelWorkbook;
    HSSFSheet sheet;
    HSSFCell[][] sheetData;
    int sheetNumber;

    /**
     *
     * sets the file to be used
     *
     * @param file an excel file
     * @throws FileNotFoundException
     * @throws IOException
     */
    void setExcelFile(File file) throws FileNotFoundException, IOException {
        try {
            this.ExcelWorkbook = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(file)));
            Logger.getLogger(ExcelFileReader.class.getName()).log(Level.INFO, null, "ExcelFile: " + file.getName() + " loaded.");
            this.sheetNumber = 0;
            this.sheet = ExcelWorkbook.getSheetAt(sheetNumber);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelFileReader.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IOException ex) {
            Logger.getLogger(ExcelFileReader.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    /**
     *
     * gets the current excel worksheet
     *
     * @return the sheet object
     * @see HSSFSheet
     */
    public HSSFSheet getSheet() {
        return sheet;
    }

    /**
     *
     * gets the current excel worksheet index
     *
     * @return the sheet index (0-based)
     */
    public int getSheetNumber() {
        return sheetNumber;
    }

    /**
     *
     * Sets the index of the sheet in use and change the current sheet
     *
     * @param sheetNumber the index of the sheet
     */
    public void setSheetNumber(int sheetNumber) {
        if (ExcelWorkbook != null && ExcelWorkbook.getSheetAt(sheetNumber) != null) {
            this.sheetNumber = sheetNumber;
            this.sheet = ExcelWorkbook.getSheetAt(sheetNumber);
        }
    }

    /**
     *
     * stores the data contained in the current sheet in a two-dimensional
     * HSSFCell array.
     *
     * @see HSSFCell
     */
    void processStoredData() {
        int rows = sheet.getPhysicalNumberOfRows();
        sheetData = new HSSFCell[rows][];
        Logger.getLogger(ExcelFileReader.class.getName()).log(Level.INFO, null, "Processing excel: found " + rows + " rows.");

        for (int r = 0; r < 10 || r < rows; r++) {
            HSSFRow row = sheet.getRow(r);
            if (row != null) {
                int collumns = sheet.getRow(r).getPhysicalNumberOfCells();
                Logger.getLogger(ExcelFileReader.class.getName()).log(Level.INFO, null, "Processing excel: found " + collumns + " collumns on row " + r + ".");
                sheetData[r] = new HSSFCell[collumns];
                for (int c = 0; c < collumns; c++) {
                    HSSFCell cell = row.getCell(c);
                    if (cell != null) {
                        sheetData[r][c] = cell;
                    }
                }
            }
        }
    }

    /**
     *
     * Retuns the data contained in the current sheet in a two-dimensional
     *
     * @return a two-dimensional HSSFCell array of the
     */
    public HSSFCell[][] getSheetData() {
        return sheetData;
    }
}
