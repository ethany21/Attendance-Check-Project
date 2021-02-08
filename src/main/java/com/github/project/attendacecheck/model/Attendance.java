package com.github.project.attendacecheck.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "attendance")
@IdClass(AttendanceId.class)
public class Attendance implements Serializable {

    @Id@Column(name = "attendance_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private Class aClass;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "check_attendance")
    private AttendanceCheck check;

    public void setStudent(Student student){
        this.student = student;
        student.getAttendances().add(this);
    }

    public void setaClass(Class aClass){
        this.aClass = aClass;
        aClass.getAttendances().add(this);
    }

}
