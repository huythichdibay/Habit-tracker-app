package com.example.habittrackerapp.models;

import java.util.Date;

public class Habit {
    int Id;
    String Name;
    Date StartDate;
    Date EndDate;
    String Description;
    int Type; //1 -> daily, 2 -> weekly, 3 -> monthly, 0 -> one time task
    int Goal;
    int GoalType; // 1. goal by times(so lan thuc hien), 2. Time (tgian thuc hien theo phut)
    int GoalAmount;
    int Status; // 1. In Progress, 2. Done, 3. Inactive
    int RepeatedDaily; //1 -> morning, 2 -> afternoon, 3 -> evening, 13 -> morning + evening, ...

    public Habit() {
    }

    public Habit(
            int id, String name,
            Date startDate, Date endDate, String description, int type,
            int goal, int goalType, int goalAmount,
            int status, int repeatedDaily) {
        Id = id;
        Name = name;
        StartDate = startDate;
        EndDate = endDate;
        Description = description;
        Type = type;
        Goal = goal;
        GoalType = goalType;
        GoalAmount = goalAmount;
        Status = status;
        RepeatedDaily = repeatedDaily;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public int getGoal() {
        return Goal;
    }

    public void setGoal(int goal) {
        Goal = goal;
    }

    public int getGoalType() {
        return GoalType;
    }

    public void setGoalType(int goalType) {
        GoalType = goalType;
    }

    public int getGoalAmount() {
        return GoalAmount;
    }

    public void setGoalAmount(int goalAmount) {
        GoalAmount = goalAmount;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getRepeatedDaily() {
        return RepeatedDaily;
    }

    public void setRepeatedDaily(int repeatedDaily) {
        RepeatedDaily = repeatedDaily;
    }
}
