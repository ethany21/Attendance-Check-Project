package com.github.project.attendancecheck.controller;

import com.github.project.attendancecheck.model.Attendance;
import com.github.project.attendancecheck.model.AttendanceWrapper;
import com.github.project.attendancecheck.model.Class;
import com.github.project.attendancecheck.service.AttendanceService;
import com.github.project.attendancecheck.service.ClassService;
import com.github.project.attendancecheck.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attendances")
public class AttendanceController {

    private static Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    private final AttendanceService attendanceService;
    private final StudentService studentService;
    private final ClassService classService;

    public AttendanceController(AttendanceService attendanceService, StudentService studentService, ClassService classService) {
        this.attendanceService = attendanceService;
        this.studentService = studentService;
        this.classService = classService;
    }
    /**
     우선 수업 목록들을 펼친 다음에, 해당 수업을 선택해서 들어가면(href 태그 처리) 그 안에서 해당 수업의 출석 체크를 할 수 있다.
     **/
    @GetMapping({"/", ""})
    public String showClasses(Model model){

        List<Class> classes = classService.findAll();

        model.addAttribute("classes", classes);

        return "Attendance/showClassList";
    }

    /**
     한 수업에 들어 갔다면, 위에서 아래로 존재하는 학생들 이름이 나오고, 그 옆으로 attendance의 enum list를 옵션으로 택할 수 있다
     attendace 인스턴스에, 출석 체크를 하는 일자의 수업 객체를 setaClass(aClass), 각각의 학생을 setStudent(student)로 저장한다
     **/
    @GetMapping("/checkAttendance")
    public String checkAttendances(@RequestParam("classId") long id, Model model){

        model.addAttribute("aClass", classService.findById(id));

        model.addAttribute("students", studentService.findAll());

        AttendanceWrapper attendanceWrapper = new AttendanceWrapper();
        for (int i = 0; i < studentService.findAll().size(); i++){

            Attendance attendance = new Attendance();
//            attendance.setAClass(classService.findById(id));
//            System.out.println(attendance.getAClass().getDate());
            attendanceWrapper.add(attendance);
        }

        model.addAttribute("attendanceList", attendanceWrapper);

        return "Attendance/checkAttendances";
    }
    /**
     save 누르면, checkAttendances view에서 옵션으로 선택한 출석 내역들이 일괄적으로 저장되고, 다시 수업 목록들로 되돌아간다
     **/
    @PostMapping("/saveAttendances")
    public String saveAttendances(@ModelAttribute("attendanceList") AttendanceWrapper attendanceWrapper){

        List<Attendance> attendances = attendanceWrapper.getAttendances();

        for (int i = 0; i < attendances.size(); i++){
            attendances.get(i).setStudent(studentService.findAll().get(i));
        }

        for (int i = 0; i < attendances.size(); i++){
            System.out.println(attendances.get(i).getAClass().getDate());
        }

        for (int i = 0; i < attendances.size(); i++){
            attendanceService.save(attendances.get(i));
        }
        return "redirect:/attendances";
    }

}
