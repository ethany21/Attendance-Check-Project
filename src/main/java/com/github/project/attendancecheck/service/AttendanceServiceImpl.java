package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.model.Attendance;
import com.github.project.attendancecheck.model.Class;
import com.github.project.attendancecheck.model.Student;
import com.github.project.attendancecheck.repository.AttendanceRepository;
import com.github.project.attendancecheck.repository.ClassRepository;
import com.github.project.attendancecheck.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AttendanceServiceImpl implements AttendanceService{

    private final AttendanceRepository attendanceRepository;
    private final ClassRepository classRepository;
    private final StudentRepository studentRepository;

    @Override
    public <S extends Attendance> List<S> saveAll(Iterable<S> iterable) {
        return attendanceRepository.saveAll(iterable);
    }

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, ClassRepository classRepository, StudentRepository studentRepository) {
        this.attendanceRepository = attendanceRepository;
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Attendance> findByStudent(Student student) {

        List<Attendance> attendances = new ArrayList<>();

        attendanceRepository.findByStudent(student).forEach(attendances::add);

        return attendances;
    }

    @Override
    public List<Attendance> findByaClass(Class aClass) {

        List<Attendance> attendances = new ArrayList<>();

        attendanceRepository.findByaClass(aClass).forEach(attendances::add);
        return attendances;
    }

    @Override
    public List<Attendance> findAll() {
        List<Attendance> attendances = new ArrayList<>();

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
