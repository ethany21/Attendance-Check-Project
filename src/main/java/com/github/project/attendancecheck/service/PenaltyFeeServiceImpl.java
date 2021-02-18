package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.model.PenaltyFee;
import com.github.project.attendancecheck.repository.AttendanceRepository;
import com.github.project.attendancecheck.repository.PenaltyFeeRepository;
import com.github.project.attendancecheck.service.interfaces.PenaltyFeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PenaltyFeeServiceImpl implements PenaltyFeeService {

    private final AttendanceRepository attendanceRepository;
    private final PenaltyFeeRepository penaltyFeeRepository;

    public PenaltyFeeServiceImpl(AttendanceRepository attendanceRepository, PenaltyFeeRepository penaltyFeeRepository) {
        this.attendanceRepository = attendanceRepository;
        this.penaltyFeeRepository = penaltyFeeRepository;
    }

    @Override
    public List<PenaltyFee> findAll() {

        List<PenaltyFee> penaltyFees = new ArrayList<>();

        penaltyFeeRepository.findAll().forEach(penaltyFees::add);

        return penaltyFees;
    }

    @Override
    public PenaltyFee findById(Long aLong) {

        return penaltyFeeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PenaltyFee save(PenaltyFee object) {
        return penaltyFeeRepository.save(object);
    }

    @Override
    public void delete(PenaltyFee object) {
        penaltyFeeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        penaltyFeeRepository.deleteById(aLong);
    }
}
