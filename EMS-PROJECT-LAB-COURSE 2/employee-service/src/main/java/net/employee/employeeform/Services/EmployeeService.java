package net.employee.employeeform.Services;

import net.employee.employeeform.entities.Employee;
import net.employee.employeeform.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    public List<Employee> getall(){
        return employeeRepo.findAll();
    }


    public Employee getById(int i){
        Optional<Employee> temp = employeeRepo.findById(i);
        return temp.get();
    }

    public void DeleteEmployeeById(int id){
        employeeRepo.deleteById(id);
    }
}
