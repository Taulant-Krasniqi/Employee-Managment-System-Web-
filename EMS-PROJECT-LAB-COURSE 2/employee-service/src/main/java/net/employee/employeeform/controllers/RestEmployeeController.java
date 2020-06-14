package net.employee.employeeform.controllers;


import net.employee.employeeform.Services.EmployeeService;
import net.employee.employeeform.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestEmployeeController {


    @Autowired
    private EmployeeService employeeService;


//    This is for later use, to make Restful API Calls to this method
    @RequestMapping("/Employee/Getall")
    public List<Employee> getTotalEmp(){

        return employeeService.getall();

    }
}
