package com.example.demo.service;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = StudentServiceImplTest.StudentServiceImplTestContextConfiguration.class)
public class StudentServiceImplTest {

    @TestConfiguration
    static class StudentServiceImplTestContextConfiguration {

        @Bean
        public StudentService studentService(StudentRepository sR) {
            return new StudentServiceImpl(sR);
        }
    }
    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @Before
    public void setUp() {
        Student bob = Student.builder().firstName("bob").age(20).secondName("second_name").build();
        Mockito.when(studentRepository.findByFirstName(bob.getFirstName()))
                .thenReturn(java.util.Optional.of(bob));
        Mockito.when(studentRepository.findById(bob.getId()))
                .thenReturn(java.util.Optional.of(bob));
    }

    @Test
    public void whenValidName_thenStudentShouldBeFound() {
        studentService.add(Student.builder().firstName("bob").age(20).secondName("second_name").build());
        Student found = studentService.findByFirstName("bob").get();
        assert found != null;
        assertThat(found.getFirstName())
                .isEqualTo("bob");
    }

    @Test
    public void whenValidId_thenStudentShouldBeFound() {
        studentService.add(Student.builder().firstName("bob").age(20).secondName("second_name").build());
        Student found = studentService.getStudent("0").get();
        assert found != null;
        assertThat(found.getFirstName())
                .isEqualTo("bob");
    }
}