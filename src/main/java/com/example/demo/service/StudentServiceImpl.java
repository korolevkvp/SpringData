package com.example.demo.service;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Optional<Student> getStudent(String id) {
        return studentRepository.findById(Integer.parseInt(id));
    }

    public void delete(String id) {
        studentRepository.deleteById(Integer.parseInt(id));
    }

    public void add(Student student) {
        studentRepository.save(student);
    }
}