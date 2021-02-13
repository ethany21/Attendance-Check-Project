package com.github.project.attendacecheck.model;

import java.util.ArrayList;

public class AttendanceWrapper {


    ArrayList<Attendance> attendances = new ArrayList<>();

    public void generator(int length) {
        for (int i = 0; i < length; i++){
            attendances.add(new Attendance());
        }
    }

    public ArrayList<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(ArrayList<Attendance> attendances) {
        this.attendances = attendances;
    }
}
