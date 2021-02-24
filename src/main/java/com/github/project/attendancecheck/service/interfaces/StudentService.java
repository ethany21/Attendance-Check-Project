package com.github.project.attendancecheck.service.interfaces;

import com.github.project.attendancecheck.model.Gender;
import com.github.project.attendancecheck.model.Student;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface StudentService extends CrudService<Student, Long> , UserDetailsService {

    <S extends Student> List<S> saveAll(Iterable<S> iterable);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    Student findByUsername(String username);

    void setStudent(String username, Student student);
}
