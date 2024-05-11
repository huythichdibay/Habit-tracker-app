package com.example.habittrackerapp.models;

import java.util.Date;

public class MonthlyHabit extends Habit{
    int DaysPerMonth; // so ngay trong 1 thang 1->3
    int TimeInMonth; // thoi gian lam trong thang 0 -> 3: 0 la all, 1 la start, 2 la middle, 3 la end

    public MonthlyHabit() {
    }

    public MonthlyHabit(
            int id, String name,
            Date startDate, Date endDate,
            int type,
            int goal, int goalType, int goalAmount,
            int status, int repeatedDaily,
            int daysPerMonth, int timesInMonth) {
        super(
                id, name,
                startDate, endDate,
                type,
                goal, goalType, goalAmount,
                status, repeatedDaily);
        DaysPerMonth = daysPerMonth;
        TimeInMonth = timesInMonth;
    }

    public int getDaysPerMonth() {
        return DaysPerMonth;
    }

    public void setDaysPerMonth(int daysPerMonth) {
        DaysPerMonth = daysPerMonth;
    }

    public int getTimesInMonth() {
        return TimeInMonth;
    }

    public void setTimesInMonth(int timesInMonth) {
        TimeInMonth = timesInMonth;
    }
}
