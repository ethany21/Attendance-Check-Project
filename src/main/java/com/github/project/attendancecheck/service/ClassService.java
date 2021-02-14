package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.model.Class;
import java.util.Date;

public interface ClassService extends CrudService<Class, Long>{

    Class findByTopic(String topic);

    Class findByDate(Date date);
}
