package com.github.project.attendancecheck.controller;

import com.github.project.attendancecheck.service.interfaces.PaidFeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PaidFeeService paidFeeService;

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
    public String adminPage(){

        return "Admin/adminPage";
    }

}
