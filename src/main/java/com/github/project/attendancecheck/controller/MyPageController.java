package com.github.project.attendancecheck.controller;

import com.github.project.attendancecheck.service.interfaces.ClassService;
import com.github.project.attendancecheck.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/myPage")
@RequiredArgsConstructor
public class MyPageController {

    private final StudentService studentService;
    private final ClassService classService;

    @GetMapping({"/", ""})
    public String myPage(Model model, Principal principal){


        return "MyPage/myPage";
    }

    @GetMapping("/myInfo")
    public String myInfo(){

        return null;

    }

    @GetMapping("/classList")
    public String classList(){

        return null;

    }

    @GetMapping("/myFee")
    public String myFee(){

        return null;

    }

}
