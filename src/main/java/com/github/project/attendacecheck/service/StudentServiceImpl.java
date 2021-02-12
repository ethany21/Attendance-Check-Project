package com.github.project.attendacecheck.service;

import com.github.project.attendacecheck.model.Student;
import com.github.project.attendacecheck.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();

        studentRepository.findAll().forEach(students::add);

        return students;
    }


    @Override
    public <S extends Student> List<S> saveAll(Iterable<S> iterable) {
        return studentRepository.saveAll(iterable);
    }

    @Override
    public Student findById(Long aLong) {

        return studentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public void delete(Student object) {
        studentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        studentRepository.deleteById(aLong);
    }
}
