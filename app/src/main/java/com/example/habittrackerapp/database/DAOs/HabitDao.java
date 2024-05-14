package com.example.habittrackerapp.database.DAOs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.habittrackerapp.database.DatabaseHelper.DatabaseHandler;
import com.example.habittrackerapp.models.Habit;
import com.example.habittrackerapp.models.HabitRecord;
import com.example.habittrackerapp.ultilities.DateUltilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import kotlinx.coroutines.selects.WhileSelectKt;

public class HabitDao {
    private SQLiteDatabase db;
    HabitRecordDao habitRecordDao;
    public HabitDao (Context context) {
        DatabaseHandler dbHandler = new DatabaseHandler (context);
        db = dbHandler.getWritableDatabase();
        habitRecordDao = new HabitRecordDao(context);
    }

    @SuppressLint("Range")
    public List<Habit> GetData(String sql, String...selectionArgs) {
        List<Habit> list = new ArrayList<Habit>();
        Cursor c = db.rawQuery (sql, selectionArgs);
        while (c.moveToNext()) {
            Habit habit = new Habit();

            habit.setId(c.getInt(c.getColumnIndex("Id")));
            habit.setName(c.getString(c.getColumnIndex("Name")));
            habit.setStartDate(DateUltilities.StringToDate("dd/MM/yyyy" ,c.getString(c.getColumnIndex("StartDate"))));
            if(c.getString(c.getColumnIndex("EndDate")) != null){
                habit.setEndDate(DateUltilities.StringToDate("dd/MM/yyyy" ,c.getString(c.getColumnIndex("EndDate"))));
            }
            habit.setType(c.getInt(c.getColumnIndex("Type")));
            habit.setGoal(c.getInt(c.getColumnIndex("Goal")));
            habit.setGoalType(c.getInt(c.getColumnIndex("GoalType")));
            habit.setGoalAmount(c.getInt(c.getColumnIndex("GoalAmount")));
            habit.setStatus(c.getInt(c.getColumnIndex("Status")));
            habit.setRepeatedDaily(c.getInt(c.getColumnIndex("RepeatedDaily")));

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

    public Habit GetById(int Id){
        Cursor c = db.query("Habits", null,"Id = ?", new String[] { String.valueOf(Id) },null, null, null);
        if(c != null)
            c.moveToFirst();
        Habit habit = new Habit();

        habit.setId(c.getInt(0));
        habit.setName(c.getString(1));
        habit.setStartDate(DateUltilities.StringToDate("dd/MM/yyyy" ,c.getString(2)));
        if(c.getString(3) != null){
            habit.setEndDate(DateUltilities.StringToDate("dd/MM/yyyy" ,c.getString(3)));
        }
        habit.setType(c.getInt(4));
        habit.setGoal(c.getInt(5));
        habit.setGoalType(c.getInt(6));
        habit.setGoalAmount(c.getInt(7));
        habit.setStatus(c.getInt(8));
        habit.setRepeatedDaily(c.getInt(9));

        return habit;
    }

    public List<Habit> GetAll(){
        String sql = "SELECT * FROM Habits";
        return GetData(sql);
    }
    public List<Habit> GetAllOneTimeTask(){
        String sql = "SELECT * FROM Habits WHERE Type = 0";
        return GetData(sql);
    }

    public List<Habit> GetOneTimeTaskByDate(Date date){
        List<Habit> list = GetAllOneTimeTask();

        Iterator<Habit> iterator = list.iterator();
        while (iterator.hasNext()){
            if(!habitRecordDao.IsHabitHaveRecord(iterator.next().getId(), date)){
                iterator.remove();
            }
        }

        return list;
    }

    public List<Habit> GetDoneOneTimeTask(){
        String sql = "SELECT * FROM Habits WHERE Type = 0 ";

        List<Habit> oneTimeTasks = GetData(sql);
        List<Habit> result = new ArrayList<>();
        for (Habit h : oneTimeTasks) {
            if(!habitRecordDao.IsOneTimeTaskOverdue(h.getId())){
                result.add(h);
            }
        }

        return result;
    }

    public List<Habit> GetOverdueOneTimeTask(){
        String sql = "SELECT * FROM Habits WHERE Type = 0 ";

        List<Habit> oneTimeTasks = GetData(sql);
        List<Habit> result = new ArrayList<>();
        for (Habit h : oneTimeTasks) {
            if(habitRecordDao.IsOneTimeTaskOverdue(h.getId())){
                result.add(h);
            }
        }

        return result;
    }
}
