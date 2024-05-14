package com.example.habittrackerapp.models;

import java.util.Date;

public class HabitRecord {
    int Id;
    int HabitId;
    Date Date;
    String Status; //  Not Yet,  In Progress,  Done,  Overdue
    int Goal; //so lan lam duoc
    int TimeInDay; //1 morning, 2 afternoon, 3 evening

    public HabitRecord() {
    }

    public HabitRecord(int id, int habitId, java.util.Date date, String status, int goal, int timeInDay) {
        Id = id;
        HabitId = habitId;
        Date = date;
        Status = status;
        Goal = goal;
        TimeInDay = timeInDay;
    }

    public int getHabitId() {
        return HabitId;
    }

    public void setHabitId(int habitId) {
        HabitId = habitId;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getGoal() {
        return Goal;
    }

    public void setGoal(int goal) {
        Goal = goal;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getTimeInDay() {
        return TimeInDay;
    }

    public void setTimeInDay(int timeInDay) {
        TimeInDay = timeInDay;
    }
}
