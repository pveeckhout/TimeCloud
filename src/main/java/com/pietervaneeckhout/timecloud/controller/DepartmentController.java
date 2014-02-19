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

package com.pietervaneeckhout.timecloud.controller;

import com.pietervaneeckhout.timecloud.model.Department;
import java.util.List;

/**
 *
 * @author Pieter Van Eeckhout
 */
public interface DepartmentController {
    
    List<Department> getAll();
    
    int getDepartmentCodeByName(String departmentName) throws IllegalArgumentException;
    
    String getDepartmentNameByCode(int departmentCode) throws IllegalArgumentException;
    
    Department add(Department department);
    
    Department update(Department department);
    
    void delete(Department department);
}
