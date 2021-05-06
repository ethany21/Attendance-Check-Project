package com.github.project.attendancecheck.controller;

import com.github.project.attendancecheck.model.Attendance;
import com.github.project.attendancecheck.model.AttendanceWrapper;
import com.github.project.attendancecheck.model.Class;
import com.github.project.attendancecheck.model.Student;
import com.github.project.attendancecheck.service.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attendances")
@RequiredArgsConstructor
public class AttendanceController {


    /**
     해결책: Class, Student List, Attendance 를 저장할 수 있는 Service interface 를 만들고 구현 한다
     그 Service 에서 만든 함수를 이 Controller 에서 사용 한다면 static 변수를 사용 하지 않아도 된다
     **/

    private final PaidFeeService paidFeeService;
    private final AttendanceService attendanceService;
    private final StudentService studentService;
    private final ClassService classService;

    /**
     우선 수업 목록 들을 펼친 다음에, 해당 수업을 선택 해서 들어 가면(href 태그 처리) 그 안에서 해당 수업의 출석 체크를 할 수 있다.
     **/
    @GetMapping({"/", ""})
    public String showClasses(Model model){

        List<Class> classes = classService.findAll();

        model.addAttribute("classes", classes);

        return "Attendance/showClassList";
    }

    /**
     한 수업에 들어 갔다면, 위에서 아래로 존재하는 학생들 이름이 나오고, 그 옆으로 attendance의 enum list를 옵션으로 택할 수 있다
     attendance 인스턴스에, 출석 체크를 하는 일자의 수업 객체를 setaClass(aClass), 각각의 학생을 setStudent(student)로 저장한다
     **/
    @GetMapping("/checkAttendance")
    public String checkAttendances(@RequestParam("classId") long id, Model model){

        model.addAttribute("aClass", classService.findById(id));

//        model.addAttribute("students", studentService.findAll());

        model.addAttribute("attendanceList", attendanceService.createAttendances(new AttendanceWrapper(), id));

        return "Attendance/checkAttendances";
    }
    /**
     save 누르면, checkAttendances view에서 옵션으로 선택한 출석 내역들이 일괄적으로 저장되고, 다시 수업 목록들로 되돌아간다
     **/
    @PostMapping("/saveAttendances")
    public String saveAttendances(@ModelAttribute("attendanceList") AttendanceWrapper attendanceWrapper, @RequestParam Long classId){

        attendanceService.setAttendancesDate(attendanceWrapper, classId);

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

        int paidFee = paidFeeService.sumPaidFeeByStudent(id);

        int restPayment = attendanceService.restPayment(id);

        model.addAttribute("attendances", attendances);

        model.addAttribute("sumPenaltyFee", sumPenaltyFee);

        model.addAttribute("paidFee", paidFee);

        model.addAttribute("restPayment", restPayment);

        return "Attendance/getStudentFee";
    }

}
