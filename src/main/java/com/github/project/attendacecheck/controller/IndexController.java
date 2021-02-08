package com.github.project.attendacecheck.controller;

import com.github.project.attendacecheck.model.Attendance;
import com.github.project.attendacecheck.service.AttendanceService;
import com.github.project.attendacecheck.service.ClassService;
import com.github.project.attendacecheck.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/", ""})
    public String indexPage(){

        return "index";
    }
}
