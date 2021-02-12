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


        Class aClass3 = new Class();
        aClass3.setDate(LocalDate.of(2019, 9, 15));
        aClass3.setTopic("Distributed Computing");
        aClass3.setDescription("Load Balancing resources, manage mutiple node, calculate from many computers");
        aClass3.setInstructor("jojoldu");

        classService.save(aClass3);
        logger.info("saving a Class 3");

        Class aClass4 = new Class();
        aClass4.setDate(LocalDate.of(2019, 9, 22));
        aClass4.setTopic("Apache Kafka");
        aClass4.setDescription("Message Queueing system with broker, Producer & Consumer");
        aClass4.setInstructor("Donut");

        classService.save(aClass4);
        logger.info("saving a Class 4");

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

        Student student3 = new Student();
        student3.setGender(Gender.MALE);
        student3.setMajor("Ghrapics");
        student3.setEmail("jojoldu@gmail.com");
        student3.setName("jojoldu");
        student3.setBirthDate(LocalDate.of(1986, 3, 2));
        studentService.save(student3);
        attendanceService.save(student3.attendCheck(AttendanceCheck.ATTEND, aClass2));
    }
}
