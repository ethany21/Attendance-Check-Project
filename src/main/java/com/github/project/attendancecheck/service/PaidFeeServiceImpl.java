package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.model.PaidFee;
import com.github.project.attendancecheck.repository.PaidFeeRepository;
import com.github.project.attendancecheck.service.interfaces.PaidFeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaidFeeServiceImpl implements PaidFeeService {

    private final PaidFeeRepository paidFeeRepository;


    /**
     모든 학생 들이 낸 벌금 총합 즉 예산(==budget)을 return
     **/
    @Override
    public int showBudget() {
        return paidFeeRepository.showBudget().orElse(0);
    }

    /**
     각 학생 마다 지불한 벌금 액의 총합을 return
     **/
    @Override
    public int sumPaidFeeByStudent(Long id) {
        return paidFeeRepository.sumPaidFeeByStudent(id).orElse(0);
    }

    @Override
    public List<PaidFee> findAll() {

        List<PaidFee> paidFees = new ArrayList<>();

        paidFeeRepository.findAll().forEach(paidFees::add);

        return paidFees;
    }

    @Override
    public PaidFee findById(Long aLong) {
        return paidFeeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PaidFee save(PaidFee object) {
        return paidFeeRepository.save(object);
    }

    @Override
    public void delete(PaidFee object) {
        paidFeeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        paidFeeRepository.deleteById(aLong);
    }
}
