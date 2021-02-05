package com.github.project.attendacecheck.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "attendance")
public class Attendance implements Serializable {

    @Id@Column(name = "attendance_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;

    @Enumerated(value = EnumType.STRING)
    private AttendanceCheck check;

}
