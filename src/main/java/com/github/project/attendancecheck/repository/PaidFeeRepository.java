package com.github.project.attendancecheck.repository;

import com.github.project.attendancecheck.model.PaidFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaidFeeRepository extends JpaRepository<PaidFee, Long> {

    @Query("SELECT sum(p.paidFee) from PaidFee as p")
    int showBudget();

    @Query("SELECT sum(p.paidFee) from PaidFee as p where p.student.id = :studentId")
    int sumPaidFeeByStudent(@Param("studentId") Long id);

}
