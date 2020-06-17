package net.employee.employeeform.controllers;


import com.netflix.discovery.converters.Auto;
import net.employee.employeeform.Services.DepartamentService;
import net.employee.employeeform.Services.EmployeeService;
import net.employee.employeeform.entities.Departament;
import net.employee.employeeform.entities.Employee;
import net.employee.employeeform.repositories.DepartamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @DeleteMapping("/Employee/Delete/{employeeId}")

    public String deleteEmployee(@PathVariable int employeeId){

        Employee employee = employeeService.getById(employeeId);

        employeeService.DeleteEmployeeById(employeeId);


        return "Deleted User "+employee.getFirstName();

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
