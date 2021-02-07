package com.github.project.attendacecheck.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


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

    private Date birthDate;

    private String email;

    /**fine = 벌금 의미함**/
    private Long fine;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "student")
    private Set<Attendance> attendances = new HashSet<>();

    public void attend(Attendance attendance){
        attendance.setStudent(this);
        this.attendances.add(attendance);
    }

}
