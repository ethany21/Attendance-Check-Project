package com.github.project.attendancecheck.repository;

import com.github.project.attendancecheck.model.Attendance;
import com.github.project.attendancecheck.model.Class;
import com.github.project.attendancecheck.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findAllByStudent_Id(Long id);

    List<Attendance> findAllByAClass_Id(Long id);

    @Query("SELECT sum(a.penaltyFee) from Attendance as a where a.student.id = :id")
    int sumPenaltyFee(@Param("id") Long id);

    @Override
    <S extends Attendance> List<S> saveAll(Iterable<S> iterable);
}
