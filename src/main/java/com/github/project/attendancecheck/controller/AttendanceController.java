package com.github.project.attendancecheck.controller;

import com.github.project.attendancecheck.model.Attendance;
import com.github.project.attendancecheck.model.AttendanceWrapper;
import com.github.project.attendancecheck.model.Class;
import com.github.project.attendancecheck.model.Student;
import com.github.project.attendancecheck.service.interfaces.AttendanceService;
import com.github.project.attendancecheck.service.interfaces.ClassService;
import com.github.project.attendancecheck.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attendances")
@RequiredArgsConstructor
public class AttendanceController {

    private static Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    private static Class presentClass;

    private final AttendanceService attendanceService;
    private final StudentService studentService;
    private final ClassService classService;

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

        presentClass = classService.findById(id);

        model.addAttribute("aClass", classService.findById(id));

        model.addAttribute("students", studentService.findAll());

        AttendanceWrapper attendanceWrapper = new AttendanceWrapper();
        for (int i = 0; i < studentService.findAll().size(); i++){

            attendanceWrapper.add(new Attendance());
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
            attendances.get(i).setAClass(presentClass);
            attendanceService.save(attendances.get(i));
        }
        return "redirect:/attendances";
    }

    @GetMapping("/classList")
    public String classList(Model model){

        List<Class> classes = classService.findAll();

        model.addAttribute("classes", classes);

        return "Attendance/classList";
    }


    @GetMapping("/getAttendances")
    public String getAttendances(@RequestParam("classId") long id, Model model){

        List<Attendance> attendances = attendanceService.findAllByAClass_Id(id);

        model.addAttribute("attendances", attendances);

        return "Attendance/getAttendances";
    }

    @GetMapping("/studentList")
    public String studentList(Model model){

        List<Student> students = studentService.findAll();

        model.addAttribute("students", students);

        return "Attendance/studentList";
    }

    @GetMapping("/getStudentAttendances")
    public String getStudentAttendances(@RequestParam("studentId") long id, Model model){

        List<Attendance> attendances = attendanceService.findAllByStudent_Id(id);

        model.addAttribute("attendances", attendances);

        return "Attendance/getStudentAttendances";
    }

    @GetMapping("/getStudentFee")
    public String getStudentFee(@RequestParam("studentId") long id, Model model){

        List<Attendance> attendances = attendanceService.findAllByStudent_Id(id);

        int sumPenaltyFee = attendanceService.sumPenaltyFee(id);

        model.addAttribute("attendances", attendances);

        model.addAttribute("sumPenaltyFee", sumPenaltyFee);

        return "Attendance/getStudentFee";
    }

}
