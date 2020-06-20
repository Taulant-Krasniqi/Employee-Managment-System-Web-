package net.employee.employeeform.controllers;

import net.employee.employeeform.Services.EmployeeService;
import net.employee.employeeform.Services.PositionService;
import net.employee.employeeform.repositories.NotificationRepo;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/Dashboard")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private NotificationRepo notificationRepo;











    @GetMapping("")
    public String EmployeeDashboard(Model model){

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> getEmail = restTemplate.exchange("http://localhost:8080/rest/Employee/Verify",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                });



        model.addAttribute("Employee",employeeService.getByEmail(getEmail.getBody()));

//        model.addAttribute("Notification",notificationRepo.findAll());


        return "EmployeeLogin";
    }





    @RequestMapping("/request-leave")
    public String Requestleave(){
        return "requestleave";
    }



    @RequestMapping("/calendar")
    public String calendar(Model model){

//        model.addAttribute("Employee",employeeService.getall());
        return "CalendarHtml";
    }











}
