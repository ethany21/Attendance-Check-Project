package com.github.project.attendacecheck.bootstrap;

import com.github.project.attendacecheck.model.*;
import com.github.project.attendacecheck.model.Class;
import com.github.project.attendacecheck.service.AttendanceService;
import com.github.project.attendacecheck.service.ClassService;
import com.github.project.attendacecheck.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private final StudentService studentService;
    private final ClassService classService;
    private final AttendanceService attendanceService;

    @Autowired
    public DataLoader(StudentService studentService, ClassService classService, AttendanceService attendanceService) {
        this.studentService = studentService;
        this.classService = classService;
        this.attendanceService = attendanceService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        dataLoad();
    }

    public void dataLoad(){
        Class aClass = new Class();
        aClass.setDate(LocalDate.of(2019, 9, 1));
        aClass.setTopic("Engineering");

        classService.save(aClass);
        logger.info("saving a Class");

        Student student = new Student();
        student.setEmail("imwoodam@hanmail.net");
        student.setName("woodam chung");
        student.setMajor("Psychology");
        student.setGender(Gender.MALE);
        student.setBirthDate(LocalDate.of(1995, 1, 12));

        studentService.save(student);
        logger.info("saving a Student");


        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setCheck(AttendanceCheck.LATE);
        attendance.setaClass(aClass);

        attendanceService.save(attendance);
        logger.info("saving an Attendance");

        Class aClass2 = new Class();
        aClass2.setDate(LocalDate.of(2019, 9, 16));
        aClass2.setTopic("Data Cleansing");

        classService.save(aClass2);
        logger.info("saving a Class 2");

        Attendance attendance2 = new Attendance();
        attendance2.setStudent(student);
        attendance2.setCheck(AttendanceCheck.ATTEND);
        attendance2.setaClass(aClass2);

        attendanceService.save(attendance2);
        logger.info("saving an Attendance 2");

    }
}
