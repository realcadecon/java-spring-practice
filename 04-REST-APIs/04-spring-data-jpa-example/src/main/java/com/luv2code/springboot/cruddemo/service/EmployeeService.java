package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findEmployeeByID(int id);

    Employee saveEmployee(Employee employee);

    void deleteEmployeeByID(int id);

}
