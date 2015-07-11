//
// Alazar Shenkute
// 6/19/2015
// These class is responsible for loging in the user
package com.example.alazarshenkute1.scheduler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

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
        SharedPreferences sharedPref = LogInActivity.this.getPreferences( Context.MODE_PRIVATE);
        email = sharedPref.getString( EMAIL_KEY  , DEFAULT_VALUE );
        password = sharedPref.getString( PASSWORD_KEY, DEFAULT_VALUE );
        Validate validator = new Validate();
        if( validator.validateLogin( email, password ) == USER_FOUND )
        {

        }

        startActivity(new Intent( this, DashboardActivity.class ) );
    }
}
