package com.example.demo.service;

import com.example.demo.entities.Student;

import java.util.Optional;

public interface StudentService {

    void init();

    Iterable<Student> getAllStudents();

    Optional<Student> getStudent(String id);

    void delete(String id);

    void add(Student student);
}
