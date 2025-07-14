package com.example.springbootstudent.repository;

import com.example.springbootstudent.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    //List<Student> findById(int id);
    List<Student> findByName(String name);

}
