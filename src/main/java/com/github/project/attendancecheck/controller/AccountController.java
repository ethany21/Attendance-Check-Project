package com.github.project.attendancecheck.controller;

import com.github.project.attendancecheck.model.Student;
import com.github.project.attendancecheck.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final StudentService studentService;

    @GetMapping("/login")
    public String login(){

        return "Account/login";
    }

    @GetMapping("/register")
    public String register(Model model){

        Student student = new Student();

        model.addAttribute("student", student);

        return "Account/register";
    }
    /**
     register 에서 username, password 등록 하고 save 누르면,
     전공, 생년 월일, 성별, 본명 등 개인 정보 저장 하는 page 로 이동 한다
     **/

    @PostMapping("/register")
    public String register(@ModelAttribute("student") Student student){

        studentService.save(student);

        return "redirect:/account/login";

    }
}
