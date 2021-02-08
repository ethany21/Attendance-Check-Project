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
@RequestMapping("/attendances")
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final StudentService studentService;
    private final ClassService classService;

    public AttendanceController(AttendanceService attendanceService, StudentService studentService, ClassService classService) {
        this.attendanceService = attendanceService;
        this.studentService = studentService;
        this.classService = classService;
    }

    @RequestMapping(value = "/class/{id}")
    public String CheckAttendances(@PathVariable(name = "id") String id, Model model){

        model.addAttribute("aClass", classService.findById(new Long(id)));

        model.addAttribute("students", studentService.findAll());

        model.addAttribute("attendance", new Attendance());
        attendanceService.save((Attendance)model.getAttribute("attendance"));
        return "Attendance/checkAttendances";
    }

}
