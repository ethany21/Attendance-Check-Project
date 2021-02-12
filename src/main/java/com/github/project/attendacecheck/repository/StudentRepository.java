package com.github.project.attendacecheck.repository;

import com.github.project.attendacecheck.model.Attendance;
import com.github.project.attendacecheck.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    <S extends Student> List<S> saveAll(Iterable<S> iterable);

}
