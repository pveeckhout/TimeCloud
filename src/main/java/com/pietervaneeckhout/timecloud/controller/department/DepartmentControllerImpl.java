/*******************************************************
 * Copyright (C) 2014 Pieter Van Eeckhout <vaneeckhout.pieter@gmail.com>
 * 
 * This file is part of TimeCloud.
 * 
 * TimeCloud can not be copied, edited and/or distributed without the express
 *  written permission of Pieter Van Eeckhout and Anne Charlotte Van de Velde
 *******************************************************/

package com.pietervaneeckhout.timecloud.controller.department;

import com.pietervaneeckhout.timecloud.controller.DepartmentController;
import com.pietervaneeckhout.timecloud.model.Department;
import java.util.List;

/**
 *
 * @author Pieter Van Eeckhout
 */
public class DepartmentControllerImpl implements DepartmentController {
    
    List<Department> departments;
    PersistenceController persistence;

    public DepartmentControllerImpl() {
    }

    DepartmentControllerImpl(List<Department> departments) {
        this();
        this.departments = departments;
    }
    
    @Override
    public List<Department> getAll() {
        return departments;
    }
    
    @Override
    public int getDepartmentCodeByName(String departmentName) throws IllegalArgumentException {
        for (Department department : departments) {
            if (department.getDepartmentName().equals(departmentName)) {
                return department.getDepartmentCode();
            }
        }
        
        throw new IllegalArgumentException("Department with name: " + departmentName + "not found");
    }

    @Override
    public String getDepartmentNameByCode(int departmentCode) {
        for (Department department : departments) {
            if (department.getDepartmentCode() == departmentCode) {
                return department.getDepartmentName();
            }
        }
        
        throw new IllegalArgumentException("Department with code: " + departmentCode + "not found");
    }

    @Override
    public Department add(Department department) {
        department = persistence.save(department);
        departments.add(department);
        return department;
    }

    @Override
    public Department update(Department department) {
        department = persistence.update(department);
        
        for (Department department1 : departments) {
            if (department1.getDepartmentCode()==department.getDepartmentCode()) {
                department1 = department;
                break;
            }
        }
        
        return department;
    }

    @Override
    public void delete(Department department) {
        persistence.remove(department);
        departments.remove(department);
    }
}
