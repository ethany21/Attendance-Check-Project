package com.github.project.attendancecheck.controller;

import com.github.project.attendancecheck.model.Attendance;
import com.github.project.attendancecheck.model.Student;
import com.github.project.attendancecheck.service.interfaces.AttendanceService;
import com.github.project.attendancecheck.service.interfaces.ClassService;
import com.github.project.attendancecheck.service.interfaces.PaidFeeService;
import com.github.project.attendancecheck.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/myPage")
@RequiredArgsConstructor
public class MyPageController {

    private final StudentService studentService;
    private final ClassService classService;
    private final PaidFeeService paidFeeService;
    private final AttendanceService attendanceService;

    @GetMapping({"/", ""})
    public String myPage(Model model, Principal principal){

        Student student = studentService.findByUsername(principal.getName());

        model.addAttribute("student", student);

        return "MyPage/myPage";
    }

    @GetMapping("/myInfo")
    public String myInfo(Model model, Principal principal){

        Student student = studentService.findByUsername(principal.getName());

        model.addAttribute("details", student);

        return "MyPage/myInfo";

    }

    @GetMapping("/classList")
    public String classList(Model model, Principal principal){

        long id = studentService.findByUsername(principal.getName()).getId();

        List<Attendance> attendances = attendanceService.findAllByStudent_Id(id);

        model.addAttribute("attendances", attendances);

        return "MyPage/classList";

    }

    @GetMapping("/myFee")
    public String myFee(Model model, Principal principal){

        long id = studentService.findByUsername(principal.getName()).getId();

        List<Attendance> attendances = attendanceService.findAllByStudent_Id(id);

        int sumFee = attendanceService.sumPenaltyFee(id);

        int paidFee = paidFeeService.sumPaidFeeByStudent(id);

        int restPayment = attendanceService.restPayment(id);

        model.addAttribute("attendances", attendances);

        model.addAttribute("sumPenaltyFee", sumFee);

        model.addAttribute("paidFee", paidFee);

        model.addAttribute("restPayment", restPayment);


        return "MyPage/myFee";

    }

}
