package com.github.project.attendancecheck.service;

import com.github.project.attendancecheck.model.PaidFee;
import com.github.project.attendancecheck.model.Student;
import com.github.project.attendancecheck.repository.PaidFeeRepository;
import com.github.project.attendancecheck.repository.StudentRepository;
import com.github.project.attendancecheck.service.interfaces.AddPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddPaymentServiceImpl implements AddPaymentService {

    private final PaidFeeRepository paidFeeRepository;
    private final StudentRepository studentRepository;

    @Override
    public void addPayment(PaidFee paidFee, Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        paidFee.setStudent(student);
        paidFeeRepository.save(paidFee);
    }
}
