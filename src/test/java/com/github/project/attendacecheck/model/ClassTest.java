package com.github.project.attendacecheck.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ClassTest {

    @Autowired
    Class aClass;

    Attendance attendance;

    @BeforeEach
    void setUp() {
        aClass = new Class();
        attendance  = new Attendance();
    }

    @Test
    void attend() {

        aClass.setId(1l);
        aClass.setDate(new Date());
        aClass.setTopic("Engineering");
        aClass.attend(attendance);
        assertNotNull(attendance.getAClass());
        assertEquals(1l, attendance.getAClass().getId());
    }
}