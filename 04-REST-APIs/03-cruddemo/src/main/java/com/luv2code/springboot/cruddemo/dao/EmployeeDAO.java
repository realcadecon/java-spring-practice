package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findEmployeeByID(int id);

    Employee saveEmployee(Employee employee);

    void deleteEmployeeByID(int id);

}
