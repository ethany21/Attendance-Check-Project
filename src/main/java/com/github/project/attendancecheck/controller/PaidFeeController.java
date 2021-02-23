package com.github.project.attendancecheck.controller;

import com.github.project.attendancecheck.model.PaidFee;
import com.github.project.attendancecheck.model.Student;
import com.github.project.attendancecheck.service.interfaces.AddPaymentService;
import com.github.project.attendancecheck.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/paidFee")
@RequiredArgsConstructor
public class PaidFeeController {

    private final StudentService studentService;
    private final AddPaymentService addPaymentService;

    @GetMapping({"/", ""})
    public String studentList(Model model){

        List<Student> students = studentService.findAll();

        model.addAttribute("students", students);

        return "PaidFee/showStudentList";

    }

    @GetMapping("/payFee")
    public String payFee(@RequestParam("studentId") long id, Model model){

        Student student = studentService.findById(id);

        PaidFee paidFee = new PaidFee();

        model.addAttribute("student", student);

        model.addAttribute("paidFee", paidFee);

        return "PaidFee/addPaidFee";
    }

    @PostMapping("/saveFee")
    public String saveFee(@ModelAttribute("paidFee") PaidFee paidFee, @RequestParam Long studentId){

        addPaymentService.addPayment(paidFee, studentId);

        return "redirect:/paidFee";
    }
}
