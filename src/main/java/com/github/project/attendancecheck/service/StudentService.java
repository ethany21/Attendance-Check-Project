package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.model.Student;

import java.util.List;

public interface StudentService extends CrudService<Student, Long> {

    <S extends Student> List<S> saveAll(Iterable<S> iterable);
}
