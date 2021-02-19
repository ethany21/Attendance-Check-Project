package com.github.project.attendancecheck.service.interfaces;

import com.github.project.attendancecheck.model.PaidFee;

public interface AddPaymentService {

    void addPayment(PaidFee paidFee, Long studentId);

}
