package com.example.habittrackerapp.database.DatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "HabitTrackerDB";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String CREATE_HABIT_TABLE =
            "CREATE TABLE Habits(" +
                    "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Name TEXT NOT NULL," +
                    "StartDate TEXT NOT NULL," +
                    "EndDate TEXT," +
                    "Type INTEGER NOT NULL," +
                    "Goal INTEGER NOT NULL," +
                    "GoalType INTEGER NOT NULL," +
                    "GoalAmount INTEGER," +
                    "Status INTEGER NOT NULL," +
                    "RepeatedDaily INTEGER NOT NULL);";
    private static final String CREATE_DAILY_HABIT_TABLE =
            "CREATE TABLE DailyHabits(" +
                    "HabitId INTEGER REFERENCES Habits (Id)," +
                    "Days TEXT NOT NULL);";
    private static final String CREATE_WEEKLY_HABIT_TABLE =
            "CREATE TABLE WeeklyHabits(" +
                    "HabitId INTEGER REFERENCES Habits (Id)," +
                    "DaysPerWeek INTEGER NOT NULL);";
    private static final String CREATE_MONTHLY_HABIT_TABLE =
            "CREATE TABLE MonthlyHabits(" +
                    "HabitId INTEGER REFERENCES Habits (Id)," +
                    "DaysPerMonth INTEGER NOT NULL," +
                    "TimeInMonth INTEGER NOT NULL);";
    private static final String CREATE_HABIT_RECORD_TABLE =
            "CREATE TABLE HabitRecords(" +
                    "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "HabitId INTEGER REFERENCES Habits (Id)," +
                    "Date TEXT NOT NULL," +
                    "Goal INTEGER NOT NULL, " +
                    "Status INTEGER NOT NULL);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_HABIT_TABLE);
        db.execSQL(CREATE_DAILY_HABIT_TABLE);
        db.execSQL(CREATE_WEEKLY_HABIT_TABLE);
        db.execSQL(CREATE_MONTHLY_HABIT_TABLE);
        db.execSQL(CREATE_HABIT_RECORD_TABLE);
        DataDB.InsertData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Habits");
        db.execSQL("DROP TABLE IF EXISTS DailyHabits");
        db.execSQL("DROP TABLE IF EXISTS WeeklyHabits");
        db.execSQL("DROP TABLE IF EXISTS MonthlyHabits");
        db.execSQL("DROP TABLE IF EXISTS HabitRecords");

        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }
}
