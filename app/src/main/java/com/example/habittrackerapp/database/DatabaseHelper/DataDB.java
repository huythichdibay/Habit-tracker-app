package com.example.habittrackerapp.database.DatabaseHelper;

import android.database.sqlite.SQLiteDatabase;

public class DataDB {
    private final static String INSERT_DAILY_HABITS = "";
    private final static String INSERT_WEEKLY_HABITS = "";
    private final static String INSERT_MONTHLY_HABITS = "";
    private final static String INSERT_ONE_TIME_TASK = "";
    private final static String INSERT_HABIT_RECORD = "";

    public static void InsertData(SQLiteDatabase db){
        db.execSQL(INSERT_DAILY_HABITS);
        db.execSQL(INSERT_WEEKLY_HABITS);
        db.execSQL(INSERT_MONTHLY_HABITS);
        db.execSQL(INSERT_ONE_TIME_TASK);
        db.execSQL(INSERT_HABIT_RECORD);
    }
}
