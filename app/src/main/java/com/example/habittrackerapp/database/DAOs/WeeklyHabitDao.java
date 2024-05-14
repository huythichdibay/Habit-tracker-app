package com.example.habittrackerapp.database.DAOs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.habittrackerapp.database.DatabaseHelper.DatabaseHandler;
import com.example.habittrackerapp.models.Habit;
import com.example.habittrackerapp.models.MonthlyHabit;
import com.example.habittrackerapp.models.WeeklyHabit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeeklyHabitDao {
    private SQLiteDatabase db;
    private HabitDao habitDao;
    public WeeklyHabitDao (Context context) {
        DatabaseHandler dbHandler = new DatabaseHandler (context);
        db = dbHandler.getWritableDatabase();
        habitDao = new HabitDao(context);
    }

    @SuppressLint("Range")
    public List<WeeklyHabit> GetData(String sql, String...selectionArgs) {
        List<WeeklyHabit> list = new ArrayList<WeeklyHabit>();
        Cursor c = db.rawQuery (sql, selectionArgs);
        while (c.moveToNext()) {
            WeeklyHabit habit = new WeeklyHabit();

            habit.setHabitId(c.getInt(c.getColumnIndex("HabitId")));
            habit.setDaysPerWeek(c.getInt(c.getColumnIndex("DaysPerWeek")));

            list.add(habit);
        }

        return list;
    }

    public List<WeeklyHabit> GetAll(){
        String sql = "SELECT * FROM WeeklyHabits";
        return GetData(sql);
    }

    public List<Habit> WeeklyHabitToHabitList(List<WeeklyHabit> weeklyHabits){
        List<Habit> habits = new ArrayList<>();

        for (WeeklyHabit dh: weeklyHabits) {
            habits.add( habitDao.GetById(dh.getHabitId()));
        }

        return habits;
    }
}
