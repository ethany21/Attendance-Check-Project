package com.github.project.attendancecheck.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="paidFee")
public class PaidFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int paidFee;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public void setStudent(Student student){
        this.student = student;
        student.getPaidFees().add(this);
    }

}
