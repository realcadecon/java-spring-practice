package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeByID(@PathVariable int id) {

        Employee employee = employeeService.findEmployeeByID(id);

        if(employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return employee;
    }

    //post
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        //in case the user passes id inside JSON, set it to 0
        employee.setId(0);
        Employee newEmployee = employeeService.saveEmployee(employee);

        return newEmployee;
    }

    //put
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.saveEmployee(employee);
        return newEmployee;
    }

    //delete
    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeByID(@PathVariable int id) {
        Employee employee = employeeService.findEmployeeByID(id);
        // throw exception
        if(employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }
        employeeService.deleteEmployeeByID(id);

        return "Deleted employee with id - " + id;
    }

}
