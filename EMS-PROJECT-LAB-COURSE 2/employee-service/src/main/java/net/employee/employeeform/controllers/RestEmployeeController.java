package net.employee.employeeform.controllers;


import net.employee.employeeform.Services.EmployeeService;
import net.employee.employeeform.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestEmployeeController {




    @Autowired
    private EmployeeService employeeService;


//    This is for later use, to make Restful API Calls to this method
    @GetMapping("/Employee/Getall")
    public List<Employee> getTotalEmp(){

        return employeeService.getall();

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
