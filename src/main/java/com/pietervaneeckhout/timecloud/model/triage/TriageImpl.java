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
import java.util.Objects;

/**
 *
 * @author Pieter Van Eeckhout
 */
public class TriageImpl implements Triage {

    private String triageName;
    private int triageCode;
    
    public TriageImpl() {
    }
    
    TriageImpl(int triageCode, String triageName) {
        this.triageName = triageName;
        this.triageCode = triageCode;
    }

    @Override
    public String getTriageName() {
        return triageName;
    }

    @Override
    public void setTriageName(String triageName) {
        this.triageName = triageName;
    }

    @Override
    public int getTriageCode() {
        return triageCode;
    }

    @Override
    public void setTriageCode(int triageCode) {
        this.triageCode = triageCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.triageName);
        hash = 37 * hash + this.triageCode;
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
        final TriageImpl other = (TriageImpl) obj;
        if (this.triageCode != other.triageCode) {
            return false;
        }
        return true;
    }

    
}
