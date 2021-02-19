package com.github.project.attendancecheck.repository;

import com.github.project.attendancecheck.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findAllByStudent_Id(Long id);

    List<Attendance> findAllByAClass_Id(Long id);

    @Query("SELECT sum(a.penaltyFee) from Attendance as a where a.student.id = :id")
    Optional<Integer> sumPenaltyFee(@Param("id") Long id);

    @Override
    <S extends Attendance> List<S> saveAll(Iterable<S> iterable);
}
