package net.employee.employeeform.controllers;


import net.employee.employeeform.Services.DepartamentService;
import net.employee.employeeform.Services.EmployeeService;
import net.employee.employeeform.entities.Departament;
import net.employee.employeeform.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RestEmployeeController {




    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartamentService departamentService;




//    This is for later use, to make Restful API Calls to this method
    @GetMapping("/Employee/Getall")
    public List<Employee> getTotalEmp(){

        return employeeService.getall();

    }

    @GetMapping("/Departament/Getall")

    public List<Departament> getTotalDep(){

        return departamentService.getAll();


    }

    @GetMapping("/Getemployee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        return employeeService.getById(employeeId);

    }


    @DeleteMapping("/Employee/Delete/{employeeId}")

    public String deleteEmployee(@PathVariable int employeeId){

        Employee employee = employeeService.getById(employeeId);

        employeeService.DeleteEmployeeById(employeeId);


        return "Deleted User "+employee.getFirstName();

    }


    @PutMapping("/Employee/Update/{employeeId}")
    public String editEmployee(@RequestBody Employee newEmployee, @PathVariable int employeeId){

        Employee temp = employeeService.getById(employeeId);


        temp.setFirstName(newEmployee.getFirstName());
        temp.setLastName(newEmployee.getLastName());
        temp.setEmail(newEmployee.getEmail());
        temp.setBirthday(newEmployee.getBirthday());
        temp.setStreetName(newEmployee.getStreetName());
        temp.setTown(newEmployee.getTown());
        temp.setZipCode(newEmployee.getZipCode());
        temp.setBankName(newEmployee.getBankName());
        temp.setBankDetails(newEmployee.getBankDetails());
        temp.setGender(newEmployee.getGender());
        temp.setPhone(newEmployee.getPhone());
        temp.setPositionByPositionId(newEmployee.getPositionByPositionId());
        temp.setDepartamentByDepartamentId(newEmployee.getDepartamentByDepartamentId());

        employeeService.SaveEmployee(temp);

        return "Employee Updated";
    }






//    @GetMapping("/test/lanti")
//    public String getPrincipal(){
//
//        RestTemplate restTemplate = new RestTemplate();
//
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
//
//
//
//        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/rest/name",
//
//                HttpMethod.GET,
//                requestEntity,
//                String.class);
//
//
//
////        ResponseEntity<User> cost = restTemplate.getForEntity("http://localhost:8080/rest/name",User.class);
//
//
//
//
//
//        return responseEntity.getBody().toString();
//
//
//    }
}
