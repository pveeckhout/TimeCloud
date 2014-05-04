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

import org.joda.time.DateTime;
import timecloud.model.request.Request;

public class RequestDtoImpl extends RequestDTO {

    /**
     *
     * Constructor
     *
     * @param request The request from which to build this DTO
     * @see Request
     */
    RequestDtoImpl(Request request) {
        super(request);
    }

    @Override
    public long getEpisodeID() {
        return request.getEpisodeID();
    }

    @Override
    public DateTime getIntakeDate() {
        return new DateTime(request.getIntakeDate().getMillis());
    }

    @Override
    public String getIntakeKind() {
        return request.getIntakeKind();
    }

    @Override
    public DateTime getIntakeTimestamp() {
        return request.getIntakeTimestamp();
    }

    @Override
    public String getOwnDepartment() {
        return request.getOwnDepartment();
    }

    @Override
    public String getPatientID() {
        return request.getPatientID();
    }

    @Override
    public long getRequestID() {
        return request.getRequestID();
    }

    @Override
    public DateTime getRequestTimestamp() {
        return request.getRequestTimestamp();
    }

    @Override
    public DateTime getResponseTimestamp() {
        return request.getResponseTimestamp();
    }

    @Override
    public String getStartDepartment() {
        return request.getStartDepartment();
    }

    @Override
    public String getStartMedicalDeparment() {
        return request.getStartMedicalDeparment();
    }

    @Override
    public DateTime getTransferTimestamp() {
        return request.getTransferTimestamp();
    }

}
