package com.github.project.attendancecheck.repository;

import com.github.project.attendancecheck.model.PaidFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PaidFeeRepository extends JpaRepository<PaidFee, Long> {

    @Query("SELECT sum(p.paidFee) from PaidFee as p")
    Optional<Integer> showBudget();

    @Query("SELECT sum(p.paidFee) from PaidFee as p where p.student.id = :studentId")
    Optional<Integer> sumPaidFeeByStudent(@Param("studentId") Long id);

}
