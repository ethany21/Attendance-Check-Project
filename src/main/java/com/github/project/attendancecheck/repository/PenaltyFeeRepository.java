package com.github.project.attendancecheck.repository;

import com.github.project.attendancecheck.model.PenaltyFee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenaltyFeeRepository extends JpaRepository<PenaltyFee, Long> {

}
