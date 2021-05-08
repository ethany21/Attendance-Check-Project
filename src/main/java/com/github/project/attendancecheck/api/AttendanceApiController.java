package com.github.project.attendancecheck.api;

import com.github.project.attendancecheck.model.Class;
import com.github.project.attendancecheck.service.interfaces.AttendanceService;
import com.github.project.attendancecheck.service.interfaces.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AttendanceApiController {

    private final AttendanceService attendanceService;
    private final ClassService classService;

    @GetMapping("api/v1/attendances")
    public List<Class> showClasses(){
        List<Class> classes = classService.findAll();
        return classes;
    }


}
