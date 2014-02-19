/*******************************************************
 * Copyright (C) 20014 Pieter Van Eeckhout <vaneeckhout.pieter@gmail.com>
 * 
 * This file is part of TimeCloud.
 * 
 * TimeCloud can not be copied, edited and/or distributed without the express
 *  written permission of Pieter Van Eeckhout and Anne Charlotte Van de Velde
 *******************************************************/

package com.pietervaneeckhout.timecloud.model.triage;

import com.pietervaneeckhout.timecloud.model.Triage;

/**
 *
 * @author Pieter Van Eeckhout
 */
public class TriageBuilder {
    private String triageName;
    private int triageCode;

    public TriageBuilder() {
    }

    public TriageBuilder setTriageName(String triageName) {
        this.triageName = triageName;
        return this;
    }

    public TriageBuilder setTriageCode(int triageCode) {
        this.triageCode = triageCode;
        return this;
    }

    public Triage create() {
        if (isValidTriageName() && isValidTriageId()) {
            return new TriageImpl(triageCode, triageName);
        } else throw new IllegalArgumentException(getExeptionMessage());
    }

    private String getExeptionMessage() {
        String message = "";
        if (!isValidTriageId() || !isValidTriageName()) {
            message = "TriageBuilder: Invalid triage ";
            if (!isValidTriageName()) {
                message += "name";
            }
            if (!isValidTriageId() && !isValidTriageName()) {
                message += " & ";
            }
            if (!isValidTriageId()) {
                message += "ID";
            }
        }
        return message;
    }

    private boolean isValidTriageName() {
       return (triageCode == Integer.MIN_VALUE);
    }

    private boolean isValidTriageId() {
        return !(triageName == null && triageName.isEmpty());
    }
}
