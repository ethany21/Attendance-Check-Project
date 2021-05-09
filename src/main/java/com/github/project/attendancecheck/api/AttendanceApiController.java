package com.github.project.attendancecheck.api;

import com.github.project.attendancecheck.model.Attendance;
import com.github.project.attendancecheck.model.AttendanceWrapper;
import com.github.project.attendancecheck.model.Class;
import com.github.project.attendancecheck.service.interfaces.AttendanceService;
import com.github.project.attendancecheck.service.interfaces.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AttendanceApiController {

    private final AttendanceService attendanceService;
    private final ClassService classService;

    @GetMapping("/attendances")
    public List<Class> showClasses(){
        List<Class> classes = classService.findAll();
        return classes;
    }
    @GetMapping("/checkAttendances")
    public AttendanceWrapper createAttendances(@RequestParam("classId") Long id){
        return attendanceService.createAttendances(new AttendanceWrapper(), id);
    }

    @PostMapping("/saveAttendances")
    public void saveAttendances(@ModelAttribute AttendanceWrapper attendanceWrapper, @RequestParam Long classId){
        attendanceService.setAttendancesDate(attendanceWrapper, classId);
    }



}
