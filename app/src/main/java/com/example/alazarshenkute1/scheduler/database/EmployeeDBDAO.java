//
// Alazar Shenkute
// 8/25/15
//
// this class opens and closes database
// will be inherited by any class that needs to do any database operation( inssertion, deletion.. )
package com.example.alazarshenkute1.scheduler.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

public class EmployeeDBDAO {
    protected SQLiteDatabase database;
    private DatabaseHelper mdbHelper;
    private Context mContext;

    public EmployeeDBDAO( Context mContext ) throws SQLException
    {
        this.mContext = mContext;
        mdbHelper = DatabaseHelper.getHelper( mContext );
        open();
    }

    public void open() throws SQLException {
        if( mdbHelper == null )
            mdbHelper = DatabaseHelper.getHelper( mContext );
        database = mdbHelper.getWritableDatabase();
    }

    public void close() throws SQLException{
        mdbHelper.close();
        database =null;
    }

}
