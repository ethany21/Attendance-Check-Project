package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.model.Attendance;
import com.github.project.attendancecheck.model.AttendanceWrapper;
import com.github.project.attendancecheck.model.PaidFee;
import com.github.project.attendancecheck.repository.AttendanceRepository;
import com.github.project.attendancecheck.repository.ClassRepository;
import com.github.project.attendancecheck.repository.PaidFeeRepository;
import com.github.project.attendancecheck.repository.StudentRepository;
import com.github.project.attendancecheck.service.interfaces.AttendanceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AttendanceServiceImplTest {

    @Autowired
    private StudentRepository students;

    @Mock
    private AttendanceRepository attendanceRepository;

    @Mock
    private PaidFeeRepository paidFeeRepository;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private ClassRepository classRepository;

    @Autowired
    private AttendanceService attendanceService;

    @BeforeEach
    public void setUp(){

        attendanceService = new AttendanceServiceImpl(attendanceRepository, paidFeeRepository, studentRepository, classRepository);

    }

    @AfterEach
    public void cleanUp(){

    }

    @Test
    void createAttendancesTest() {

        attendanceService.createAttendances(new AttendanceWrapper(), 3l);
        verify(studentRepository).findAll();

    }

    @Test
    void setAttendancesDateTest() {
    }

    @Test
    void restPaymentTest() {

        Long id = 0l;
        attendanceService.restPayment(id);

        verify(attendanceRepository).sumPenaltyFee(id);
        verify(paidFeeRepository).sumPaidFeeByStudent(id);


    }

    @Test
    void saveAllTest() {
    }

    @Test
    void sumPenaltyFeeTest() {
    }

    @Test
    void findAllByStudent_IdTest() {
    }

    @Test
    void findAllByAClass_IdTest() {
    }

    @Test
    void findAll() {
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
}