package com.github.project.attendacecheck.repository;

import com.github.project.attendacecheck.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
