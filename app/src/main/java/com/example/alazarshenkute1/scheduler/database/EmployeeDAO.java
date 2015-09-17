//
// Alazar Shenkute
// 8/31/15



package com.example.alazarshenkute1.scheduler.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.alazarshenkute1.scheduler.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO extends EmployeeDBDAO {

    private static final String WHERE_ID_EQUALS = DatabaseHelper.COLUMN_EMPLOYEE_ID + " =?";



    public EmployeeDAO( Context context ) throws SQLException
    {
        super(context);
    }

    public long insert( Employee e )
    {
        ContentValues values = new ContentValues();
        values.put( DatabaseHelper.COLUMN_EMPLOYEE_FIRST_NAME, e.getFirstName() );
        values.put( DatabaseHelper.COLUMN_EMPLOYEE_LAST_NAME, e.getLastName() );
        values.put( DatabaseHelper.COLUMN_EMPLOYEE_EMAIL, e.getEmail() );
        values.put(DatabaseHelper.COLUMN_EMPLOYEE_PASSWORD, e.getPassword());

        return database.insert( DatabaseHelper.TABLE_EMPLOYEES, null, values );

    }

    public long update( Employee e )
    {
        ContentValues values = new ContentValues();
        values.put( DatabaseHelper.COLUMN_EMPLOYEE_FIRST_NAME, e.getFirstName() );
        values.put( DatabaseHelper.COLUMN_EMPLOYEE_LAST_NAME, e.getLastName() );
        values.put( DatabaseHelper.COLUMN_EMPLOYEE_EMAIL, e.getEmail() );
        values.put(DatabaseHelper.COLUMN_EMPLOYEE_PASSWORD, e.getPassword());

        long result = database.update( DatabaseHelper.TABLE_EMPLOYEES, values,
                WHERE_ID_EQUALS, new String[]{ String.valueOf( e.getId() ) } );
        Log.d("Update Result:", "=" + result);
        return result;
    }

    public int deleteEmployee(Employee e ) {
        return database.delete(DatabaseHelper.TABLE_EMPLOYEES, WHERE_ID_EQUALS,
                new String[]{e.getId() + ""});
    }

    public Cursor getAllUsers()
    {
        return database.query(DatabaseHelper.TABLE_EMPLOYEES, new String[]
                        {DatabaseHelper.COLUMN_EMPLOYEE_FIRST_NAME,
                                DatabaseHelper.COLUMN_EMPLOYEE_LAST_NAME,
                                DatabaseHelper.COLUMN_EMPLOYEE_EMAIL,
                                DatabaseHelper.COLUMN_EMPLOYEE_PASSWORD,
                                DatabaseHelper.COLUMN_EMPLOYEE_ID,
                                DatabaseHelper.COLUMN_EMPLOYEE_SUPERVISOR },
                null, null, null, null, null);
    }


    public ArrayList<Employee> getEmployees(){
        ArrayList<Employee> listOfEmployees = new ArrayList<>();
        Cursor cursor = getAllUsers();
        Employee employee = new Employee();
        if( cursor.moveToFirst() )
        {
         //   long id = (long)cursor.getString(0);
           // employee.setId(  );
            employee.setFirstName( cursor.getString(1) );
            employee.setLastName( cursor.getString(2) );
            employee.setEmail( cursor.getString(3) );
            employee.setPassword( cursor.getString(4) );
           // employee.setIsSupervisor( cursor.getString(5) );

        }




        return listOfEmployees;
    }



    /** DELETE MEEE */
    // check if records are saved in the database
  /*  private void displayUse(Cursor cursor) {
        Toast.makeText(this, "" + cursor.getString(0) + "\n"
                + cursor.getString(1) + "\n"
                + cursor.getString(2) + "\n"
                , Toast.LENGTH_LONG).show();
    }
    */


}
