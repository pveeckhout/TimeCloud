/*******************************************************
 * Copyright (C) 20014 Pieter Van Eeckhout <vaneeckhout.pieter@gmail.com>
 * 
 * This file is part of TimeCloud.
 * 
 * TimeCloud can not be copied, edited and/or distributed without the express
 *  written permission of Pieter Van Eeckhout and Anne Charlotte Van de Velde
 *******************************************************/

package com.pietervaneeckhout.timecloud.model;

import com.pietervaneeckhout.timecloud.model.triage.TriageImpl;
import com.pietervaneeckhout.timecloud.model.department.DepartmentImpl;
import org.joda.time.DateTime;

/**
 *
 * @author Pieter Van Eeckhout
 */
public interface Measurement {
    
    DateTime getArrivalTime();

    DateTime getContactCODTime();

    String getBufferBed();

    String getPatientNumber();

    DateTime getReadyTransferTime();

    DateTime getStartTreatmentTime();

    DateTime getStopTreatmentTime();

    DepartmentImpl getTargetDepartment();
    
    int getMeasurementID();

    long getTimeBetweenArrivalCodContact();

    long getTimeBetweenArrivalTransport();

    long getTimeBetweenArrivalTransportReady();

    long getTimeBetweenArrivalTreatmentStart();

    long getTimeBetweenArrivalTreatmentStop();

    long getTimeBetweenTransportReadyCodContact();

    long getTimeBetweenTransportReadyTransport();

    long getTimeBetweenTreatmentStartCodContact();

    long getTimeBetweenTreatmentStartTranport();

    long getTimeBetweenTreatmentStartTreatmentStop();

    long getTimeBetweenTreatmentStartTreatmentTransportReady();

    long getTimeBetweenTreatmentStopTransport();

    long getTimeBetweenTreatmentStopTransportCodContact();

    long getTimeBetweenTreatmentStopTransportReady();

    DateTime getTransferTime();

    TriageImpl getTriage();
    
    void setMeasurementID(int measurementID);

    void setArrivalTime(DateTime arrivalTime);

    void setContactCODTime(DateTime contactCODTime);

    void setBufferBed(String EmergencyBufferSpot);

    void setPatientNumber(String patientNumber);

    void setReadyTransferTime(DateTime readyTransferTime);

    void setStartTreatmentTime(DateTime startTreatmentTime);

    void setStopTreatmentTime(DateTime stopTreatmentTime);

    void setTargetDepartment(DepartmentImpl targetDepartment);

    void setTransferTime(DateTime transferTime);

    void setTriage(TriageImpl triage);
    
}
