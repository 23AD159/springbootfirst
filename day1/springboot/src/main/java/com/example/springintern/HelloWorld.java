package com.example.springintern;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloWorld {

    public String hello(){
        System.out.println("Hello World");
        return "Hello folks, welcome to Spring rollercoaster";
    }
}
