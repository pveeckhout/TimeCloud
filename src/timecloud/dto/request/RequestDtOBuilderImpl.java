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
import timecloud.model.request.RequestBuilder;
import timecloud.model.request.RequestBuilderImpl;

public class RequestDtOBuilderImpl implements RequestDtoBuilder {

    private final RequestBuilder requestBuilder;

    public RequestDtOBuilderImpl() {
        requestBuilder = new RequestBuilderImpl();
    }

    @Override
    public RequestDTO createRequestDto() {
        return new RequestDtoImpl(requestBuilder.createRequest());
    }

    @Override
    public RequestDtoBuilder setEpisodeID(long episodeID) {
        this.requestBuilder.setEpisodeID(episodeID);
        return this;
    }

    @Override
    public RequestDtoBuilder setIntakeDate(DateTime intakeDate) {
        this.requestBuilder.setIntakeDate(intakeDate);
        return this;
    }

    @Override
    public RequestDtoBuilder setIntakeKind(String intakeKind) {
        this.requestBuilder.setIntakeKind(intakeKind);
        return this;
    }

    @Override
    public RequestDtoBuilder setIntakeTimestamp(DateTime intakeTimestamp) {
        this.requestBuilder.setIntakeTimestamp(intakeTimestamp);
        return this;
    }

    @Override
    public RequestDtoBuilder setOwnDepartment(String ownDepartment) {
        this.requestBuilder.setOwnDepartment(ownDepartment);
        return this;
    }

    @Override
    public RequestDtoBuilder setPatientID(String patientID) {
        this.requestBuilder.setPatientID(patientID);
        return this;
    }

    @Override
    public RequestDtoBuilder setRequestID(long requestID) {
        this.requestBuilder.setRequestID(requestID);
        return this;
    }

    @Override
    public RequestDtoBuilder setRequestTimestamp(DateTime requestTimestamp) {
        this.requestBuilder.setRequestTimestamp(requestTimestamp);
        return this;
    }

    @Override
    public RequestDtoBuilder setResponseTimestamp(DateTime responseTimestamp) {
        this.requestBuilder.setResponseTimestamp(responseTimestamp);
        return this;
    }

    @Override
    public RequestDtoBuilder setStartDepartment(String startDepartment) {
        this.requestBuilder.setStartDepartment(startDepartment);
        return this;
    }

    @Override
    public RequestDtoBuilder setStartMedicalDeparment(String StartMedicalDeparment) {
        this.requestBuilder.setStartMedicalDeparment(StartMedicalDeparment);
        return this;
    }

    @Override
    public RequestDtoBuilder setTransferTimestamp(DateTime transferTimestamp) {
        this.requestBuilder.setTransferTimestamp(transferTimestamp);
        return this;
    }
}
