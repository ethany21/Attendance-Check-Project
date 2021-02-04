package com.github.project.attendacecheck.service;

import com.github.project.attendacecheck.model.Class;
import com.github.project.attendacecheck.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
public class ClassServiceImpl implements ClassService{

    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Set<Class> findAll() {
        return null;
    }

    @Override
    public Class findById(Long aLong) {
        return null;
    }

    @Override
    public Class save(Class object) {
        return null;
    }

    @Override
    public void delete(Class object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Class findByTopic(String topic) {
        return null;
    }

    @Override
    public Class findByDate(Date date) {
        return null;
    }
}
