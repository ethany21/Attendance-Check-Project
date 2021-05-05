package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.bootstrap.DataLoader;
import com.github.project.attendancecheck.model.Attendance;
import com.github.project.attendancecheck.model.AttendanceWrapper;
import com.github.project.attendancecheck.model.Gender;
import com.github.project.attendancecheck.model.Student;
import com.github.project.attendancecheck.repository.ClassRepository;
import com.github.project.attendancecheck.repository.StudentRepository;
import com.github.project.attendancecheck.service.interfaces.AddPaymentService;
import com.github.project.attendancecheck.service.interfaces.AttendanceService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class AddPaymentServiceImplTest {

    private static Logger logger = LoggerFactory.getLogger(AddPaymentServiceImplTest.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private ClassRepository classRepository;

    private AddPaymentServiceImpl mock = mock(AddPaymentServiceImpl.class);

    @Test
    public void addPaymentTest(){
        Student student = studentRepository.findByUsername("imwoodam");
        assertEquals(Gender.MALE, student.getGender());
        assertEquals("woodam chung", student.getName());
    }

    @Test
    public void createAttendancesTest(){

        List<Attendance> attendances = attendanceService.createAttendances(new AttendanceWrapper()).getAttendances();

        assertEquals(studentRepository.findAll().size(), attendances.size());

        logger.info("Size of attendances is " + attendances.size());

    }


}