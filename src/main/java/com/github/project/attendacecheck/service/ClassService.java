package com.github.project.attendacecheck.service;

import com.github.project.attendacecheck.model.Class;
import java.util.Date;

public interface ClassService extends CrudService<Class, Long>{

    Class findByTopic(String topic);

    Class findByDate(Date date);
}
