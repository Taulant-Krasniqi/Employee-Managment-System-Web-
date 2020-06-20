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

        Employee temp2 = temp.get();
        return temp2;
    }

    public void DeleteEmployeeById(int id){
        employeeRepo.deleteById(id);
    }

    public void SaveEmployee(Employee employee){
        employeeRepo.saveAndFlush(employee);
    }

    public void addEmp(Employee employee){
        employeeRepo.save(employee);
    }

    public Employee getByEmail(String email){
        return employeeRepo.findByEmail(email);
    }
}
