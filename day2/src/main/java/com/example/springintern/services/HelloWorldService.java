package com.example.springintern.services;

import com.example.springintern.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List <Employee> emp = new ArrayList<>(
            Arrays.asList(new Employee(1,"Arjun","Prasath","Arjun@gmail.com","1234","Trainer"),
                    new Employee(2,"Ed","Sheeran","shreen@gmail.com","5678","Singer")
            )
    );
    public List<Employee> getMethod(){
        return emp;
    }
    public String postMethod(Employee newEmployee){
        emp.add(newEmployee);
        return "Employee added successfully!";
    }
    public String putMethod(int id, Employee updateemp){
        for(int i=0;i<emp.size();i++){
            if(emp.get(i).getEmpId()==id){
                emp.set(i,updateemp);
                return "Employee with id "+id+" updated Successfully!";
            }
        }
        return "Employee with id "+id+ " not found!";
    }
    public String deleteMethod(int id){
        for(int i=0;i<emp.size();i++) {
            if (emp.get(i).getEmpId() == id) {
                emp.remove(i);
                return "Employee with id " + id + " deleted successfully!";
            }
        }
        return "Employee with id "+id+" not found!";
    }
}
