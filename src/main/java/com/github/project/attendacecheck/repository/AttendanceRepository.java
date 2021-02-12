package com.github.project.attendacecheck.repository;

import com.github.project.attendacecheck.model.Attendance;
import com.github.project.attendacecheck.model.Class;
import com.github.project.attendacecheck.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByStudent(Student student);

    List<Attendance> findByaClass(Class aClass);

    @Override
    <S extends Attendance> List<S> saveAll(Iterable<S> iterable);
}
