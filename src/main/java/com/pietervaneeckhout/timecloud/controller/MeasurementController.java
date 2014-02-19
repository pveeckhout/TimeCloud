/*******************************************************
 * Copyright (C) 2014 Pieter Van Eeckhout <vaneeckhout.pieter@gmail.com>
 * 
 * This file is part of TimeCloud.
 * 
 * TimeCloud can not be copied, edited and/or distributed without the express
 *  written permission of Pieter Van Eeckhout and Anne Charlotte Van de Velde
 *******************************************************/

package com.pietervaneeckhout.timecloud.controller;

import com.pietervaneeckhout.timecloud.model.Measurement;
import java.util.List;

/**
 *
 * @author Pieter Van Eeckhout
 */
public interface MeasurementController {
    
    List<Measurement> getAll();
    
    Measurement getByID(int id) throws IllegalArgumentException;
    
    Measurement add(Measurement measurement);
    
    Measurement update(Measurement measurement);
    
    void delete(Measurement measurement);
    
}
