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
package timecloud.dto.request;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import timecloud.dto.Immutable;
import timecloud.model.request.Request;

/**
 * Abstract class as interface for the DTO paradigm on the request model
 *
 * @see Request
 * @see Immutable
 *
 * @author Pieter Van Eeckhout
 */
public abstract class RequestDTO implements Request, Immutable {

    final Request request;

    /**
     *
     * Constructor
     *
     * @param request The request from which to build this DTO
     * @see Request
     */
    public RequestDTO(Request request) {
        this.request = request;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setEpisodeID(long episodeID) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setEpisodeID is disabled");
        Logger.getLogger(RequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setIntakeDate(DateTime intakeDate) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setIntakeDate is disabled");
        Logger.getLogger(RequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setIntakeKind(String intakeKind) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setIntakeKind is disabled");
        Logger.getLogger(RequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setIntakeTimestamp(DateTime intakeTimestamp) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setIntakeTimestamp is disabled");
        Logger.getLogger(RequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setOwnDepartment(String ownDepartment) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setOwnDepartment is disabled");
        Logger.getLogger(RequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setPatientID(String patientID) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setPatientID is disabled");
        Logger.getLogger(RequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setRequestID(long requestID) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setRequestID is disabled");
        Logger.getLogger(RequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setRequestTimestamp(DateTime requestTimestamp) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setRequestTimestamp is disabled");
        Logger.getLogger(RequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setResponseTimestamp(DateTime responseTimestamp) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setResponseTimestamp is disabled");
        Logger.getLogger(RequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setStartDepartment(String startDepartment) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setStartDepartment is disabled");
        Logger.getLogger(RequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setStartMedicalDeparment(String StartMedicalDeparment) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setStartMedicalDeparment is disabled");
        Logger.getLogger(RequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    @Override
    /**
     * DO NOT USE, setters are disabled in the DTO paradigm
     */
    public void setTransferTimestamp(DateTime transferTimestamp) {
        UnsupportedOperationException ex = new UnsupportedOperationException("Immutable Object. Setter setTransferTimestamp is disabled");
        Logger.getLogger(RequestDTO.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }
}
