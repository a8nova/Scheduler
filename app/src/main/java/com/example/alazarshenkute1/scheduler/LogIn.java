package com.example.alazarshenkute1.scheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LogIn extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // LogIn is the view instantiated by this activiy
        setContentView( R.layout.login );
    }

    // when user press go
    // we
    public void goButtonPressed(){
        //
        Intent intent;
        intent = new Intent(this, MainActivity.class );
        startActivity( intent );
    }

}
