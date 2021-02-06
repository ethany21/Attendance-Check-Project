package com.github.project.attendacecheck.model;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;

@Entity
@Table(name = "attendance")
@IdClass(AttendanceId.class)
public class Attendance implements Serializable {

    @Id@Column(name = "attendance_id")
    private long id;

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "check_attendance")
    private AttendanceCheck check;

}
