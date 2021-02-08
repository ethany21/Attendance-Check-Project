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
        aClass.setDescription("General Introduction of what is Software Engineering");
        aClass.setInstructor("Toby");

        classService.save(aClass);
        logger.info("saving a Class");

        Class aClass2 = new Class();
        aClass2.setDate(LocalDate.of(2019, 9, 8));
        aClass2.setTopic("Data Cleansing");
        aClass2.setDescription("Date Modification, Cleaning, and general Extraction");
        aClass2.setInstructor("Luka");

        classService.save(aClass2);
        logger.info("saving a Class 2");

        Student student1 = new Student();
        student1.setEmail("imwoodam@hanmail.net");
        student1.setName("woodam chung");
        student1.setMajor("Psychology");
        student1.setGender(Gender.MALE);
        student1.setBirthDate(LocalDate.of(1995, 3, 9));

        studentService.save(student1);
        logger.info("saving a Student 1");

        Student student2 = new Student();
        student2.setEmail("bloned@gmail.com");
        student2.setName("Frank Ocean");
        student2.setMajor("Sociology");
        student2.setGender(Gender.MALE);
        student2.setBirthDate(LocalDate.of(1986, 12, 7));

        studentService.save(student2);
        logger.info("saving a Student 2");


        Attendance attendance1 = new Attendance();
        attendance1.setStudent(student1);
        attendance1.setCheck(AttendanceCheck.ATTEND);
        attendance1.setaClass(aClass);

        attendanceService.save(attendance1);
        logger.info("saving an Attendance");

        Attendance attendance2 = new Attendance();
        attendance2.setStudent(student1);
        attendance2.setCheck(AttendanceCheck.LATE);
        attendance2.setaClass(aClass2);

        attendanceService.save(attendance2);
        logger.info("saving an Attendance 2");

        Attendance attendance3 = new Attendance();
        attendance3.setStudent(student2);
        attendance3.setCheck(AttendanceCheck.ATTEND);
        attendance3.setaClass(aClass);

        attendanceService.save(attendance3);
        logger.info("saving an Attendance 4");

        Attendance attendance4 = new Attendance();
        attendance4.setStudent(student2);
        attendance4.setCheck(AttendanceCheck.ABSENCE);
        attendance4.setaClass(aClass2);

        attendanceService.save(attendance4);
        logger.info("saving an Attendance 4");

    }
}
