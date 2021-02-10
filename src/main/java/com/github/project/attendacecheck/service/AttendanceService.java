package com.github.project.attendacecheck.service;

import com.github.project.attendacecheck.model.Attendance;
import com.github.project.attendacecheck.model.Class;
import com.github.project.attendacecheck.model.Student;

import java.util.List;
import java.util.Set;

public interface AttendanceService extends CrudService<Attendance, Long>{

    Set<Attendance> findByStudent(Student student);

    Set<Attendance> findByaClass(Class aClass);

    <S extends Attendance> List<S> saveAll(Iterable<S> iterable);

}
