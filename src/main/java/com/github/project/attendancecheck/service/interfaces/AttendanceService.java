package com.github.project.attendancecheck.service.interfaces;

import com.github.project.attendancecheck.model.Attendance;
import com.github.project.attendancecheck.model.AttendanceWrapper;
import com.github.project.attendancecheck.model.Student;

import java.util.List;

public interface AttendanceService extends CrudService<Attendance, Long>{

    List<Attendance> findAllByStudent_Id(Long id);

    List<Attendance> findAllByAClass_Id(Long id);

    int sumPenaltyFee(Long id);

    <S extends Attendance> List<S> saveAll(Iterable<S> iterable);

    int restPayment(Long id);

    AttendanceWrapper createAttendances(AttendanceWrapper attendanceWrapper);

    void setAttendancesDate(AttendanceWrapper attendanceWrapper, long classId);

}
