package com.github.project.attendacecheck.service;

import com.github.project.attendacecheck.model.Attendance;
import com.github.project.attendacecheck.model.Class;
import com.github.project.attendacecheck.model.Student;
import com.github.project.attendacecheck.repository.AttendanceRepository;
import com.github.project.attendacecheck.repository.ClassRepository;
import com.github.project.attendacecheck.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AttendamceServiceImpl implements AttendanceService{

    private final AttendanceRepository attendanceRepository;
    private final ClassRepository classRepository;
    private final StudentRepository studentRepository;

    public AttendamceServiceImpl(AttendanceRepository attendanceRepository, ClassRepository classRepository, StudentRepository studentRepository) {
        this.attendanceRepository = attendanceRepository;
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Set<Attendance> findByStudent(Student student) {

        Set<Attendance> attendances = new HashSet<>();

        attendanceRepository.findByStudent(student).forEach(attendances::add);

        return attendances;
    }

    @Override
    public Set<Attendance> findByAClass(Class aClass) {

        Set<Attendance> attendances = new HashSet<>();

        attendanceRepository.findByAClass(aClass).forEach(attendances::add);
        return attendances;
    }

    @Override
    public Set<Attendance> findAll() {
        Set<Attendance> attendances = new HashSet<>();

        attendanceRepository.findAll().forEach(attendances::add);
        return attendances;
    }

    @Override
    public Attendance findById(Long aLong) {
        return attendanceRepository.findById(aLong).orElse(null);
    }

    @Override
    public Attendance save(Attendance object) {
        return attendanceRepository.save(object);
    }

    @Override
    public void delete(Attendance object) {
        attendanceRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        attendanceRepository.deleteById(aLong);
    }
}
