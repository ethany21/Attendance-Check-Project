package com.github.project.attendancecheck.repository;

import com.github.project.attendancecheck.model.Attendance;
import com.github.project.attendancecheck.model.Class;
import com.github.project.attendancecheck.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByStudent(Student student);

    List<Attendance> findByaClass(Class aClass);

    @Override
    <S extends Attendance> List<S> saveAll(Iterable<S> iterable);
}
