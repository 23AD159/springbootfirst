package com.example.springintern.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int empId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String job;
}


