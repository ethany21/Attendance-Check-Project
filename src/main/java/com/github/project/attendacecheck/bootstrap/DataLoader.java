package com.github.project.attendacecheck.bootstrap;

import com.github.project.attendacecheck.model.Attendance;
import com.github.project.attendacecheck.model.AttendanceCheck;
import com.github.project.attendacecheck.model.Class;
import com.github.project.attendacecheck.model.Student;

import java.time.LocalDate;
import java.util.Date;

public class DataLoader {

    public void dataLoad(){
        Class aClass = new Class();
        aClass.setId(1l);
        aClass.setDate(new Date());
        aClass.setTopic("Engineering");

        Student student = new Student();
        student.setEmail("imwoodam@hanmail.net");
        student.setId(1l);
        student.setBirthDate(LocalDate.of(2019, 9, 12));


        Attendance attendance = new Attendance();

        attendance.setStudent(student);
        attendance.setCheck(AttendanceCheck.LATE);
        attendance.setaClass(aClass);


    }
}
