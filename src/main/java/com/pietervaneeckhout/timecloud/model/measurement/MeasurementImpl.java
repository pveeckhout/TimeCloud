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
 *******************************************************//*******************************************************
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
import com.pietervaneeckhout.timecloud.model.triage.TriageImpl;
import com.pietervaneeckhout.timecloud.model.department.DepartmentImpl;
import java.util.Objects;
import org.joda.time.DateTime;

/**
 *
 * @author Pieter Van Eeckhout
 */
public class MeasurementImpl implements Measurement {
    
    private int measurementID;
    private DateTime arrivalTime;
    private String patientNumber;
    private TriageImpl triage;
    private DateTime startTreatmentTime;
    private DateTime stopTreatmentTime;
    private DateTime readyTransferTime;
    private DateTime contactCODTime;
    private String bufferBed;
    private DateTime transferTime;
    private DepartmentImpl targetDepartment;

    public MeasurementImpl() {
    }

    MeasurementImpl(int MeasurementID, DateTime arrivalTime, String patientNumber, TriageImpl triage, DateTime startTreatmentTime, DateTime endTreatmentTime, DateTime readyTransferTime, DateTime contactCODTime, String EmergencyBufferSpot, DateTime transferTime, DepartmentImpl targetDepartment) {
        this.measurementID = MeasurementID;
        this.arrivalTime = arrivalTime;
        this.patientNumber = patientNumber;
        this.triage = triage;
        this.startTreatmentTime = startTreatmentTime;
        this.stopTreatmentTime = endTreatmentTime;
        this.readyTransferTime = readyTransferTime;
        this.contactCODTime = contactCODTime;
        this.bufferBed = EmergencyBufferSpot;
        this.transferTime = transferTime;
        this.targetDepartment = targetDepartment;
    }

    @Override
    public int getMeasurementID() {
        return measurementID;
    }

    @Override
    public void setMeasurementID(int measurementID) {
        this.measurementID = measurementID;
    }
    
    @Override
    public DateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public void setArrivalTime(DateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String getPatientNumber() {
        return patientNumber;
    }

    @Override
    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    @Override
    public TriageImpl getTriage() {
        return triage;
    }

    @Override
    public void setTriage(TriageImpl triage) {
        this.triage = triage;
    }

    @Override
    public DateTime getStartTreatmentTime() {
        return startTreatmentTime;
    }

    @Override
    public void setStartTreatmentTime(DateTime startTreatmentTime) {
        this.startTreatmentTime = startTreatmentTime;
    }

    @Override
    public DateTime getStopTreatmentTime() {
        return stopTreatmentTime;
    }

    @Override
    public void setStopTreatmentTime(DateTime stopTreatmentTime) {
        this.stopTreatmentTime = stopTreatmentTime;
    }

    @Override
    public DateTime getReadyTransferTime() {
        return readyTransferTime;
    }

    @Override
    public void setReadyTransferTime(DateTime readyTransferTime) {
        this.readyTransferTime = readyTransferTime;
    }

    @Override
    public DateTime getContactCODTime() {
        return contactCODTime;
    }

    @Override
    public void setContactCODTime(DateTime contactCODTime) {
        this.contactCODTime = contactCODTime;
    }

    @Override
    public String getBufferBed() {
        return bufferBed;
    }

    @Override
    public void setBufferBed(String bufferBed) {
        this.bufferBed = bufferBed;
    }

    @Override
    public DateTime getTransferTime() {
        return transferTime;
    }

    @Override
    public void setTransferTime(DateTime transferTime) {
        this.transferTime = transferTime;
    }

    @Override
    public DepartmentImpl getTargetDepartment() {
        return targetDepartment;
    }

    @Override
    public void setTargetDepartment(DepartmentImpl targetDepartment) {
        this.targetDepartment = targetDepartment;
    }
    
    @Override
    public long getTimeBetweenArrivalTreatmentStart() {
        return startTreatmentTime.getMillis() - arrivalTime.getMillis();
    }
    
    @Override
    public long getTimeBetweenArrivalTreatmentStop() {
        return stopTreatmentTime.getMillis() - arrivalTime.getMillis();
    }
    
    @Override
    public long getTimeBetweenArrivalTransportReady() {
        return readyTransferTime.getMillis() - arrivalTime.getMillis();
    }
    
    @Override
    public long getTimeBetweenArrivalCodContact() {
        return contactCODTime.getMillis() - arrivalTime.getMillis();
    }
    
    @Override
    public long getTimeBetweenArrivalTransport() {
        return transferTime.getMillis() - arrivalTime.getMillis();
    }
    
    @Override
    public long getTimeBetweenTreatmentStartTreatmentStop() {
        return stopTreatmentTime.getMillis() - startTreatmentTime.getMillis();
    }
    
    @Override
    public long getTimeBetweenTreatmentStartTreatmentTransportReady() {
        return readyTransferTime.getMillis() - startTreatmentTime.getMillis();
    }
    
    @Override
    public long getTimeBetweenTreatmentStartCodContact() {
        return contactCODTime.getMillis() - startTreatmentTime.getMillis();
    }
    
    @Override
    public long getTimeBetweenTreatmentStartTranport() {
        return transferTime.getMillis() - startTreatmentTime.getMillis();
    }
    
    @Override
    public long getTimeBetweenTreatmentStopTransportReady() {
        return readyTransferTime.getMillis() - stopTreatmentTime.getMillis();
    }
    
    @Override
    public long getTimeBetweenTreatmentStopTransportCodContact() {
        return contactCODTime.getMillis() - stopTreatmentTime.getMillis();
    }
    
    @Override
    public long getTimeBetweenTreatmentStopTransport() {
        return transferTime.getMillis() - stopTreatmentTime.getMillis();
    }
    
    @Override
    public long getTimeBetweenTransportReadyCodContact() {
        return contactCODTime.getMillis() - readyTransferTime.getMillis();
    }
    
    @Override
    public long getTimeBetweenTransportReadyTransport() {
        return transferTime.getMillis() - readyTransferTime.getMillis();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.arrivalTime);
        hash = 11 * hash + Objects.hashCode(this.patientNumber);
        hash = 11 * hash + Objects.hashCode(this.triage);
        hash = 11 * hash + Objects.hashCode(this.startTreatmentTime);
        hash = 11 * hash + Objects.hashCode(this.stopTreatmentTime);
        hash = 11 * hash + Objects.hashCode(this.readyTransferTime);
        hash = 11 * hash + Objects.hashCode(this.contactCODTime);
        hash = 11 * hash + Objects.hashCode(this.bufferBed);
        hash = 11 * hash + Objects.hashCode(this.transferTime);
        hash = 11 * hash + Objects.hashCode(this.targetDepartment);
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
        final MeasurementImpl other = (MeasurementImpl) obj;
        if (!Objects.equals(this.arrivalTime, other.arrivalTime)) {
            return false;
        }
        if (!Objects.equals(this.patientNumber, other.patientNumber)) {
            return false;
        }
        return Objects.equals(this.triage, other.triage);
    }
    
}
