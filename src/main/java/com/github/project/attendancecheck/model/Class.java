package com.github.project.attendancecheck.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "class")
public class Class{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String topic;

    private String description;

    private String instructor;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "AClass")
    private List<Attendance> attendances = new ArrayList<>();

    @Override
    public String   toString() {
        return "Class{" +
                "id=" + id +
                ", date=" + date +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}


