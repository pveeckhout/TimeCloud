/*******************************************************
 * Copyright (C) 20014 Pieter Van Eeckhout <vaneeckhout.pieter@gmail.com>
 * 
 * This file is part of TimeCloud.
 * 
 * TimeCloud can not be copied, edited and/or distributed without the express
 *  written permission of Pieter Van Eeckhout and Anne Charlotte Van de Velde
 *******************************************************/

package com.pietervaneeckhout.timecloud.controller;

import com.pietervaneeckhout.timecloud.model.Triage;
import java.util.List;

/**
 *
 * @author Pieter Van Eeckhout
 */
public interface TriageRepository {
    
    List<Triage> getAll();
    
    int getTriageCodeByName(String triageName);
    
    String getTriageNameByCode(int triageCode);
    
    void addTriage(Triage triage);
    
    boolean contains(Triage triage);
}
