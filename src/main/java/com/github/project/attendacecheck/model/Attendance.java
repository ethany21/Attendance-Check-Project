package com.github.project.attendacecheck.model;

import javax.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;

    @Enumerated(value = EnumType.STRING)
    private AttendanceCheck check;

}
