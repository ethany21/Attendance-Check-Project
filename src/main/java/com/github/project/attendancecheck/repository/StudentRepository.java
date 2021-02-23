package com.github.project.attendancecheck.repository;

import com.github.project.attendancecheck.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    <S extends Student> List<S> saveAll(Iterable<S> iterable);

    Student findByUsername(String username);

}
