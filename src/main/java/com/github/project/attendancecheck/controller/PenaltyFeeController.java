package com.github.project.attendancecheck.controller;

import com.github.project.attendancecheck.service.interfaces.AttendanceService;
import com.github.project.attendancecheck.service.interfaces.PenaltyFeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/penalty")
@RequiredArgsConstructor
public class PenaltyFeeController {

    private final PenaltyFeeService penaltyFeeService;
    private final AttendanceService attendanceService;




}
