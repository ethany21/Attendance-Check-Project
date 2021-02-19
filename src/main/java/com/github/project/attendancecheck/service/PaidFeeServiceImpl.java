package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.model.PaidFee;
import com.github.project.attendancecheck.service.interfaces.PaidFeeService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaidFeeServiceImpl implements PaidFeeService {

    @Override
    public List<PaidFee> findAll() {
        return null;
    }

    @Override
    public PaidFee findById(Long aLong) {
        return null;
    }

    @Override
    public PaidFee save(PaidFee object) {
        return null;
    }

    @Override
    public void delete(PaidFee object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
