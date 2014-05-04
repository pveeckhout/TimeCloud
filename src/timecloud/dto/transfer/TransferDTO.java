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
package timecloud.dto.transfer;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import timecloud.dto.Immutable;
import timecloud.model.transfer.Transfer;

/**
 * Abstract class as interface for the DTO paradigm on the transfer model
 *
 * @see Transfer
 * @see Immutable
 *
 * @author Pieter Van Eeckhout
 */
public abstract class TransferDTO implements Transfer, Immutable {

    final Transfer transfer;

    /**
     *
     * Constructor
     *
     * @param transfer The transfer from which to build this DTO
     * @see Transfer
     */
    TransferDTO(Transfer transfer) {
        this.transfer = transfer;
    }
    
    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setEndBed(String endBed) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setEndBed is disabled");
        Logger.getLogger(TransferDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setEndDepartment(String endDepartment) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setEndDepartment is disabled");
        Logger.getLogger(TransferDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setEndMedicalDepartment(String endMedicalDepartment) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setEndMedicalDepartment is disabled");
        Logger.getLogger(TransferDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setStartBed(String startBed) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setStartBed is disabled");
        Logger.getLogger(TransferDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setStartDepartment(String startDepartment) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setStartDepartment is disabled");
        Logger.getLogger(TransferDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setStartMedicalDeparment(String StartMedicalDeparment) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setStartMedicalDeparment is disabled");
        Logger.getLogger(TransferDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setTransferTimestamp(DateTime transferTimestamp) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setTransferTimestamp is disabled");
        Logger.getLogger(TransferDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }
    
    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setTransferID(long transferID) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setTransferID is disabled");
        Logger.getLogger(TransferDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

}
