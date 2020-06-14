package com.AdminDashboard.AdminForm.Controllers;


import com.AdminDashboard.AdminForm.models.Departament;
import com.AdminDashboard.AdminForm.models.Employee;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/Admin-Dashboard")
public class HomeController {





    @GetMapping("")
    private String getIndex(){
        return "index";
    }


    @GetMapping("/test1")
    private String getTest(){
        return "buttons";
    }

    @GetMapping("/test2")
    private String getTest2(){
        return "typography";
    }

    @GetMapping("/Employees")
    private String getList(Model model){


        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);



        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange("http://localhost:8081/Employee/Getall",

                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {
                });

        List<Employee> temp = responseEntity.getBody();




        ResponseEntity<List<Departament>> responseEntity2 = restTemplate.exchange("http://localhost:8081/Departament/Getall",

                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Departament>>() {
                });

        List<Departament> temp2 = responseEntity2.getBody();

        model.addAttribute("Employee",temp);

        model.addAttribute("Departament",temp2);



        return "basic-table";
    }

    @GetMapping("/Main-Menu")
    private String getMenu(){
        return "basic_elements";
    }





}
