//
// Alazar Shenkute
// 6/19/2015
// These class is responsible for loging in the user
package com.example.alazarshenkute1.scheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogIn extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // LogIn is the view instantiated by this activiy
        setContentView(R.layout.login);

    }


    public void submitButtonPressed(View view) {

        startActivity(new Intent( this, Dashboard.class ) );
    }
}
