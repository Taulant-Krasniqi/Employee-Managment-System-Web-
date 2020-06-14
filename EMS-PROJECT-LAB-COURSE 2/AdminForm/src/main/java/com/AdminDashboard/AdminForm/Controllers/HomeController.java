package com.AdminDashboard.AdminForm.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


        return "basic-table";
    }

    @GetMapping("/Main-Menu")
    private String getMenu(){
        return "basic_elements";
    }

}
