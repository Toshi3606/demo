package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api")
    public String index() {
        return "Spring Boot Running";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
}

