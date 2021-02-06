package com.github.project.attendacecheck.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class AttendanceId implements Serializable {

    private long student;
    private long aClass;
}
