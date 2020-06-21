package net.login.springbootsecurity.web;


import net.login.springbootsecurity.entities.User;
import net.login.springbootsecurity.repositories.PersistRepo;
import net.login.springbootsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;


@org.springframework.web.bind.annotation.RestController
public class RestController {


    @Autowired
    private PersistRepo persistRepo;

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/testouser")
    public String getUser(){
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
        } else {
             username = principal.toString();
        }

        return username;

    }
}
