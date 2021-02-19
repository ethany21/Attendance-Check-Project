package com.github.project.attendancecheck.service.interfaces;

import com.github.project.attendancecheck.model.PaidFee;
import org.springframework.data.repository.query.Param;

public interface PaidFeeService extends CrudService<PaidFee, Long>{

    int showBudget();

    int sumPaidFeeByStudent(@Param("studentId") Long id);

}
