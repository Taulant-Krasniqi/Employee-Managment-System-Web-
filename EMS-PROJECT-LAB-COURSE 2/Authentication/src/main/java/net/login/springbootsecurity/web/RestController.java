package net.login.springbootsecurity.web;


import net.login.springbootsecurity.repositories.PersistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/rest")
@org.springframework.web.bind.annotation.RestController
public class RestController {


    @Autowired
    private PersistRepo persistRepo;




//    @GetMapping("/name")
//
//    public String getUser(){
//
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            if (authentication instanceof AbstractAuthenticationToken) {
//                return authentication.getName();
//            }
//            else if (authentication instanceof UsernamePasswordAuthenticationToken) {
//                return authentication.getName();
//            }
//            else if (authentication instanceof RememberMeAuthenticationToken) {
//                return ((User) authentication.getPrincipal()).getEmail();
//            }
//        }
//        return null;
//
//
//
//
//
//
//
//    }
}
