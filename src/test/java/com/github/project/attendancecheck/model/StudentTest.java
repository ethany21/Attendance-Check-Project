package com.github.project.attendancecheck.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student1;
    Class aClass2;

    @BeforeEach
    void setUp() {

        student1 = new Student();
        aClass2 = new Class();
    }

    @Test
    void attendCheck() {

        student1.setGender(Gender.MALE);
        student1.setMajor("Ghrapics");
        student1.setEmail("jojoldu@gmail.com");
        student1.setName("jojoldu");
        student1.setBirthDate(LocalDate.of(1986, 3, 2));
//        student1.attendCheck(AttendanceCheck.ATTEND, aClass2);

        assertEquals(1, student1.getAttendances().size());
        assertTrue(student1.getAttendances().get(0) instanceof Attendance);
    }
}