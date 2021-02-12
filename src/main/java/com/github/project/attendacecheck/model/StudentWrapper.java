package com.github.project.attendacecheck.model;

import java.util.ArrayList;
import java.util.List;

public class StudentWrapper {
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    private List<Student> studentList = new ArrayList<>();



}
