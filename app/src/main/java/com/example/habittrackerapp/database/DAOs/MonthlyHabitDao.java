package com.example.habittrackerapp.database.DAOs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.habittrackerapp.database.DatabaseHelper.DatabaseHandler;
import com.example.habittrackerapp.models.DailyHabit;
import com.example.habittrackerapp.models.Habit;
import com.example.habittrackerapp.models.MonthlyHabit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonthlyHabitDao {
    private SQLiteDatabase db;
    private HabitDao habitDao;

    public MonthlyHabitDao (Context context) {
        DatabaseHandler dbHandler = new DatabaseHandler (context);
        db = dbHandler.getWritableDatabase();
        habitDao = new HabitDao(context);
    }

    @SuppressLint("Range")
    public List<MonthlyHabit> GetData(String sql, String...selectionArgs) {
        List<MonthlyHabit> list = new ArrayList<MonthlyHabit>();
        Cursor c = db.rawQuery (sql, selectionArgs);
        while (c.moveToNext()) {
            MonthlyHabit habit = new MonthlyHabit();

            habit.setHabitId(c.getInt(c.getColumnIndex("HabitId")));
            habit.setDaysPerMonth(c.getInt(c.getColumnIndex("DaysPerMonth")));
            habit.setTimeInMonth(c.getInt(c.getColumnIndex("TimeInMonth")));

            list.add(habit);
        }

        return list;
    }

    public List<MonthlyHabit> GetAll(){
        String sql = "SELECT * FROM MonthlyHabits";
        return GetData(sql);
    }

    public List<MonthlyHabit> GetByDate(Date Date){
        List<MonthlyHabit> list = GetAll();

        int date = Date.getDate();
        for (MonthlyHabit mh: list) {
            if(mh.getTimeInMonth()==1){
                if(date >= 10){
                    list.remove(mh);
                }
            }else if(mh.getTimeInMonth() == 2){
                if(date < 10 || date > 19){
                    list.remove(mh);
                }
            } else if (mh.getTimeInMonth() == 3) {
                if(date < 20){
                    list.remove(mh);
                }
            }
        }

        return list;
    }

    public List<Habit> MonthlyHabitToHabitList(List<MonthlyHabit> monthlyHabits){
        List<Habit> habits = new ArrayList<>();

        for (MonthlyHabit dh: monthlyHabits) {
            habits.add( habitDao.GetById(dh.getHabitId()));
        }

        return habits;
    }
}
