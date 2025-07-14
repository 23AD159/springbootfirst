package com.example.springbootstudent.controllers;

import com.example.springbootstudent.models.Student;
import com.example.springbootstudent.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServices studServices;

    @GetMapping("/student")
    public List<Student> studentList() {
        return studServices.getMethod();
    }

    @GetMapping("/student/{id}")
        public Student getStudentById(@PathVariable int id){
            return studServices.getStudentById(id);

        }
    @GetMapping("/student/{name}")
    public List<Student> getStudentByName(@PathVariable String name){
        return studServices.getStudentByName(name);
    }

    @PostMapping("/")
    public String postMethod(@RequestBody Student student){
        return studServices.addStudent(student);
    }

    @PutMapping("/{id}")
    public String putMethod(@RequestBody Student student){
        return studServices.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public String deleteMethod(@PathVariable int id){
        return studServices.deleteStudent(id);
    }
    @DeleteMapping("/")
    public String deleteAllMethod(){
        return studServices.deleteAllStudents();
    }
}