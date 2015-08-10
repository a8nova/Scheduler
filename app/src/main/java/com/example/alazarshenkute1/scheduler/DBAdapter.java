//
// Alazar Shenkute
// 6/19/2015
//
package com.example.alazarshenkute1.scheduler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.SQLException;
import android.util.Log;

public class DBAdapter {

    private static final String TAG = "DBAdapter";

    // columns of employees table
    private static final String TABLE_EMPLOYEES = "employees";
    private static final String COLUMN_EMPLOYEE_ID = "_id_employee";
    private static final String COLUMN_EMPLOYEE_NAME = "name";
    private static final String COLUMN_EMPLOYEE_EMAIL = "email";
    private static final String COLUMN_EMPLOYEE_PASSWORD = "password";
    private static final String COLUMN_EMPLOYEE_SUPERVISOR = "is_supervisor";

   // columns of schedule employees
    private static final String TABLE_SCHEDULE = "schedules";
    private static final String COLUMN_SCHEDULE_ID = COLUMN_EMPLOYEE_ID;
    private static final String COLUMN_SCHEDULE_DAY = "day";
    private static final String COLUMN_SCHEDULE_START_SHIFT= "start_shift_time";
    private static final String COLUMN_SCHEUDLE_END_SHIFT = "end_shift_time";
    private static final String COLUMN_SCHEUDLE_DATE = "date";


    private static final String DATABASE_NAME = "MyDB";

    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_EMPLOYEES =
                    "create table employees "
                    + "(_id_employee integer primary key autoincrement, "
                    + "name text not null, email text not null, "
                    + "password text not null, is_supervisor text not null);";

    private static final String SQL_CREATE_TABLE_SCHEDULE =
                    "create table schedules "
                    + "(_id_schedule primary key autoincrement, "
                    + "day text not null, start_shift_time text not null, "
                    + "end_shift_time text not null, date text not null );";

    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter( Context ctx )
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {

        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                db.execSQL(SQL_CREATE_TABLE_EMPLOYEES);
                db.execSQL(SQL_CREATE_TABLE_SCHEDULE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS employees");
            db.execSQL("DROP TABLE IF EXISTS schedules");
            onCreate(db);
        }
    }

    //---opens the database---
    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }

    //---insert a contact into the database---
    public long insertUser(String name, String email, String password, String value )
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(COLUMN_EMPLOYEE_NAME, name);
        initialValues.put(COLUMN_EMPLOYEE_EMAIL, email);
        initialValues.put(COLUMN_EMPLOYEE_PASSWORD, password );
        initialValues.put(COLUMN_EMPLOYEE_SUPERVISOR, value);
        return db.insert( TABLE_EMPLOYEES, null, initialValues);
    }
    //--- insert a schedule into the database
    public long insertSchedule( String day, String start_shift, String end_shift, String date )
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(COLUMN_SCHEDULE_DAY, day );
        initialValues.put(COLUMN_SCHEDULE_START_SHIFT, start_shift);
        initialValues.put(COLUMN_SCHEUDLE_END_SHIFT, end_shift );
        initialValues.put(COLUMN_SCHEUDLE_DATE, date );
        return db.insert(TABLE_SCHEDULE, null, initialValues );

    }
    //--- delete a schedule from database
    public boolean deleteSchedule( long rowId )
    {
        return db.delete( TABLE_SCHEDULE, COLUMN_SCHEDULE_ID + "=" + rowId, null ) > 0;
    }
    //---deletes a particular user---
    public boolean deleteUser(long rowId)
    {
        return db.delete(TABLE_EMPLOYEES, COLUMN_EMPLOYEE_ID + "=" + rowId, null) > 0;
    }

    //---retrieves all the contacts---
    public Cursor getAllUsers()
    {
        return db.query(TABLE_EMPLOYEES, new String[] {COLUMN_EMPLOYEE_ID, COLUMN_EMPLOYEE_NAME,
                COLUMN_EMPLOYEE_EMAIL}, null, null, null, null, null);
    }

    //---retrieves a particular contact---
    public Cursor getUser(long rowId) throws SQLException
    {
        Cursor mCursor =
                db.query(true, TABLE_EMPLOYEES, new String[] {COLUMN_EMPLOYEE_ID,
                                COLUMN_EMPLOYEE_NAME, COLUMN_EMPLOYEE_EMAIL}, COLUMN_EMPLOYEE_ID + "=" + rowId, null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---updates a contact---
    public boolean updateUsers(long rowId, String name, String email, String password, String value )
    {
        ContentValues args = new ContentValues();
        args.put(COLUMN_EMPLOYEE_NAME, name);
        args.put(COLUMN_EMPLOYEE_EMAIL, email);
        args.put(COLUMN_EMPLOYEE_PASSWORD, password );
        args.put( COLUMN_EMPLOYEE_SUPERVISOR, value );
        return db.update(TABLE_EMPLOYEES, args, COLUMN_EMPLOYEE_ID + "=" + rowId, null) > 0;
    }
}