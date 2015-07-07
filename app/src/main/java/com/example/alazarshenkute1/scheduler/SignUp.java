//
// Alazar Shenkute
// 6/19/2015
// These class is responsible for signing up the user
// also saves the user email and password
/*
    key = email, since it has be unique
    value = name, password, and picture of user
 */
package com.example.alazarshenkute1.scheduler;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity {

    // Keys for storing user data
    private static final String EMAIL_KEY = "email";
    private static final String NAME_KEY = "name";
    private static final String PASSWORD_KEY = "passWord";

    // name of XML file in which all the data will be saved
    private SharedPreferences preferences = null;

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
       // sginup is the view instantiated by this activity
        setContentView(R.layout.signup);
    }

    // MUST pass a View argument or it doesn't work
    // I don't know why
    public void submitButtonPressed( View view ){
        // validate data
        // save data
         EditText[] editText =
                {
                        (EditText)findViewById( R.id.email ),
                        (EditText)findViewById( R.id.name ),
                        (EditText)findViewById( R.id.passwd )
                };
        // dont have to worry about the file name
        // can access it from any class by calling getDefault
        preferences = PreferenceManager.getDefaultSharedPreferences( this );
        SharedPreferences.Editor editor = preferences.edit(); // allows me to save key/value pairs
        editor.putString( EMAIL_KEY, editText[0].getText().toString() );
        editor.putString( NAME_KEY, editText[1].getText().toString() );
        editor.putString(PASSWORD_KEY, editText[2].getText().toString());
        editor.apply();

        //---display file saved message---
        Toast.makeText(getBaseContext(),
                "saved!",
                Toast.LENGTH_SHORT).show();
    }

}
