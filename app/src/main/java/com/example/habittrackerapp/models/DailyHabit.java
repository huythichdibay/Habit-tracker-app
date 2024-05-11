package com.example.habittrackerapp.models;

import java.util.Date;

public class DailyHabit extends Habit{
    String Days;//VD t2, t3, t5, t6,CN -> "2,3,4,5,8"

    public DailyHabit() {
    }

    public DailyHabit(
            int id, String name,
            Date startDate, Date endDate,
            String description, int type,
            int goal, int goalType, int goalAmount,
            int status, int repeatedDaily,
            String days) {
        super(
                id, name, startDate,
                endDate, description, type,
                goal, goalType, goalAmount,
                status, repeatedDaily);
        Days = days;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String days) {
        Days = days;
    }
}
