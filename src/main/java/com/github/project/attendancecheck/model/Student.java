package com.github.project.attendancecheck.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String major;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private String email;

    /**fine = 벌금 의미함**/
    private Long fine;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "student")
    private List<Attendance> attendances = new ArrayList<>();
//
//    public Attendance attendCheck(AttendanceCheck check, Class aClass){
//        Attendance attendance = new Attendance();
//        attendance.setaClass(aClass);
//        attendance.setStudent(this);
//        attendance.setCheck(check);
//        return attendance;
//    }
}