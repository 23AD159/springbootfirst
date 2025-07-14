package com.example.springbootstudent.services;

import com.example.springbootstudent.models.Student;
import com.example.springbootstudent.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentServices {

//    List<Student> students = new ArrayList<>(
//            Arrays.asList(
//                    new Student(1, "Arun", "CCE", 8, "Gen AI"),
//                    new Student(2, "Yamuna", "AI-DS", 9, "Full Stack")
//            )
//    );

    @Autowired
    private StudentRepo studRepo;

    public List<Student> getMethod() {
        return studRepo.findAll();
    }

    public Student getStudentById(int id) {
        return studRepo.findById(id).orElse(new Student());
    }
    public List<Student> getStudentByName(String name) {
        return studRepo.findByName(name);
    }
    public String addStudent(Student stud) {
        studRepo.save(stud);
        return "Student added successfully";
    }
    public String updateStudent(Student stud){
        studRepo.save(stud);
        return "Student updated successfully";
    }
    public String deleteStudent(int id) {
        studRepo.deleteById(id);
        return "Student deleted successfully";
    }
    public String deleteAllStudents(){
        studRepo.deleteAll();
        return "All Employees Deleted Successfully";
    }
}

