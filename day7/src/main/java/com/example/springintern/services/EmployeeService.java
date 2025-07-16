package com.example.springintern.services;

import com.example.springintern.models.RegisterDetails;
import com.example.springintern.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    RegisterDetailsRepository registerDetailsRepository;
    
    public List<RegisterDetails> getMethod() {
        return registerDetailsRepository.findAll();
        
    }

    public RegisterDetails getEmployeeById(int empId) {
        return registerDetailsRepository.findById(empId).orElse(new RegisterDetails());
    }

//    public List<RegisterDetails> getEmployeeByJob(String job) {
//        return registerDetailsRepository.findAll();
//
//    }

    public String addEmployee(RegisterDetails emp) {
        registerDetailsRepository.save(emp);
        return "Employee added successfully";
    }

    public String updateEmployee(int empId) {
        RegisterDetails user = registerDetailsRepository.findById(empId)
                .orElseThrow(()->new RuntimeException("Employee not found"));

        registerDetailsRepository.save(user);
        return "Employee updated successfully";
    }

    public String deleteEmployeeById(int empId) {
        registerDetailsRepository.deleteById(empId);
        return "Employee deleted successfully";
    }
}
