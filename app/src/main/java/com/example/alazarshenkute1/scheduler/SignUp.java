package com.example.alazarshenkute1.scheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // sgin up is the view instantiated by this activity
        setContentView( R.layout.signup );
    }

    // MUST pass a View argument or it doesnt work
    // I dont know why
    public void goButtonPressed( View view ){
        // blowing up NEED TO BE FIXED
        startActivity( new Intent(this, UploadPicture.class ) );
    }

}
