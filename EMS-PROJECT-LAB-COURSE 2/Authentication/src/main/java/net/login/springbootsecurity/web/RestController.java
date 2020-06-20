package net.login.springbootsecurity.web;


import net.login.springbootsecurity.entities.User;
import net.login.springbootsecurity.repositories.PersistRepo;
import net.login.springbootsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;


@RequestMapping("/rest")
@org.springframework.web.bind.annotation.RestController
public class RestController {


    @Autowired
    private PersistRepo persistRepo;

    @Autowired
    private UserRepository userRepository;




//    @GetMapping("/Employee/Verify")
//    public String verifyEmp(Principal principal){
//
//
//        Optional<User> temp = userRepository.findByEmail(principal.getName());
//
//
//        return temp.get().getEmail();
//
//
//    }
}
