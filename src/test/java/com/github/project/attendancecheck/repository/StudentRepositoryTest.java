package com.github.project.attendancecheck.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void saveAll() {
    }

    @Test
    void findByUsername() {
    }

    @Test
    void setStudent() {
    }

    @Test
    void findByIdTest(){
        System.out.println(studentRepository.findById(3l));
    }
}