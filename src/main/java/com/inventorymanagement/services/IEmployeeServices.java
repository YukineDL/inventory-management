package com.inventorymanagement.services;

import com.inventorymanagement.entity.Employee;

import java.util.List;

public interface IEmployeeServices {
    List<Employee> getAll(String authHeader);
    Employee getFullInformation(String authHeader);
}
