package com.github.project.attendacecheck.controller;

import com.github.project.attendacecheck.model.Class;
import org.springframework.stereotype.Controller;
import com.github.project.attendacecheck.service.ClassService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@RequestMapping("/class")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    @RequestMapping({"/", ""})
    public String showClasses(Model model){

        Set<Class> classes = classService.findAll();

        model.addAttribute("classes", classes);

        return "Class/showClasses";
    }


    @PostMapping
    @RequestMapping("/addClass")
    public String addClass(Model model){
        return "Class/addClass";
    }

    @GetMapping
    @RequestMapping("/aClassDetails")
    public String showClassDetails(@RequestParam("classId") long id, Model model){

        Class aClass = classService.findById(id);

        model.addAttribute("details", aClass);

        return "Class/showClassDetails";
    }
}
