package com.github.project.attendacecheck.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "class")
public class Class extends BaseEntity{

    private Date date;

    private String topic;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_class",
            joinColumns =@JoinColumn(name = "class_id"),
            inverseJoinColumns =@JoinColumn(name = "student_id")
    )
    private Set<Student> students = new HashSet<>();
}
