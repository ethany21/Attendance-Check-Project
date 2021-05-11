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

    /**출석 체크해야 할 수업 일자를 리스트로 열거*/
    @GetMapping("/attendances")
    public List<Class> showClasses(){
        List<Class> classes = classService.findAll();
        return classes;
    }

    /**수업 일자를 선택하면, 학생들의 수 만큼 attendance 객체를 view로 전송*/
    @GetMapping("/checkAttendances")
    public AttendanceWrapper createAttendances(@RequestParam("classId") Long id){
        return attendanceService.createAttendances(new AttendanceWrapper(), id);
    }

    /**view 쪽에서 저장을 누르면 attendance 객체 연관관계 매핑 후 저장*/
    @PostMapping("/saveAttendances")
    public void saveAttendances(@ModelAttribute AttendanceWrapper attendanceWrapper, @RequestParam Long classId){
        attendanceService.setAttendancesDate(attendanceWrapper, classId);
    }



}
