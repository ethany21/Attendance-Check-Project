package com.github.project.attendacecheck.controller;

import com.github.project.attendacecheck.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @RequestMapping({"", "/"})
    public String showStudents(Model model){
        return "Student/showStudents";
    }

    @PostMapping
    @RequestMapping("/addStudent")
    public String addStudent(Model model){
        return "Student/addStudent";
    }

}
