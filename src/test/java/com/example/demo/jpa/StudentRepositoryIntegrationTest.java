package com.example.demo.jpa;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void whenFindByName_thenReturnStudent() {
        // given
        Student alex = Student.builder().firstName("Alex").secondName("second_name").age(20).build();
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Student found = studentRepository.findByFirstName(alex.getFirstName()).get();

        // then
        assertThat(found.getFirstName())
                .isEqualTo(alex.getFirstName());
    }


}
