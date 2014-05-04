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
package timecloud.model.request;

import java.util.Objects;
import org.joda.time.DateTime;
import timecloud.dto.request.RequestDTO;

/**
 *
 * Implementation of Request
 *
 * @see Request
 *
 * @author Pieter Van Eeckhout
 */
public class RequestImpl implements Request {
    
    public static final long serialVersionUID = 4616485441L;
    
    private long requestID;
    private String patientID;
    private long episodeID;
    private String intakeKind;
    private DateTime intakeTimestamp;
    private String startDepartment;
    private String StartMedicalDeparment;
    private DateTime requestTimestamp;
    private DateTime responseTimestamp;
    private DateTime transferTimestamp;
    private DateTime intakeDate;
    private String ownDepartment;
    
    /**
     * 
     * Default constructor
     * 
     */
    public RequestImpl() {
    }

    /**
     * 
     * constructor
     * 
     * @param requestID
     * @param patientID
     * @param episodeID
     * @param intakeKind
     * @param intakeTimestamp
     * @param startDepartment
     * @param StartMedicalDeparment
     * @param requestTimestamp
     * @param responseTimestamp
     * @param transferTimestamp
     * @param intakeDate
     * @param ownDepartment 
     */
    RequestImpl(long requestID, String patientID, long episodeID, String intakeKind, DateTime intakeTimestamp, String startDepartment, String StartMedicalDeparment, DateTime requestTimestamp, DateTime responseTimestamp, DateTime transferTimestamp, DateTime intakeDate, String ownDepartment) {
        this.requestID = requestID;
        this.patientID = patientID;
        this.episodeID = episodeID;
        this.intakeKind = intakeKind;
        this.intakeTimestamp = intakeTimestamp;
        this.startDepartment = startDepartment;
        this.StartMedicalDeparment = StartMedicalDeparment;
        this.requestTimestamp = requestTimestamp;
        this.responseTimestamp = responseTimestamp;
        this.transferTimestamp = transferTimestamp;
        this.intakeDate = intakeDate;
        this.ownDepartment = ownDepartment;
    }
    
     /**
     *
     * Constructor
     *
     * @param requestDTO The data from which this transfer will be made
     * @see RequestDTO
     */
    public RequestImpl(RequestDTO requestDTO) {
        this.requestID = requestDTO.getRequestID();
        this.patientID = requestDTO.getPatientID();
        this.episodeID = requestDTO.getEpisodeID();
        this.intakeKind = requestDTO.getIntakeKind();
        this.intakeTimestamp = requestDTO.getIntakeTimestamp();
        this.startDepartment = requestDTO.getStartDepartment();
        this.StartMedicalDeparment = requestDTO.getStartMedicalDeparment();
        this.requestTimestamp = requestDTO.getRequestTimestamp();
        this.responseTimestamp = requestDTO.getResponseTimestamp();
        this.transferTimestamp = requestDTO.getTransferTimestamp();
        this.intakeDate = requestDTO.getIntakeDate();
        this.ownDepartment = requestDTO.getOwnDepartment();
    }

    @Override
    public long getRequestID() {
        return requestID;
    }

    @Override
    public void setRequestID(long requestID) {
        this.requestID = requestID;
    }

    @Override
    public String getPatientID() {
        return patientID;
    }

    @Override
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    @Override
    public long getEpisodeID() {
        return episodeID;
    }

    @Override
    public void setEpisodeID(long episodeID) {
        this.episodeID = episodeID;
    }

    @Override
    public String getIntakeKind() {
        return intakeKind;
    }

    @Override
    public void setIntakeKind(String intakeKind) {
        this.intakeKind = intakeKind;
    }

    @Override
    public DateTime getIntakeTimestamp() {
        return intakeTimestamp;
    }

    @Override
    public void setIntakeTimestamp(DateTime intakeTimestamp) {
        this.intakeTimestamp = intakeTimestamp;
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
    public String getStartMedicalDeparment() {
        return StartMedicalDeparment;
    }

    @Override
    public void setStartMedicalDeparment(String StartMedicalDeparment) {
        this.StartMedicalDeparment = StartMedicalDeparment;
    }

    @Override
    public DateTime getRequestTimestamp() {
        return requestTimestamp;
    }

    @Override
    public void setRequestTimestamp(DateTime requestTimestamp) {
        this.requestTimestamp = requestTimestamp;
    }

    @Override
    public DateTime getResponseTimestamp() {
        return responseTimestamp;
    }

    @Override
    public void setResponseTimestamp(DateTime responseTimestamp) {
        this.responseTimestamp = responseTimestamp;
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
    public DateTime getIntakeDate() {
        return intakeDate;
    }

    @Override
    public void setIntakeDate(DateTime intakeDate) {
        this.intakeDate = intakeDate;
    }

    @Override
    public String getOwnDepartment() {
        return ownDepartment;
    }

    @Override
    public void setOwnDepartment(String ownDepartment) {
        this.ownDepartment = ownDepartment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.patientID);
        hash = 83 * hash + (int) (this.episodeID ^ (this.episodeID >>> 32));
        hash = 83 * hash + Objects.hashCode(this.intakeKind);
        hash = 83 * hash + Objects.hashCode(this.intakeTimestamp);
        hash = 83 * hash + Objects.hashCode(this.startDepartment);
        hash = 83 * hash + Objects.hashCode(this.StartMedicalDeparment);
        hash = 83 * hash + Objects.hashCode(this.requestTimestamp);
        hash = 83 * hash + Objects.hashCode(this.responseTimestamp);
        hash = 83 * hash + Objects.hashCode(this.transferTimestamp);
        hash = 83 * hash + Objects.hashCode(this.intakeDate);
        hash = 83 * hash + Objects.hashCode(this.ownDepartment);
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
        final RequestImpl other = (RequestImpl) obj;
        if (!Objects.equals(this.patientID, other.patientID)) {
            return false;
        }
        if (this.episodeID != other.episodeID) {
            return false;
        }
        if (!Objects.equals(this.intakeKind, other.intakeKind)) {
            return false;
        }
        if (!Objects.equals(this.intakeTimestamp, other.intakeTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.startDepartment, other.startDepartment)) {
            return false;
        }
        if (!Objects.equals(this.StartMedicalDeparment, other.StartMedicalDeparment)) {
            return false;
        }
        if (!Objects.equals(this.requestTimestamp, other.requestTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.responseTimestamp, other.responseTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.transferTimestamp, other.transferTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.intakeDate, other.intakeDate)) {
            return false;
        }
        if (!Objects.equals(this.ownDepartment, other.ownDepartment)) {
            return false;
        }
        return true;
    }

    
}
