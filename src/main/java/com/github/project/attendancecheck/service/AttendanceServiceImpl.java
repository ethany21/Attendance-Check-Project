package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.model.Attendance;
import com.github.project.attendancecheck.repository.AttendanceRepository;
import com.github.project.attendancecheck.repository.PaidFeeRepository;
import com.github.project.attendancecheck.service.interfaces.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final PaidFeeRepository paidFeeRepository;

    @Override
    public int restPayment(Long id){

        int sumPenaltyFee = attendanceRepository.sumPenaltyFee(id);

        int paidFee = paidFeeRepository.sumPaidFeeByStudent(id);

        int restPayment = sumPenaltyFee - paidFee;

        return restPayment;
    }

    @Override
    public <S extends Attendance> List<S> saveAll(Iterable<S> iterable) {
        return attendanceRepository.saveAll(iterable);
    }

    @Override
    public int sumPenaltyFee(Long id) {
        return attendanceRepository.sumPenaltyFee(id);
    }

    @Override
    public List<Attendance> findAllByStudent_Id(Long id) {

        List<Attendance> attendances = new ArrayList<>();

        attendanceRepository.findAllByStudent_Id(id).forEach(attendances::add);

        return attendances;
    }

    @Override
    public List<Attendance> findAllByAClass_Id(Long id) {

        List<Attendance> attendances = new ArrayList<>();

        attendanceRepository.findAllByAClass_Id(id).forEach(attendances::add);
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

        switch (object.getCheck()){
            case ATTEND:
                object.setPenaltyFee(0);
                break;
            case LATE:
                object.setPenaltyFee(3000);
                break;
            case ABSENCE:
                object.setPenaltyFee(10000);
                break;
        }

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
