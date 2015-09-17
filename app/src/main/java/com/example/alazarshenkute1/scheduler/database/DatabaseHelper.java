package com.example.alazarshenkute1.scheduler.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    // columns of employees table
    protected static final String TABLE_EMPLOYEES = "employees";
    protected static final String COLUMN_EMPLOYEE_ID = "_id_employee";
    protected static final String COLUMN_EMPLOYEE_FIRST_NAME = "first_name";
    protected static final String COLUMN_EMPLOYEE_LAST_NAME = "last_name";
    protected static final String COLUMN_EMPLOYEE_EMAIL = "email";
    protected static final String COLUMN_EMPLOYEE_PASSWORD = "password";
    protected static final String COLUMN_EMPLOYEE_SUPERVISOR = "is_supervisor";

    // columns of employees schedule
    protected static final String TABLE_SCHEDULE = "schedules";
    protected static final String COLUMN_SCHEDULE_ID = COLUMN_EMPLOYEE_ID;
    protected static final String COLUMN_SCHEDULE_DAY = "day";
    protected static final String COLUMN_SCHEDULE_START_SHIFT= "start_shift_time";
    protected static final String COLUMN_SCHEUDLE_END_SHIFT = "end_shift_time";
    protected static final String COLUMN_SCHEUDLE_DATE = "date";


    private static final String DATABASE_NAME = "MyDB";

    private static final int DATABASE_VERSION = 1;



    private static final String SQL_CREATE_TABLE_EMPLOYEES =
                    "create table " + TABLE_EMPLOYEES
                    + " (" +  COLUMN_EMPLOYEE_ID + " integer primary key autoincrement,"
                    + COLUMN_EMPLOYEE_FIRST_NAME + " text not null," + COLUMN_EMPLOYEE_LAST_NAME + " text not null,"+
                            COLUMN_EMPLOYEE_EMAIL + " text not null,"
                    +  COLUMN_EMPLOYEE_PASSWORD + " text not null," + COLUMN_EMPLOYEE_SUPERVISOR + " integer)";

    private static final String SQL_CREATE_TABLE_SCHEDULE =
            "create table " + TABLE_SCHEDULE
                    + " (" + COLUMN_SCHEDULE_ID + " primary key autoincrement,"
                    + COLUMN_SCHEDULE_DAY + " text not null," + COLUMN_SCHEDULE_START_SHIFT + " text not null,"
                    +  COLUMN_SCHEUDLE_END_SHIFT + " text not null,"
                    + COLUMN_SCHEUDLE_DATE + " text not null)";


    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getHelper(Context context) {
        if( instance == null )
            instance = new DatabaseHelper(context);
        return instance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen( SQLiteDatabase db ) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_EMPLOYEES);
        db.execSQL(SQL_CREATE_TABLE_SCHEDULE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
