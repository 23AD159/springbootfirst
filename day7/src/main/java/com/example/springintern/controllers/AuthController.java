//package com.example.springintern.controllers;
//
//import com.example.springintern.models.RegisterDetails;
//import com.example.springintern.models.UserDetailsDto;
//import com.example.springintern.repository.RegisterDetailsRepository;
//import com.example.springintern.services.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    AuthService authService;
//    /*
//    @Autowired
//    private RegisterDetailsRepository registerDetailsRepository;
//
//
//     */
//    @PostMapping("/register")
//    public String addNewUser(@RequestBody UserDetailsDto register){
//        return  authService.addNewEmployee(register);
//    }
//    @GetMapping("/")
//    public List<RegisterDetails> getAllUsers() {
//        return authService.getAllEmployees();
//    }
//
//    @PostMapping("/login")
//    public String Login(@RequestBody RegisterDetails login){
//        return authService.authenticate(login);
//    }
//
//        /*
//        RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
//        if(user!=null){
//            if(user.getPassword().equals(login.getPassword())){
//                return "Login successful";
//            }
//        }
//        return "Login not successful";
//         */
//
//    }
package com.example.springintern.controllers;

import com.example.springintern.models.RegisterDetails;
import com.example.springintern.models.UserDetailsDto;
import com.example.springintern.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserDetailsDto register) {
        return authService.addNewEmployee(register);
    }

    @GetMapping("/")
    public List<RegisterDetails> getAllUsers() {
        return authService.getAllEmployees();
    }

    @PostMapping("/login")
    public String Login(@RequestBody RegisterDetails login) {
        return authService.authenticate(login);
    }

}

