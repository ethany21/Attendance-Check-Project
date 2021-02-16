package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.model.Class;
import com.github.project.attendancecheck.repository.ClassRepository;
import com.github.project.attendancecheck.service.interfaces.ClassService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public List<Class> findAll() {

        List<Class> classes = new ArrayList<>();

        classRepository.findAll().forEach(classes::add);
        return classes;
    }

    @Override
    public Class findById(Long aLong) {
        return classRepository.findById(aLong).orElse(null);
    }

    @Override
    public Class save(Class object) {
        return classRepository.save(object);
    }

    @Override
    public void delete(Class object) {
        classRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        classRepository.deleteById(aLong);
    }

    @Override
    public Class findByTopic(String topic) {
        return classRepository.findByTopic(topic);
    }

    @Override
    public Class findByDate(Date date) {
        return classRepository.findByDate(date);
    }
}
