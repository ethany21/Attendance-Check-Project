package com.github.project.attendacecheck.repository;

import com.github.project.attendacecheck.model.Attendance;
import com.github.project.attendacecheck.model.Class;
import com.github.project.attendacecheck.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Set;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Set<Attendance> findByStudent(Student student);

    Set<Attendance> findByAClass(Class aClass);

}
