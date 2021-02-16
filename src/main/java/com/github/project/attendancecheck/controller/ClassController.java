package com.github.project.attendancecheck.controller;

import com.github.project.attendancecheck.model.Class;
import org.springframework.stereotype.Controller;
import com.github.project.attendancecheck.service.interfaces.ClassService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping({"/", ""})
    public String showClasses(Model model){

        List<Class> classes = classService.findAll();

        model.addAttribute("classes", classes);

        return "Class/showClasses";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Class aClass = new Class();

        model.addAttribute("aClass", aClass);

        return "Class/addClass";

    }

    @PostMapping("/addClass")
    public String addClass(@ModelAttribute("aClass") Class aClass){

        classService.save(aClass);

        return "redirect:/class";
    }

    @GetMapping("/aClassDetails")
    public String showClassDetails(@RequestParam("classId") long id, Model model){

        Class aClass = classService.findById(id);

        model.addAttribute("details", aClass);

        return "Class/showClassDetails";
    }
}
