package com.example.habittrackerapp.database.DatabaseHelper;

import android.database.sqlite.SQLiteDatabase;

public class DataDB {
    private final static String INSERT_DAILY_HABITS =
            "INSERT INTO Habits(Name, StartDate, Type, GoalType, Goal, Status, RepeatedDaily)" +
            "VALUES('Drink  water', '01/05/2024', 1, 1, 5, 1, 123)," +
                    "('Skincare', '01/05/2024', 1, 1, 1, 1, 13)," +
                    "('Do exercises', '08/05/2024', 1, 2, 30, 1, 2);";
    private final static String INSERT_DAILY_HABITS1 =
            "INSERT INTO DailyHabits(HabitId, Days)" +
            "VALUES(1, '2,3,4,5,6,7,8')," +
                    "(2, '2,3,4,5,6,7,8')," +
                    "(3, '2,5,7,8');";
    private final static String INSERT_WEEKLY_HABITS =
            "INSERT INTO Habits(Name, StartDate, Type, GoalType, Goal, Status, RepeatedDaily)" +
            "VALUES('Call grandmother', '01/05/2024', 2, 1, 1, 1, 3)," +
                    "('Read books', '25/04/2024', 2, 1, 1, 1, 0);";
    private final static String INSERT_WEEKLY_HABITS1 =
            "INSERT INTO WeeklyHabits(HabitId, DaysPerWeek)" +
            "VALUES(4, 3)," +
                    "(5, 5);";
    private final static String INSERT_MONTHLY_HABITS =
            "INSERT INTO Habits(Name, StartDate, Type, GoalType, Goal, Status, RepeatedDaily)" +
            "VALUES('Clean the house', '01/05/2024', 3, 1, 1, 1, 0);";
    private final static String INSERT_MONTHLY_HABITS1 =
            "INSERT INTO MonthlyHabits(HabitId, DaysPerMonth, TimeInMonth)" +
            "VALUES(6, 2, 1);";
    private final static String INSERT_ONE_TIME_TASK =
            "INSERT INTO Habits(Name, StartDate, Type, GoalType, Goal, Status, RepeatedDaily)" +
            "VALUES('Buy gift for mom', '29/04/2024', 0, 1, 1, 1, 0);";

    private final static String INSERT_HABIT_RECORD1 =
            "INSERT INTO HabitRecords(HabitId, Date, Goal, Status, TimeInDay)" +
            "VALUES(1, '01/05/2024', 2, 'Overdue',1)," +
                    "(1, '01/05/2024', 3, 'Overdue',2)," +
                    "(1, '01/05/2024', 3, 'Overdue',3)," +
                    "(1, '02/05/2024', 5, 'Done',1)," +
                    "(1, '02/05/2024', 3, 'Overdue',2)," +
                    "(1, '02/05/2024', 3, 'Overdue',3)," +
                    "(1, '03/05/2024', 0, 'Overdue',1)," +
                    "(1, '03/05/2024', 0, 'Overdue',2)," +
                    "(1, '03/05/2024', 3, 'Overdue',3)," +
                    "(1, '04/05/2024', 1, 'Overdue',1)," +
                    "(1, '04/05/2024', 2, 'Overdue',2)," +
                    "(1, '04/05/2024', 3, 'Overdue',3)," +
                    "(1, '05/05/2024', 4, 'Overdue',1)," +
                    "(1, '05/05/2024', 3, 'Overdue',2)," +
                    "(1, '05/05/2024', 2, 'Overdue',3)," +
                    "(1, '06/05/2024', 4, 'Overdue',1)," +
                    "(1, '06/05/2024', 3, 'Overdue',2)," +
                    "(1, '06/05/2024', 3, 'Overdue',3)," +
                    "(1, '07/05/2024', 5, 'Done',1)," +
                    "(1, '07/05/2024', 3, 'Overdue',2)," +
                    "(1, '07/05/2024', 3, 'Overdue',3)," +
                    "(1, '08/05/2024', 2, 'Overdue',1)," +
                    "(1, '08/05/2024', 3, 'Overdue',2)," +
                    "(1, '08/05/2024', 3, 'Overdue',3)," +
                    "(1, '09/05/2024', 2, 'Overdue',1)," +
                    "(1, '09/05/2024', 2, 'Overdue',2)," +
                    "(1, '09/05/2024', 3, 'Overdue',3)," +
                    "(1, '10/05/2024', 1, 'Overdue',1)," +
                    "(1, '10/05/2024', 1, 'Overdue',2)," +
                    "(1, '10/05/2024', 3, 'Overdue',3)," +
                    "(1, '11/05/2024', 5, 'Done',1)," +
                    "(1, '11/05/2024', 3, 'Overdue',2)," +
                    "(1, '11/05/2024', 3, 'Overdue',3)," +
                    "(1, '12/05/2024', 5, 'Done',1)," +
                    "(1, '12/05/2024', 5, 'Done',2)," +
                    "(1, '12/05/2024', 5, 'Done',3)," +
                    "(1, '13/05/2024', 1, 'Overdue',1)," +
                    "(1, '13/05/2024', 2, 'Overdue',2)," +
                    "(1, '13/05/2024', 4, 'Overdue',3);";
    private final static String INSERT_HABIT_RECORD2 =
            "INSERT INTO HabitRecords(HabitId, Date, Goal, Status, TimeInDay)" +
            "VALUES(2, '01/05/2024', 0, 'Overdue',1)," +
                    "(2, '01/05/2024', 1, 'Done',3)," +
                    "(2, '02/05/2024', 1, 'Done',1)," +
                    "(2, '02/05/2024', 1, 'Done',3)," +
                    "(2, '03/05/2024', 0, 'Overdue',1)," +
                    "(2, '03/05/2024', 1, 'Done',3)," +
                    "(2, '04/05/2024', 1, 'Done',1)," +
                    "(2, '04/05/2024', 1, 'Done',3)," +
                    "(2, '05/05/2024', 0, 'Overdue',1)," +
                    "(2, '05/05/2024', 1, 'Done',3)," +
                    "(2, '06/05/2024', 1, 'Done',1)," +
                    "(2, '06/05/2024', 1, 'Done',3)," +
                    "(2, '07/05/2024', 1, 'Done',1)," +
                    "(2, '07/05/2024', 1, 'Done',3)," +
                    "(2, '08/05/2024', 1, 'Done',1)," +
                    "(2, '08/05/2024', 1, 'Done',3)," +
                    "(2, '09/05/2024', 1, 'Done',1)," +
                    "(2, '09/05/2024', 0, 'Overdue',3)," +
                    "(2, '10/05/2024', 0, 'Overdue',1)," +
                    "(2, '10/05/2024', 1, 'Done',3)," +
                    "(2, '11/05/2024', 1, 'Done',1)," +
                    "(2, '11/05/2024', 1, 'Done',3)," +
                    "(2, '12/05/2024', 1, 'Done',1)," +
                    "(2, '12/05/2024', 1, 'Done',3)," +
                    "(2, '13/05/2024', 1, 'Done',1)," +
                    "(2, '13/05/2024', 0, 'Overdue',3);";
    private final static String INSERT_HABIT_RECORD3 =
            "INSERT INTO HabitRecords(HabitId, Date, Goal, Status, TimeInDay)" +
            "VALUES (3, '09/05/2024', 1, 'Done',2)," +
                    "(3, '11/05/2024', 1, 'Done',2)," +
                    "(3, '12/05/2024', 1, 'Done',2)," +
                    "(3, '13/05/2024', 0, 'Overdue',2);";
    private final static String INSERT_HABIT_RECORD4 =
            "INSERT INTO HabitRecords(HabitId, Date, Goal, Status, TimeInDay)" +
            "VALUES (4, '01/05/2024', 1, 'Done',2)," +
                    "(4, '03/05/2024', 1, 'Done',2)," +
                    "(4, '05/05/2024', 1, 'Done',2)," +
                    "(4, '07/05/2024', 1, 'Done',2)," +
                    "(4, '10/05/2024', 1, 'Done',2)," +
                    "(4, '12/05/2024', 0, 'Overdue',2)," +
                    "(4, '13/05/2024', 1, 'Done',2);";
    private final static String INSERT_HABIT_RECORD5 =
            "INSERT INTO HabitRecords(HabitId, Date, Goal, Status, TimeInDay)" +
            "VALUES (5, '25/04/2024', 1, 'Done',1)," +
                    "(5, '26/04/2024', 1, 'Done',1)," +
                    "(5, '27/04/2024', 1, 'Done',3)," +
                    "(5, '28/04/2024', 0, 'Overdue',0)," +
                    "(5, '01/05/2024', 1, 'Done',3)," +
                    "(5, '02/05/2024', 1, 'Done',3)," +
                    "(5, '03/05/2024', 0, 'Overdue',0)," +
                    "(5, '04/05/2024', 0, 'Overdue',0)," +
                    "(5, '05/05/2024', 0, 'Overdue',0)," +
                    "(5, '06/05/2024', 0, 'Done',3)," +
                    "(5, '09/05/2024', 0, 'Overdue',0)," +
                    "(5, '10/05/2024', 0, 'Overdue',0)," +
                    "(5, '11/05/2024', 0, 'Overdue',0)," +
                    "(5, '12/05/2024', 0, 'Overdue',0)," +
                    "(5, '13/05/2024', 1, 'Done',2);";;
    private final static String INSERT_HABIT_RECORD6 =
            "INSERT INTO HabitRecords(HabitId, Date, Goal, Status, TimeInDay)" +
            "VALUES (6, '05/05/2024', 1, 'Done', 2)," +
                    "(6,'10/05/2024', 0 , 'Overdue', 0)";
    private final static String INSERT_HABIT_RECORD7 =
            "INSERT INTO HabitRecords(HabitId, Date, Goal, Status, TimeInDay)" +
                    "VALUES (7, '29/04/2024', 1, 'Done', 1);";
    public static void InsertData(SQLiteDatabase db){
        db.execSQL(INSERT_DAILY_HABITS);
        db.execSQL(INSERT_DAILY_HABITS1);

        db.execSQL(INSERT_WEEKLY_HABITS);
        db.execSQL(INSERT_WEEKLY_HABITS1);

        db.execSQL(INSERT_MONTHLY_HABITS);
        db.execSQL(INSERT_MONTHLY_HABITS1);

        db.execSQL(INSERT_ONE_TIME_TASK);

        db.execSQL(INSERT_HABIT_RECORD1);
        db.execSQL(INSERT_HABIT_RECORD2);
        db.execSQL(INSERT_HABIT_RECORD3);
        db.execSQL(INSERT_HABIT_RECORD4);
        db.execSQL(INSERT_HABIT_RECORD5);
        db.execSQL(INSERT_HABIT_RECORD6);
        db.execSQL(INSERT_HABIT_RECORD7);
    }
}
