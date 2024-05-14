package com.example.habittrackerapp.models;

import java.util.Date;

public class WeeklyHabit extends Habit{
    int HabitId;
    int DaysPerWeek; // so day trong 1 tuan 1->6

    public WeeklyHabit() {
    }

    public int getHabitId() {
        return HabitId;
    }

    public void setHabitId(int habitId) {
        HabitId = habitId;
    }

    public WeeklyHabit(int habitId, int daysPerWeek) {
        HabitId = habitId;
        DaysPerWeek = daysPerWeek;
    }

    public WeeklyHabit(
            int id, String name,
            Date startDate, Date endDate,
            int type,
            int goal, int goalType, int goalAmount,
            int status, int repeatedDaily,
            int daysPerWeek) {
        super(
                id, name,
                startDate, endDate,
                type,
                goal, goalType, goalAmount,
                status, repeatedDaily);
        DaysPerWeek = daysPerWeek;
    }

    public int getDaysPerWeek() {
        return DaysPerWeek;
    }

    public void setDaysPerWeek(int daysPerWeek) {
        DaysPerWeek = daysPerWeek;
    }
}
