package com.github.project.attendacecheck.repository;

import com.github.project.attendacecheck.model.Class;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface ClassRepository extends CrudRepository<Class, Long> {

    Class findByTopic(String topic);

    Class findByDate(Date date);

}
