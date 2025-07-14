package com.example.springintern.controllers;

import com.example.springintern.models.Employee;
import com.example.springintern.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("employee")
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;

    @GetMapping("/")
    public String router(){
        return "Welcome to Spring Boot security!";
    }

    @GetMapping("/employee")
    public List<Employee> hello(){
        return hws.getMethod();
    }

    @GetMapping("/employee/{empId}")
    public Employee getMethodById(@PathVariable int empId){
        return hws.getEmployeeById(empId);
    }
    @GetMapping("/job/{job}")
    public List<Employee> getEmployeeByJob(@PathVariable String job){
        return hws.getEmployeeByJob(job);
    }

//    @GetMapping("/firstName/{firstName}")
//    public List<Employee> getEmployeeByFirstName(@PathVariable String firstName){
//        return hws.getEmployeeByFirstName(firstName);
//    }

    @PostMapping("/")
    public String postMethod(@RequestBody Employee emp){
        return hws.addEmployee(emp);
    }

    @PutMapping("/{empId}")
    public String putMethod(@RequestBody Employee emp){
        return hws.updateEmployee(emp);
    }

    @DeleteMapping("/{empId}")
    public String deleteMethod(@PathVariable int empId){
        return hws.deleteEmployee(empId);
    }
    @DeleteMapping("/")
    public String deleteAllMethod(){
        return hws.deleteAllEmployees();
    }

}