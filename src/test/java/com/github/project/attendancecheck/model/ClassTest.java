package com.github.project.attendancecheck.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

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
        aClass.setDate(LocalDate.of(2021, 2, 3));
        aClass.setTopic("Engineering");

//        attendance.setCheck(AttendanceCheck.LATE);

        attendance.setAClass(aClass);

        assertNotNull(aClass.getAttendances());
        assertEquals(1,aClass.getAttendances().size());
    }
}