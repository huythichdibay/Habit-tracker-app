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
import java.util.List;

public class HabitRecordDao {
    private SQLiteDatabase db;

    public HabitRecordDao (Context context) {
        DatabaseHandler dbHandler = new DatabaseHandler (context);
        db = dbHandler.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<HabitRecord> GetData(String sql, String...selectionArgs) {
        List<HabitRecord> list = new ArrayList<HabitRecord>();
        Cursor c = db.rawQuery (sql, selectionArgs);
        while (c.moveToNext()) {
            HabitRecord record = new HabitRecord();

            record.setId(c.getInt(c.getColumnIndex("Id")));
            record.setHabitId(c.getInt(c.getColumnIndex("HabitId")));
            record.setDate(DateUltilities.StringToDate("dd/MM/yyyy", c.getString(c.getColumnIndex("Date"))));
            record.setGoal(c.getInt(c.getColumnIndex("Goal")));
            record.setStatus(c.getString(c.getColumnIndex("Status")));
            record.setTimeInDay(c.getInt(c.getColumnIndex("TimeInDay")));

            list.add(record);
        }

        return list;
    }

    public List<HabitRecord> GetByHabitId(int Id){
        return GetData("SELECT * FROM HabitRecords WHERE HabitId = ?", new String[]{Id+""});
    }

    public boolean IsHabitHaveRecord(int habitId, Date date){
        List<HabitRecord> records = GetByHabitId(habitId);

        for (HabitRecord hc: records) {
            if(hc.getDate() == date){
                return true;
            }
        }
        return false;
    }
}
