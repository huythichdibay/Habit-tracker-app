package com.example.habittrackerapp.models;

import java.util.Date;

public class DailyHabit extends Habit{
    int HabitId;
    String Days;//VD t2, t3, t5, t6,CN -> "2,3,4,5,8"

    public DailyHabit() {
    }

    public DailyHabit(int habitId, String days) {
        HabitId = habitId;
        Days = days;
    }

    public DailyHabit(
            int id, String name,
            Date startDate, Date endDate,
            int type,
            int goal, int goalType, int goalAmount,
            int status, int repeatedDaily,
            String days) {
        super(
                id, name, startDate,
                endDate, type,
                goal, goalType, goalAmount,
                status, repeatedDaily);
        Days = days;
    }

    public int getHabitId() {
        return HabitId;
    }

    public void setHabitId(int habitId) {
        HabitId = habitId;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String days) {
        Days = days;
    }
}
