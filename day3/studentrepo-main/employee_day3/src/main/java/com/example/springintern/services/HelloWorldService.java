package com.example.springintern.services;

import com.example.springintern.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List<Employee> emp = new ArrayList<>(
            Arrays.asList(new Employee(1, "Arjun", "Prasath", "Arjun@gmail.com", "1234", "Trainer"),
                    new Employee(2, "Ed", "Sheeran", "shreen@gmail.com", "5678", "Singer")
            )
    );

    public List<Employee> getMethod() {
        return emp;
    }

    public Employee getEmployeeById(int empId) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i).getEmpId() == empId) {
                System.out.println("Emp ID: " + emp.get(i).getEmpId() + emp.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            return emp.get(ind);
        } else {
            return new Employee();
        }
    }

    public String postMethod(Employee newEmployee) {
        emp.add(newEmployee);
        return "Employee added successfully!";
    }

    public String putMethod(int empId, Employee updateemp) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < emp.size(); i++) {
            //if(emp.getEmpId()==employees.get(i).getEmpID())
            if (emp.get(i).getEmpId() == empId) {
                System.out.println("Emp ID: " + emp.get(i).getEmpId() + emp.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            emp.set(ind,emp.get(ind));
            return "Updated Successfully!";
        } else {
            return "No such employee with id " + empId;
        }
    }

    public String deleteMethod(int empId) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i).getEmpId() == empId) {
                System.out.println("Emp ID: " + emp.get(i).getEmpId() + emp.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            emp.remove(ind);
            return "Deleted Successfully!";
        } else {
            return "No such employee with id " + empId;
        }
}
}
