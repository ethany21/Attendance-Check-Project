package com.github.project.attendancecheck.service.interfaces;

import com.github.project.attendancecheck.model.Attendance;

import java.util.List;

public interface AttendanceService extends CrudService<Attendance, Long>{

    List<Attendance> findAllByStudent_Id(Long id);

    List<Attendance> findAllByAClass_Id(Long id);

    <S extends Attendance> List<S> saveAll(Iterable<S> iterable);

}
