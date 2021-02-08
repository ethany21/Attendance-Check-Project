package com.github.project.attendacecheck.repository;

import com.github.project.attendacecheck.model.Attendance;
import com.github.project.attendacecheck.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {



}
