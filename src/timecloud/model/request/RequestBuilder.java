/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timecloud.model.request;

import org.joda.time.DateTime;

/**
 *
 * @author Pieter Van Eeckhout
 */
public interface RequestBuilder {

    Request createRequest();

    RequestBuilderImpl setEpisodeID(long episodeID);

    RequestBuilderImpl setIntakeDate(DateTime intakeDate);

    RequestBuilderImpl setIntakeKind(String intakeKind);

    RequestBuilderImpl setIntakeTimestamp(DateTime intakeTimestamp);

    RequestBuilderImpl setOwnDepartment(String ownDepartment);

    RequestBuilderImpl setPatientID(String patientID);

    RequestBuilderImpl setRequestID(long requestID);

    RequestBuilderImpl setRequestTimestamp(DateTime requestTimestamp);

    RequestBuilderImpl setResponseTimestamp(DateTime responseTimestamp);

    RequestBuilderImpl setStartDepartment(String startDepartment);

    RequestBuilderImpl setStartMedicalDeparment(String StartMedicalDeparment);

    RequestBuilderImpl setTransferTimestamp(DateTime transferTimestamp);
    
}
