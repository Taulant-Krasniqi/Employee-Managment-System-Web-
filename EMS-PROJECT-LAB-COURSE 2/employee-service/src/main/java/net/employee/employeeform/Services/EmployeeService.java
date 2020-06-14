package net.employee.employeeform.Services;

import net.employee.employeeform.entities.Employee;
import net.employee.employeeform.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    public List<Employee> getall(){
        return employeeRepo.findAll();
    }
}
