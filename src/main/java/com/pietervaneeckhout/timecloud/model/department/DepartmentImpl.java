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
 *******************************************************/

package com.pietervaneeckhout.timecloud.model.department;

import com.pietervaneeckhout.timecloud.model.Department;
import java.util.Objects;

/**
 *
 * @author Pieter Van Eeckhout
 */
public class DepartmentImpl implements Department {
    
    private int departmentCode;
    private String departmentName;

    public DepartmentImpl() {
    }
        
    DepartmentImpl(int departmentCode, String departmentName) {
       this.departmentCode = departmentCode;
       this.departmentName = departmentName;
    }

    @Override
    public int getDepartmentCode() {
        return departmentCode;
    }

    @Override
    public void setDepartmentCode(int departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.departmentCode;
        hash = 59 * hash + Objects.hashCode(this.departmentName);
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
        final DepartmentImpl other = (DepartmentImpl) obj;
        if (this.departmentCode != other.departmentCode) {
            return false;
        }
        return true;
    }
}
