/*******************************************************
 * Copyright (C) 20014 Pieter Van Eeckhout <vaneeckhout.pieter@gmail.com>
 * 
 * This file is part of TimeCloud.
 * 
 * TimeCloud can not be copied, edited and/or distributed without the express
 *  written permission of Pieter Van Eeckhout and Anne Charlotte Van de Velde
 *******************************************************/

package com.pietervaneeckhout.timecloud.model.department;

import com.pietervaneeckhout.timecloud.model.Department;

/**
 *
 * @author Pieter Van Eeckhout
 */
public class DepartmentBuilder {
    private int departmentCode;
    private String departmentName;

    public DepartmentBuilder() {
        departmentCode = Integer.MIN_VALUE;
    }

    public DepartmentBuilder setDepartmentCode(int departmentCode) {
        this.departmentCode = departmentCode;
        return this;
    }

    public DepartmentBuilder setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public Department create() {
        if (isValidDepartmentName() && isValidDepartmentId()) {
            return new DepartmentImpl(departmentCode, departmentName);
        } else throw new IllegalArgumentException(getExeptionMessage());
    }

    private String getExeptionMessage() {
        String message = "";
        if (!isValidDepartmentId() || !isValidDepartmentName()) {
            message = "DepartmentBuilder: Invalid department ";
            if (!isValidDepartmentName()) {
                message += "name";
            }
            if (!isValidDepartmentId() && !isValidDepartmentName()) {
                message += " & ";
            }
            if (!isValidDepartmentId()) {
                message += "ID";
            }
        }
        return message;
    }

    private boolean isValidDepartmentName() {
       return (departmentCode == Integer.MIN_VALUE);
    }

    private boolean isValidDepartmentId() {
        return !(departmentName == null && departmentName.isEmpty());
    }
    
}
