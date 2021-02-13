package com.github.project.attendacecheck.controller;

import com.github.project.attendacecheck.model.Student;
import com.github.project.attendacecheck.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping({"", "/"})
    public String showStudents(Model model){

        List<Student> students = studentService.findAll();

        model.addAttribute("students", students);

        return "Student/showStudents";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Student student = new Student();

        model.addAttribute("student", student);

        return "Student/addStudent";
    }



    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Student student){


        studentService.save(student);

        return "redirect:/student";
    }

    @GetMapping("studentDetails")
    public String showStudentDetails(@RequestParam("studentId") long id, Model model){

        Student student = studentService.findById(id);

        model.addAttribute("details", student);

        return "Student/showStudentDetails";

    }

}
