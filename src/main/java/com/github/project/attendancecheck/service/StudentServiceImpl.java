package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.model.Gender;
import com.github.project.attendancecheck.model.Role;
import com.github.project.attendancecheck.model.Student;
import com.github.project.attendancecheck.repository.StudentRepository;
import com.github.project.attendancecheck.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void setStudent(String username, Student student) {
        studentRepository.setStudent(username, student.getName(), student.getBirthDate(), student.getEmail(), student.getGender(), student.getMajor());
    }

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
