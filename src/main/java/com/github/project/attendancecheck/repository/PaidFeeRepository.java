package com.github.project.attendancecheck.repository;

import com.github.project.attendancecheck.model.PaidFee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaidFeeRepository extends JpaRepository<PaidFee, Long> {

}
