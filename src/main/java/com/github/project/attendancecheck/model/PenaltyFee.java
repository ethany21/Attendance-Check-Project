package com.github.project.attendancecheck.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "penaltyFee")
@AllArgsConstructor
@NoArgsConstructor
public class PenaltyFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int fee;

    @OneToOne(mappedBy = "penaltyFee")
    private Attendance attendance;
}
