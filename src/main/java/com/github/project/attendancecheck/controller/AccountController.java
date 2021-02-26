package com.github.project.attendancecheck.controller;

import com.github.project.attendancecheck.model.Student;
import com.github.project.attendancecheck.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.descriptor.java.SerializableTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private PasswordEncoder passwordEncoder;

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
    public String register(@ModelAttribute("student") Student student, Model model){

        studentService.save(student);

        model.addAttribute("student", student);

        return "Account/registerCheck";

    }

    @GetMapping("/registerDetails")
    public String registerDetails(Model model, @RequestParam("userId") long id){

        Student student = studentService.findById(id);

        model.addAttribute("temp", student);

        return "Account/registerDetails";
    }

    @PostMapping("/saveDetails")
    public String registerDetails(@ModelAttribute("temp") Student temp, Principal principal){

        /**
         다음 code 들을, 서비스 layer 로 보낸다
         **/

        String username = principal.getName();

        Student student = studentService.findByUsername(username);

        temp.setPassword(passwordEncoder.encode(student.getPassword()));

        temp.setEnabled(true);

        studentService.update(temp);

        return "redirect:/";
    }
}
