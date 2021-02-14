package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.model.Attendance;
import com.github.project.attendancecheck.model.Class;
import com.github.project.attendancecheck.model.Student;

import java.util.List;

public interface AttendanceService extends CrudService<Attendance, Long>{

    List<Attendance> findAllByStudent_Id(Long id);

    List<Attendance> findAllByAClass_Id(Long id);

    <S extends Attendance> List<S> saveAll(Iterable<S> iterable);

}
