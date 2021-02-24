package com.github.project.attendancecheck.repository;

import com.github.project.attendancecheck.model.Gender;
import com.github.project.attendancecheck.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    <S extends Student> List<S> saveAll(Iterable<S> iterable);

    Student findByUsername(String username);

    @Modifying
    @Transactional
    @Query("update Student s set s.name = :name, s.birthDate = :birthDate, s.email = :email, s.gender = :Gender, s.major = :major WHERE s.username = :username")
    void setStudent(@Param("username") String username,
                    @Param("name") String name,
                    @Param("birthDate")LocalDate date,
                    @Param("email")String email,
                    @Param("Gender")Gender gender,
                    @Param("major")String major);

}
