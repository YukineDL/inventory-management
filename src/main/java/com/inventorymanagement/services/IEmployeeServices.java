package com.inventorymanagement.services;

import com.inventorymanagement.dto.EmployeeUpdateDTO;
import com.inventorymanagement.entity.Employee;

import java.util.List;

public interface IEmployeeServices {
    List<Employee> getAll(String authHeader);
    Employee getFullInformation(String authHeader);
    Employee findByCode(String authHeader, String code);
    void updateByCode(String authHeader, String employeeCode, EmployeeUpdateDTO employeeUpdateDTO);
    void lockAccount(String authHeader, String employeeCode);
    void unlockAccount(String authHeader, String employeeCode);
}
