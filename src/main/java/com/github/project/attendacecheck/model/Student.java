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
public class Student extends BaseEntity {

    private String name;

    private String major;

    private Date birthDate;

    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @ManyToMany
    private Set<Class> classes = new HashSet<>();

}
