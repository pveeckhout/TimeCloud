/*******************************************************
 * Copyright (C) 2014 Pieter Van Eeckhout <vaneeckhout.pieter@gmail.com>
 * 
 * This file is part of TimeCloud.
 * 
 * TimeCloud can not be copied, edited and/or distributed without the express
 *  written permission of Pieter Van Eeckhout and Anne Charlotte Van de Velde
 *******************************************************/

package com.pietervaneeckhout.timecloud.controller.measurement;

import com.pietervaneeckhout.timecloud.controller.MeasurementController;
import com.pietervaneeckhout.timecloud.model.Measurement;
import java.util.List;

/**
 *
 * @author Pieter Van Eeckhout
 */
public class MeasurementControllerImpl implements MeasurementController {

    private List<Measurement> measurements;
    PersistenceController persistence;
    
    public MeasurementControllerImpl() {
        persistence = PersistenceController.getInstance();
    }

    MeasurementControllerImpl(List<Measurement> measurements) {
        this();
        this.measurements = measurements;
    }
    
    @Override
    public List<Measurement> getAll() {
        return measurements;
    }

    @Override
    public Measurement getByID(int id) throws IllegalArgumentException {
        for (Measurement measurement : measurements) {
            if (measurement.getMeasurementID()==id) {
                return measurement;
            }
        }
        
        throw new IllegalArgumentException("Measurement with ID: " + id + "not found");
    }

    @Override
    public Measurement add(Measurement measurement) {
        measurement = persistence.save(measurement);
        measurements.add(measurement);
        return measurement;
    }

    @Override
    public Measurement update(Measurement measurement) {
        measurement = persistence.update(measurement);
        
        for (Measurement measurement1 : measurements) {
            if (measurement1.getMeasurementID()==measurement.getMeasurementID()) {
                measurement1 = measurement;
                break;
            }
        }
        
        return measurement;
    }

    @Override
    public void delete(Measurement measurement) {
        persistence.remove(measurement);
        measurements.remove(measurement);
    }
    
}
