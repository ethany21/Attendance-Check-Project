package com.github.project.attendacecheck.service;

import com.github.project.attendacecheck.model.Class;
import com.github.project.attendacecheck.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ClassServiceImpl implements ClassService{

    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Set<Class> findAll() {

        Set<Class> classes = new HashSet<>();

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
