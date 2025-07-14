package com.example.springintern.controllers;

import com.example.springintern.models.Employee;
import com.example.springintern.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;

    @GetMapping//("/")
    public List<Employee> hello(){
        return hws.getMethod();
    }

    @GetMapping("/{empId}")
    public Employee getMethodById(@PathVariable int empId){
        return hws.getEmployeeById(empId);
    }

    @PostMapping//("/")
    public String postMethod(@RequestBody Employee newEmployee){
        return hws.postMethod(newEmployee);
    }

    @PutMapping("/{empId}")
    public String putMethod(@PathVariable int empId, @RequestBody Employee updatedEmp){
        return hws.putMethod(empId,  updatedEmp);
    }

    @DeleteMapping("/{empId}")
    public String deleteMethod(@PathVariable int empId){
        return hws.deleteMethod(empId);
    }
}