package com.example.habittrackerapp.database.DAOs;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.habittrackerapp.database.DatabaseHelper.DatabaseHandler;
import com.example.habittrackerapp.models.DailyHabit;
import com.example.habittrackerapp.models.Habit;
import com.example.habittrackerapp.ultilities.DateUltilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailyHabitDao {
    private SQLiteDatabase db;
    private HabitDao habitDao;

    public DailyHabitDao (Context context) {
        DatabaseHandler dbHandler = new DatabaseHandler (context);
        db = dbHandler.getWritableDatabase();
        habitDao = new HabitDao(context);
    }

    @SuppressLint("Range")
    public List<DailyHabit> GetData(String sql, String...selectionArgs) {
        List<DailyHabit> list = new ArrayList<DailyHabit>();
        Cursor c = db.rawQuery (sql, selectionArgs);
        while (c.moveToNext()) {
            DailyHabit habit = new DailyHabit();

            habit.setHabitId(c.getInt(c.getColumnIndex("HabitId")));
            habit.setDays(c.getString(c.getColumnIndex("Days")));

            list.add(habit);
        }

        return list;
    }

//    public void Add(Habit habit){
//        ContentValues values = new ContentValues();
//
//        values.put("Name", category.getName());
//        values.put("Type", category.getType());
//
//        db.insert(  "Categories", null, values);
//    }
//
//    public void Update(Category category){
//        ContentValues values = new ContentValues();
//        values.put("Name", category.getName());
//        values.put("Type", category.getType());
//
//        db.update("Categories", values,"Id = ?", new String[] { String.valueOf(category.getId())});
//    }

//    public Category GetById(int Id){
//        Cursor c = db.query("Categories", null,"Id = ?", new String[] { String.valueOf(Id) },null, null, null);
//        if(c != null)
//            c.moveToFirst();
//        Category category = new Category(
//                c.getInt(0),
//                c.getString(1),
//                c.getInt(2)
//        );
//        return category;
//    }

    public List<DailyHabit> GetAll(){
        String sql = "SELECT * FROM DailyHabits";
        return GetData(sql);
    }

    public List<DailyHabit> GetByDate(Date date){
        List<DailyHabit> list = GetAll();

        int day = date.getDay();
        if(day==0){
            day = 8;
        }else {
            day ++;
        }
        String day_Str = String.valueOf(day);

        for (DailyHabit dh : list) {
            if(!dh.getDays().contains(day_Str)){
                list.remove(dh);
            }
        }

        return list;
    }

    public List<Habit> DailyHabitToHabitList(List<DailyHabit> dailyHabits){
        List<Habit> habits = new ArrayList<>();

        for (DailyHabit dh: dailyHabits) {
            habits.add( habitDao.GetById(dh.getHabitId()));
        }

        return habits;
    }
}
