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
package timecloud.model.transfer;

import java.util.Objects;
import org.joda.time.DateTime;
import timecloud.dto.transfer.TransferDTO;

/**
 *
 * Implementation of Transfer
 *
 * @see Transfer
 *
 * @author Pieter Van Eeckhout
 */
public class TransferImpl implements Transfer {

    public static final long serialVersionUID = 84610981L;

    private DateTime transferTimestamp;
    private String startDepartment;
    private String startBed;
    private String StartMedicalDeparment;
    private String endDepartment;
    private String endBed;
    private String endMedicalDepartment;
    private long transferID;

    /**
     *
     * Default constructor
     *
     */
    public TransferImpl() {
    }

    /**
     *
     * Constructor
     *
     * @param transferTimestamp the time when the transfer took place
     * @param startDepartment the start department
     * @param startBed the start bed
     * @param StartMedicalDeparment the start medical department
     * @param endDepartment the end department
     * @param endBed the end bed
     * @param endMedicalDepartment the end medical department
     */
    TransferImpl(long transferID, DateTime transferTimestamp, String startDepartment, String startBed, String StartMedicalDeparment, String endDepartment, String endBed, String endMedicalDepartment) {
        this.transferID = transferID;
        this.transferTimestamp = transferTimestamp;
        this.startDepartment = startDepartment;
        this.startBed = startBed;
        this.StartMedicalDeparment = StartMedicalDeparment;
        this.endDepartment = endDepartment;
        this.endBed = endBed;
        this.endMedicalDepartment = endMedicalDepartment;
    }

    /**
     *
     * Constructor
     *
     * @param transferDTO The data from which this transfer will be made
     * @see TransferDTO
     */
    public TransferImpl(TransferDTO transferDTO) {
        this.transferID = transferDTO.getTransferID();
        this.transferTimestamp = transferDTO.getTransferTimestamp();
        this.startDepartment = transferDTO.getStartDepartment();
        this.startBed = transferDTO.getStartBed();
        this.StartMedicalDeparment = transferDTO.getStartMedicalDepartment();
        this.endDepartment = transferDTO.getEndDepartment();
        this.endBed = transferDTO.getEndBed();
        this.endMedicalDepartment = transferDTO.getEndMedicalDepartment();
    }
    
    @Override
    public long getTransferID() {
        return transferID;
    }
    
    @Override
    public void setTransferID(long transferID) {
        this.transferID = transferID;
    }

    @Override
    public DateTime getTransferTimestamp() {
        return transferTimestamp;
    }

    @Override
    public void setTransferTimestamp(DateTime transferTimestamp) {
        this.transferTimestamp = transferTimestamp;
    }

    @Override
    public String getStartDepartment() {
        return startDepartment;
    }

    @Override
    public void setStartDepartment(String startDepartment) {
        this.startDepartment = startDepartment;
    }

    @Override
    public String getStartBed() {
        return startBed;
    }

    @Override
    public void setStartBed(String startBed) {
        this.startBed = startBed;
    }

    @Override
    public String getStartMedicalDepartment() {
        return StartMedicalDeparment;
    }

    @Override
    public void setStartMedicalDeparment(String StartMedicalDeparment) {
        this.StartMedicalDeparment = StartMedicalDeparment;
    }

    @Override
    public String getEndDepartment() {
        return endDepartment;
    }

    @Override
    public void setEndDepartment(String endDepartment) {
        this.endDepartment = endDepartment;
    }

    @Override
    public String getEndBed() {
        return endBed;
    }

    @Override
    public void setEndBed(String endBed) {
        this.endBed = endBed;
    }

    @Override
    public String getEndMedicalDepartment() {
        return endMedicalDepartment;
    }

    @Override
    public void setEndMedicalDepartment(String endMedicalDepartment) {
        this.endMedicalDepartment = endMedicalDepartment;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.transferTimestamp);
        hash = 97 * hash + Objects.hashCode(this.startDepartment);
        hash = 97 * hash + Objects.hashCode(this.startBed);
        hash = 97 * hash + Objects.hashCode(this.StartMedicalDeparment);
        hash = 97 * hash + Objects.hashCode(this.endDepartment);
        hash = 97 * hash + Objects.hashCode(this.endBed);
        hash = 97 * hash + Objects.hashCode(this.endMedicalDepartment);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TransferImpl other = (TransferImpl) obj;
        if (!Objects.equals(this.transferTimestamp, other.transferTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.startDepartment, other.startDepartment)) {
            return false;
        }
        if (!Objects.equals(this.startBed, other.startBed)) {
            return false;
        }
        if (!Objects.equals(this.StartMedicalDeparment, other.StartMedicalDeparment)) {
            return false;
        }
        if (!Objects.equals(this.endDepartment, other.endDepartment)) {
            return false;
        }
        if (!Objects.equals(this.endBed, other.endBed)) {
            return false;
        }
        if (!Objects.equals(this.endMedicalDepartment, other.endMedicalDepartment)) {
            return false;
        }
        return true;
    }
}
