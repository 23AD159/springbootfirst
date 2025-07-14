package com.example.springbootstudent.controllers;

import com.example.springbootstudent.models.Student;
import com.example.springbootstudent.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServices studServices;

    @GetMapping//("/")
    public List<Student> studentList() {
        return studServices.getMethod();
    }

    @GetMapping("/{id}")
        public Student getStudentById(@PathVariable int id){
            return studServices.getStudentById(id);

        }

    @PostMapping//("/")
    public String postMethod(@RequestBody Student newStudent){
        return studServices.postMethod(newStudent);
    }
    @PutMapping("/{id}")
    public String putMethod(@PathVariable int id, @RequestBody Student updatedStudent){
        return studServices.putMethod(id,  updatedStudent);
    }

    @DeleteMapping("/{id}")
    public String deleteMethod(@PathVariable int id){
        return studServices.deleteMethod(id);
    }
}