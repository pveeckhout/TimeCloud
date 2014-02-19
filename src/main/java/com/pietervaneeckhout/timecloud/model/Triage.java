/*******************************************************
 * Copyright (C) 20014 Pieter Van Eeckhout <vaneeckhout.pieter@gmail.com>
 * 
 * This file is part of TimeCloud.
 * 
 * TimeCloud can not be copied, edited and/or distributed without the express
 *  written permission of Pieter Van Eeckhout and Anne Charlotte Van de Velde
 *******************************************************/
package com.pietervaneeckhout.timecloud.model;

/**
 *
 * @author Pieter Van Eeckhout
 */
public interface Triage {

    int getTriageCode();

    String getTriageName();

    void setTriageCode(int triageCode);

    void setTriageName(String triageName);
    
}
