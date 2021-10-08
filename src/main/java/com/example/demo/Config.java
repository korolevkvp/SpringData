package com.example.demo;

import com.example.demo.service.StudentService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Config {
    private final StudentService service;

    public Config(StudentService dataBaseService) {
        service = dataBaseService;
    }

    @PostConstruct
    public void init() {
        System.out.println("Hello");
        service.init();
    }
}
