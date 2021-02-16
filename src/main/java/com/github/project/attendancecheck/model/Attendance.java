package com.github.project.attendancecheck.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "attendance")
@IdClass(AttendanceId.class)
@AllArgsConstructor
@NoArgsConstructor
public class Attendance implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private Class AClass;

//    @Enumerated(value = EnumType.STRING)
//    @Column(name = "check_attendance")
//    private AttendanceCheck check;

    @Column(name = "check_attendance")
    private String check;

    @OneToOne
    @JoinColumn(name = "panaltyFee_id")
    private PenaltyFee penaltyFee;

    public void setStudent(Student student){
        this.student = student;
        student.getAttendances().add(this);
    }

    public void setAClass(Class aClass){
        this.AClass = aClass;
        aClass.getAttendances().add(this);
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "student=" + student +
                ", aClass=" + AClass +
                ", check='" + check + '\'' +
                '}';
    }
}
