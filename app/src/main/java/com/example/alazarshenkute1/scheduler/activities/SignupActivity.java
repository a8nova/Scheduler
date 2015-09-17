//
// Alazar Shenkute
// 6/19/2015
// These class is responsible for signing up the user
// also saves the user email and password
/*
    key = email, since it has be unique
    value = name, password, and picture of user
 */
package com.example.alazarshenkute1.scheduler.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alazarshenkute1.scheduler.Employee;
import com.example.alazarshenkute1.scheduler.R;
import com.example.alazarshenkute1.scheduler.Validate;
import com.example.alazarshenkute1.scheduler.database.EmployeeDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

public class SignupActivity extends Activity {

    private static final String TAG = "SignupActivity";

    // constants for editText[]
    public static final int FIRST_NAME = 0;
    public static final int LAST_NAME = 1;
    public static final int EMAIL = 2;
    public static final int PASSWORD = 3;

    EmployeeDAO employeeDAO;

    @Override
    public void onCreate( Bundle savedInstanceState ) {

        try {
            employeeDAO = new EmployeeDAO( getApplicationContext() );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
       // sginup is the view instantiated by this activity
        setContentView(R.layout.signup);
        try {
            String destPath = getFilesDir().getPath() + getPackageName() + "/databases/MyDB";
            File f = new File(destPath);
            if (!f.exists()) {
                CopyDB( getBaseContext().getAssets().open("mydb"),
                        new FileOutputStream(destPath));
            }
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

    // MUST pass a View argument or it doesn't work
    // I don't know why
    public void submitButtonPressed( View view ) throws SQLException {
        // validate data
        // save data
        int isChecked = 0;
        // get reference to EditText objects

        EditText []editText = {
                (EditText) findViewById(R.id.firstName),
                (EditText) findViewById( R.id.lastName ),
                (EditText) findViewById( R.id.email ),
                (EditText) findViewById( R.id.passwd ),
        };

        CheckBox checkBox = (CheckBox )findViewById( R.id.checkBox );
        if( checkBox.isChecked() )
            isChecked = 1;

        // validate email and password
        if( Validate.validateSignUp(
                editText[EMAIL].getText().toString(),
                editText[PASSWORD].getText().toString())  ) {

            Employee employee = new Employee();
            employee.setFirstName( editText[FIRST_NAME].getText().toString() );
            employee.setLastName(editText[LAST_NAME].getText().toString());
            employee.setEmail(editText[EMAIL].getText().toString());
            employee.setPassword(editText[PASSWORD].getText().toString());
            employee.setIsSupervisor( isChecked );
            employeeDAO.insert(employee);

            //---display file saved message---
            Toast.makeText(getBaseContext(),
                    "saved!",
                    Toast.LENGTH_SHORT ).show();

           // dbAdapter.close();
        }else{
            Toast.makeText( this,"Invalid Username or Password", Toast.LENGTH_SHORT ).show();
        }
    }

    public void CopyDB(InputStream inputStream, OutputStream outputStream) throws IOException
    {
        //---copy 1K bytes at a time---
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0 ) {
            outputStream.write( buffer, 0, length );
        }
        inputStream.close();
        outputStream.close();
    }

}
