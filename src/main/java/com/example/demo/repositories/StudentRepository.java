package com.example.demo.repositories;

import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableJpaRepositories
public interface StudentRepository extends CrudRepository<Student, Integer> {
    Optional<Student> findByFirstName(String firstName);
}
