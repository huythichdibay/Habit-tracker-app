package com.example.habittrackerapp.models;

import java.util.Date;

public class Habit {
    int Id;
    String Name;
    Date StartDate;
    String Description;
    int Type; //1 -> daily, 2 -> weekly, 3 -> monthly
    int Goal;
    int RepeatedDaily; //1 -> morning, 2 -> afternoon, 3 -> evening, 13 -> morning + evening, ...

    public Habit(String name, Date startDate, String description, int type, int goal, int repeatedDaily) {
        Name = name;
        StartDate = startDate;
        Description = description;
        Type = type;
        Goal = goal;
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

    public int getRepeatedDaily() {
        return RepeatedDaily;
    }

    public void setRepeatedDaily(int repeatedDaily) {
        RepeatedDaily = repeatedDaily;
    }
}
