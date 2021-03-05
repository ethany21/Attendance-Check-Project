package com.github.project.attendancecheck.controller;

import com.github.project.attendancecheck.bootstrap.DataLoader;
import com.github.project.attendancecheck.model.Role;
import com.github.project.attendancecheck.model.Student;
import com.github.project.attendancecheck.service.interfaces.PaidFeeService;
import com.github.project.attendancecheck.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private static Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private final PaidFeeService paidFeeService;
    private final StudentService studentService;

    @RequestMapping({"/", ""})
    public String indexPage(){

        return "index";
    }

    @RequestMapping("/budget")
    public String showBudget(Model model){

        int budget = paidFeeService.showBudget();

        model.addAttribute("budget", budget);

        return "showBudget";
    }

    @GetMapping("/admin")
    public String adminPage(Principal principal){

        logger.info(principal.getName());

        String result = null;

        Student student = studentService.findByUsername(principal.getName());

        if(student.getRole().equals(Role.ROLE_ADMIN)) {
            return "Admin/adminPage";
        }

        result =  "Admin/goBackToIndex";

        return result;
    }

}
