/*******************************************************
 * Copyright (C) 20014 Pieter Van Eeckhout <vaneeckhout.pieter@gmail.com>
 * 
 * This file is part of TimeCloud.
 * 
 * TimeCloud can not be copied, edited and/or distributed without the express
 *  written permission of Pieter Van Eeckhout and Anne Charlotte Van de Velde
 *******************************************************//*******************************************************
 * Copyright (C) 20014 Pieter Van Eeckhout <vaneeckhout.pieter@gmail.com>
 * 
 * This file is part of TimeCloud.
 * 
 * TimeCloud can not be copied, edited and/or distributed without the express
 *  written permission of Pieter Van Eeckhout and Anne Charlotte Van de Velde
 *******************************************************/

package com.pietervaneeckhout.timecloud.model.measurement;

import com.pietervaneeckhout.timecloud.model.Measurement;
import com.pietervaneeckhout.timecloud.model.department.DepartmentImpl;
import com.pietervaneeckhout.timecloud.model.triage.TriageImpl;
import org.joda.time.DateTime;

/**
 *
 * @author Pieter Van Eeckhout
 */
public class MeasuremenBuilder {
    private int measurementID;
    private DateTime arrivalTime;
    private String patientNumber;
    private TriageImpl triage;
    private DateTime startTreatmentTime;
    private DateTime endTreatmentTime;
    private DateTime readyTransferTime;
    private DateTime contactCODTime;
    private String EmergencyBufferSpot;
    private DateTime transferTime;
    private DepartmentImpl targetDepartment;

    public MeasuremenBuilder() {
    }
    
    public MeasuremenBuilder setMeasurementID(int measurementID) {
        this.measurementID = measurementID;
        return this;
    }

    public MeasuremenBuilder setArrivalTime(DateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public MeasuremenBuilder setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
        return this;
    }

    public MeasuremenBuilder setTriage(TriageImpl triage) {
        this.triage = triage;
        return this;
    }

    public MeasuremenBuilder setStartTreatmentTime(DateTime startTreatmentTime) {
        this.startTreatmentTime = startTreatmentTime;
        return this;
    }

    public MeasuremenBuilder setEndTreatmentTime(DateTime endTreatmentTime) {
        this.endTreatmentTime = endTreatmentTime;
        return this;
    }

    public MeasuremenBuilder setReadyTransferTime(DateTime readyTransferTime) {
        this.readyTransferTime = readyTransferTime;
        return this;
    }

    public MeasuremenBuilder setContactCODTime(DateTime contactCODTime) {
        this.contactCODTime = contactCODTime;
        return this;
    }

    public MeasuremenBuilder setEmergencyBufferSpot(String EmergencyBufferSpot) {
        this.EmergencyBufferSpot = EmergencyBufferSpot;
        return this;
    }

    public MeasuremenBuilder setTransferTime(DateTime transferTime) {
        this.transferTime = transferTime;
        return this;
    }

    public MeasuremenBuilder setTargetDepartment(DepartmentImpl targetDepartment) {
        this.targetDepartment = targetDepartment;
        return this;
    }

    public Measurement createMeasurementImpl() {
        return new MeasurementImpl(measurementID, arrivalTime, patientNumber, triage, startTreatmentTime, endTreatmentTime, readyTransferTime, contactCODTime, EmergencyBufferSpot, transferTime, targetDepartment);
    }
    
}
