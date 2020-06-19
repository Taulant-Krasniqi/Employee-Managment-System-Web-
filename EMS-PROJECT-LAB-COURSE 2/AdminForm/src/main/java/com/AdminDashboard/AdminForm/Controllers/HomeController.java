package com.AdminDashboard.AdminForm.Controllers;


import com.AdminDashboard.AdminForm.models.Departament;
import com.AdminDashboard.AdminForm.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/Admin-Dashboard")
public class HomeController {


    List<Departament> temp2 = null;




    @Autowired
    RestTemplate restTemplate;

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

        temp2 = responseEntity2.getBody();

        model.addAttribute("Employee",temp);

        model.addAttribute("Departament",temp2);



        return "basic-table";
    }


    @DeleteMapping("/Delete/{employeeId}")

    public String delEmp(@PathVariable int employeeId){


        ResponseEntity<String> DeleteEmp = restTemplate.exchange("http://localhost:8081/Employee/Delete/"+employeeId,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<String>(){});

        String test = DeleteEmp.getBody();


        return "redirect:/Admin-Dashboard/Employees";
    }

    @GetMapping("/Employee/Edit/{employeeId}")
    public String employeeEdit(Model model,@PathVariable int employeeId){


        ResponseEntity<Employee> getEmployee = restTemplate.exchange("http://localhost:8081/Getemployee/" + employeeId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Employee>() {
                });
        Employee temp = getEmployee.getBody();

        model.addAttribute("Employee",temp);
        model.addAttribute("Departament",temp2);


        return "employee-edit";
    }


    @PutMapping(value = "/Employee/Update/{employeeId}", consumes="application/json")

    public String employeeEditMethod(@RequestBody Employee newEmployee, @PathVariable int employeeId){



        ResponseEntity<String> editEmp = restTemplate.exchange("http://localhost:8081/Employee/Update/" + employeeId,
                HttpMethod.PUT,
                new HttpEntity<>(newEmployee),
                new ParameterizedTypeReference<String>() {
                }
        );

        return "redirect:/Admin-Dashboard/Employees";

    }












    @GetMapping("/Main-Menu")
    private String getMenu(){
        return "basic_elements";
    }





}
