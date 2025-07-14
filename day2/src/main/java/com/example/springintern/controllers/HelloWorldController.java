package com.example.springintern.controllers;

import com.example.springintern.models.Employee;
import com.example.springintern.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;

    @GetMapping("/")
    public List<Employee> hello(){
        return hws.getMethod();
    }

    @PostMapping("/")
    public String postMethod(@RequestBody Employee newEmployee){
        return hws.postMethod(newEmployee);
    }

    @PutMapping("/{id}")
    public String putMethod(@PathVariable int id, @RequestBody Employee updatedEmp){
        return hws.putMethod(id,  updatedEmp);
    }

    @DeleteMapping("/{id}")
    public String deleteMethod(@PathVariable int id){
        return hws.deleteMethod(id);
    }
}
