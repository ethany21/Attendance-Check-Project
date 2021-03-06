package com.github.project.attendancecheck.service;


import com.github.project.attendancecheck.model.Role;
import com.github.project.attendancecheck.model.Student;
import com.github.project.attendancecheck.repository.StudentRepository;
import com.github.project.attendancecheck.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Student findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Student student =studentRepository.findByUsername(username);
        if (student != null){
            return student;
        }
        throw new UsernameNotFoundException("Student '" + username + "' not found");
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();

        studentRepository.findAll().forEach(students::add);

        return students.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
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
    public Student update(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public Student save(Student object) {

        String encodedPassword = passwordEncoder.encode(object.getPassword());

        object.setPassword(encodedPassword);

        object.setEnabled(true);

        object.setRole(Role.ROLE_USER);

        return studentRepository.save(object);
    }

    public Student save(Student object, boolean check) {

        String encodedPassword = passwordEncoder.encode(object.getPassword());

        object.setPassword(encodedPassword);

        object.setEnabled(true);

        if(check){
            object.setRole(Role.ROLE_ADMIN);
        }

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
