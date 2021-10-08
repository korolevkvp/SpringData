package com.example.demo.service;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
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

    public void init() {
        Student a = Student.builder()
                .age(21)
                .firstName("Vadim")
                .secondName("Korolev")
                .build();
        Student b = Student.builder()
                .age(22)
                .firstName("Violetta")
                .secondName("Zozulya")
                .build();
        Student c = Student.builder()
                .age(20)
                .firstName("Artyom")
                .secondName("Balakin")
                .build();
        List<Student> list = Arrays.asList(a, b, c);
        studentRepository.saveAll(list);
    }
}
