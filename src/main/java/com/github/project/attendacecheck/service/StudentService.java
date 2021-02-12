package com.github.project.attendacecheck.service;

import com.github.project.attendacecheck.model.Student;

import java.util.List;

public interface StudentService extends CrudService<Student, Long> {

    <S extends Student> List<S> saveAll(Iterable<S> iterable);
}
