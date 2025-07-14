package com.example.new_project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_details")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    private String email;
    private String password;
    private String gender;

    @Column(name="date_of_birth")
    private Date dateOfBirth;
    private String role;
}

