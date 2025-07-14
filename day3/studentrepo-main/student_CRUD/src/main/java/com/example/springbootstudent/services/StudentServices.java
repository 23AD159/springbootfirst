package com.example.springbootstudent.services;

import com.example.springbootstudent.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentServices {
    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Arun", "CCE", 8, "Gen AI"),
                    new Student(2, "Yamuna", "AI-DS", 9, "Full Stack")
            )
    );

    public List<Student> getMethod() {
        return students;
    }

    public Student getStudentById(int id) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                System.out.println("Student id " + students.get(i).getId());
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            return students.get(ind);
        } else {
            return new Student();
        }
    }

    public String postMethod(Student newStudent) {
        students.add(newStudent);
        return "Student added Successfully!";
    }

    public String putMethod(int id, Student updatestudent) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            students.set(ind, updatestudent);
            return "Updated Successfully!";
        } else {
            return "No such student with id " + id;
        }
    }

    public String deleteMethod(int id) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            students.remove(ind);
            return "Student deleted Successfully!";
        } else {
            return "No such student with id " + id;
        }
    }
}