package com.example.habittrackerapp.models;

import java.util.Date;

public class HabitRecord {
    int HabitId;
    Date Date;
    String Status; // Overdue, Done, Not Yet, In Progress
    int Goal; //so lan lam duoc

    public HabitRecord(int habitId, java.util.Date date, String status, int goal) {
        HabitId = habitId;
        Date = date;
        Status = status;
        Goal = goal;
    }

    public int getHabitId() {
        return HabitId;
    }

    public void setHabitId(int habitId) {
        HabitId = habitId;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
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
}
