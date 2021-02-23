package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.model.Role;
import com.github.project.attendancecheck.model.Student;
import com.github.project.attendancecheck.repository.StudentRepository;
import com.github.project.attendancecheck.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

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

        String encodedPassword = passwordEncoder.encode(object.getPassword());

        object.setPassword(encodedPassword);

        object.setEnabled(true);

        Role role = new Role();

        role.setId(2l);

        object.getRoles().add(role);

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
