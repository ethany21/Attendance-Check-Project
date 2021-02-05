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

    @OneToMany(mappedBy = "student")
    private Set<Attendance> attendances = new HashSet<>();
}
