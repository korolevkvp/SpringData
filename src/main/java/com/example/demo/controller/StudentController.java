package com.example.demo.controller;

import com.example.demo.entities.Student;
import com.example.demo.log.LogExecutionTime;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService studentService) {
        service = studentService;
    }

    @GetMapping
    @LogExecutionTime
    public Iterable<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("{id}")
    public Optional<Student> getStudent(@PathVariable String id) {
        return service.getStudent(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping
    public void add(@RequestBody Student student) {
        service.add(student);
    }

    @GetMapping("name/{firstName}")
    public String findByFirstName(@PathVariable String firstName) {
        return service.findByFirstName(firstName).toString();
    }
}
