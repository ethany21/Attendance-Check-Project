package com.github.project.attendacecheck.repository;

import com.github.project.attendacecheck.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ClassRepository extends JpaRepository<Class, Long> {

    Class findByTopic(String topic);

    Class findByDate(Date date);

}
