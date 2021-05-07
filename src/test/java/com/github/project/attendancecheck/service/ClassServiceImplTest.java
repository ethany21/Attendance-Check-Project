package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.repository.ClassRepository;
import com.github.project.attendancecheck.service.interfaces.ClassService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class ClassServiceImplTest {

    @Autowired
    ClassRepository classRepository;

    @Autowired
    ClassService classService;

    @Test
    void findAll() {

        assertEquals(classService.findAll().size(), 4);

    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByTopic() {
    }

    @Test
    void findByDate() {
    }
}