package com.luv2code.springboot.thymeleaddemo.controller;

import com.luv2code.springboot.thymeleaddemo.entity.Employee;
import com.luv2code.springboot.thymeleaddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "employees/employee-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/employees/employee-save-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForAdd(@RequestParam("employeeId") int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "/employees/employee-update-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);

        //redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String saveEmployee(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);

        //redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

}
