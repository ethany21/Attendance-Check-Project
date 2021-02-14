package com.github.project.attendancecheck.model;
import java.util.ArrayList;
import java.util.List;

public class AttendanceWrapper {

    private List<Attendance> attendances;

    public AttendanceWrapper() {
        this.attendances = new ArrayList<Attendance>();
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public void add(Attendance attendance){
        this.attendances.add(attendance);
    }
}
