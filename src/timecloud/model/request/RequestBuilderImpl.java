/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timecloud.model.request;

import org.joda.time.DateTime;


public class RequestBuilderImpl implements RequestBuilder {
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

    public RequestBuilderImpl() {
    }

    @Override
    public RequestBuilderImpl setRequestID(long requestID) {
        this.requestID = requestID;
        return this;
    }

    @Override
    public RequestBuilderImpl setPatientID(String patientID) {
        this.patientID = patientID;
        return this;
    }

    @Override
    public RequestBuilderImpl setEpisodeID(long episodeID) {
        this.episodeID = episodeID;
        return this;
    }

    @Override
    public RequestBuilderImpl setIntakeKind(String intakeKind) {
        this.intakeKind = intakeKind;
        return this;
    }

    @Override
    public RequestBuilderImpl setIntakeTimestamp(DateTime intakeTimestamp) {
        this.intakeTimestamp = intakeTimestamp;
        return this;
    }

    @Override
    public RequestBuilderImpl setStartDepartment(String startDepartment) {
        this.startDepartment = startDepartment;
        return this;
    }

    @Override
    public RequestBuilderImpl setStartMedicalDeparment(String StartMedicalDeparment) {
        this.StartMedicalDeparment = StartMedicalDeparment;
        return this;
    }

    @Override
    public RequestBuilderImpl setRequestTimestamp(DateTime requestTimestamp) {
        this.requestTimestamp = requestTimestamp;
        return this;
    }

    @Override
    public RequestBuilderImpl setResponseTimestamp(DateTime responseTimestamp) {
        this.responseTimestamp = responseTimestamp;
        return this;
    }

    @Override
    public RequestBuilderImpl setTransferTimestamp(DateTime transferTimestamp) {
        this.transferTimestamp = transferTimestamp;
        return this;
    }

    @Override
    public RequestBuilderImpl setIntakeDate(DateTime intakeDate) {
        this.intakeDate = intakeDate;
        return this;
    }

    @Override
    public RequestBuilderImpl setOwnDepartment(String ownDepartment) {
        this.ownDepartment = ownDepartment;
        return this;
    }

    @Override
    public Request createRequest() {
        return new RequestImpl(requestID, patientID, episodeID, intakeKind, intakeTimestamp, startDepartment, StartMedicalDeparment, requestTimestamp, responseTimestamp, transferTimestamp, intakeDate, ownDepartment);
    }
    
}
