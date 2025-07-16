//package com.example.springintern.services;
//
//import com.example.springintern.models.RegisterDetails;
//import com.example.springintern.models.Roles;
//import com.example.springintern.models.UserDetailsDto;
//import com.example.springintern.repository.RegisterDetailsRepository;
//import com.example.springintern.repository.RolesRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Service
//public class AuthService {
//
//    @Autowired
//    RegisterDetailsRepository registerDetailsRepository;
//
//    @Autowired
//    private RolesRepository rolesRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//
//    public String addNewEmployee(UserDetailsDto register){
//        RegisterDetails registerDetails = new RegisterDetails();
//        registerDetails.setEmpId(register.getEmpId());
//        registerDetails.setName(register.getName());
//        registerDetails.setEmail(register.getEmail());
//        //System.out.println("Password is"+register.getPassword()+"\nEncrypted Password is"+register.getPassword());
//        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
//        registerDetails.setUserName(register.getUserName());
//        Set<Roles> roles= new HashSet<>();
//        for(String roleName:register.getRoleNames()){
//            Roles role = rolesRepository.findByRoleName(roleName)
//                            .orElseThrow(()->new RuntimeException("User not found" + roleName));
//            roles.add(role);
//        }
//        registerDetails.setRoles(roles);
//        System.out.println("Registration" + registerDetails);
//        registerDetailsRepository.save(registerDetails);
//
//        return "Employee added Successfully";
//    }
//
//    public String authenticate(RegisterDetails login) {
//        RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
//        if(user != null){
//            if (passwordEncoder.matches(login.getPassword(),user.getPassword())){
//                return "Login Successful";
//            }
//        }
//        return "Login Not Successful";
//    }
//
//
//    public List<RegisterDetails> getAllEmployees() {
//        return registerDetailsRepository.findAll();
//
//
//    }
//}
package com.example.springintern.services;

import com.example.springintern.models.RegisterDetails;
import com.example.springintern.models.Roles;
import com.example.springintern.models.UserDetailsDto;
import com.example.springintern.repository.RegisterDetailsRepository;
import com.example.springintern.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String addNewEmployee(UserDetailsDto register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setName(register.getName());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setUserName(register.getUserName());
        Set<Roles> roles = new HashSet<>();
        for (String roleName : register.getRoleNames()) {
            Roles role = rolesRepository.findByRoleName(roleName)
                    .orElseThrow(() -> new RuntimeException("User not found " + roleName));
            roles.add(role);
        }
        registerDetails.setRoles(roles);
        System.out.println("Registration" + registerDetails);
        registerDetailsRepository.save(registerDetails);

        return "Employee added Successfully";
    }


    public String authenticate(RegisterDetails login) {
        RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
        if (user != null) {
            if (passwordEncoder.matches(login.getPassword(), user.getPassword())) {
                return "Login Successful";
            }
        }
        return "Login Not Successful";
    }

    public List<RegisterDetails> getAllEmployees() {
        return registerDetailsRepository.findAll();
    }
}
