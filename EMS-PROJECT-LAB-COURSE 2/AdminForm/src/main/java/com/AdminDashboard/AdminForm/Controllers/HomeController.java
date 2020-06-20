package com.AdminDashboard.AdminForm.Controllers;


import com.AdminDashboard.AdminForm.models.Departament;
import com.AdminDashboard.AdminForm.models.Employee;
import com.AdminDashboard.AdminForm.models.Position;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import static org.springframework.http.MediaType.*;

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


    @GetMapping("/Main-Menu")
    private String getMenu(){
        return "basic_elements";
    }

    @GetMapping("/Review-Leaves")
    private String getReviews(){
        return "Review_Leaves";
    }


    @GetMapping("/Add-Holiday-Category")
    private String getAddHoliday(){
        return "Add-Holiday";
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


        ResponseEntity <List<Position>> getpositions= restTemplate.exchange("http://localhost:8081/Position/GetAll",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Position>>() {
                });


        Employee temp = getEmployee.getBody();

        model.addAttribute("Employee",temp);
        model.addAttribute("Departament",temp2);
        model.addAttribute("Position",getpositions.getBody());


        return "employee-edit";
    }


    @PutMapping(value = "/Employee/Update/{employeeId}")

    public String employeeEditMethod(@ModelAttribute("Employee")@RequestBody Employee newEmployee, @PathVariable int employeeId){



        ResponseEntity<String> editEmp = restTemplate.exchange("http://localhost:8081/Employee/Update/" + employeeId,
                HttpMethod.PUT,
                new HttpEntity<>(newEmployee),
                new ParameterizedTypeReference<String>() {
                }
        );


        return "redirect:/Admin-Dashboard/Employees";

    }

    @GetMapping("/Employee/Add")
    public String getEmp(Model model){

        Employee temp = new Employee();


        ResponseEntity <List<Position>> getpositions= restTemplate.exchange("http://localhost:8081/Position/GetAll",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Position>>() {
                });


        List<Position> getallPos = getpositions.getBody();


        model.addAttribute("Employee",temp);
        model.addAttribute("Departament",temp2);
        model.addAttribute("Position",getallPos);


        return "employee-add";


    }

    @PostMapping(value = "/Employee/Add")

    public String addemployee(@ModelAttribute("Employee")@RequestBody Employee employee){


        ResponseEntity<String> addemp = restTemplate.exchange("http://localhost:8081/Employee/Add",
                HttpMethod.POST,
                new HttpEntity<>(employee),
                new ParameterizedTypeReference<String>() {
                });


        return "redirect:/Admin-Dashboard/Employees";

    }

















}
