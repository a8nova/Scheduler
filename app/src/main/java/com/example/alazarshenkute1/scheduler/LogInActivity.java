//
// Alazar Shenkute
// 6/19/2015
// These class is responsible for loging in the user
package com.example.alazarshenkute1.scheduler;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends Activity {
    // Keys for retrieving user data
    private static final String EMAIL_KEY = "email";
    private static final String NAME_KEY = "name";
    private static final String PASSWORD_KEY = "passWord";
    // used by SharedPreference, if key not found returns default value
    private static final String DEFAULT_VALUE = "not found";


    private final int USER_FOUND = 1;
    private String email = null;
    private String password = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // LogIn is the view instantiated by this activiy
        setContentView(R.layout.login);

    }


    public void submitButtonPressed(View view ) {

        // check if both username and password match
        // get the data entered if any
        EditText login = (EditText) findViewById( R.id.logInEmail );
        EditText password = (EditText) findViewById( R.id.logInPassword );
        DBAdapter dbAdapter = new DBAdapter( this );
        dbAdapter.open();
        Cursor cursor = dbAdapter.getAllUsers();
        if( cursor.moveToFirst() ){
            displayUser( cursor );
            while( cursor.moveToNext() ){
                displayUser( cursor );
            }
        }
        dbAdapter.close();
        cursor.close();


      //  startActivity(new Intent( this, DashboardActivity.class ) );
    }

    /** DELETE MEEE */
    // check if records are saved in the database
    private void displayUser(Cursor cursor) {
            Toast.makeText(this, "" + cursor.getString(0) + "\n"
                                    + cursor.getString(1) + "\n"
                                    + cursor.getString(2) + "\n"
                                    ,Toast.LENGTH_LONG).show();
    }
}
