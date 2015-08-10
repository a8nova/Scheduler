//
// Alazar Shenkute
// 6/19/2015
// entry point of application
/* An app that can be used by an Employer and an Employee to set
    work schedule and availability, weekly
  */
//

package com.example.alazarshenkute1.scheduler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main );
    }

    // invoke the log in activity if log in button pressed
    public void logInButtonPressed( View view ) {
        Intent i = new Intent(this, LogInActivity.class);
        startActivity( i );
    }

    // invoke sign up activity if sign up button pressed
    public void signUpButtonPressed( View view ) {
        startActivity( new Intent( this, SignupActivity.class ));
    }
    //
   // @Override
    public void OnBackPressed()
    {
        onShowQuitDialog();
    }
    public void onShowQuitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);

        builder.setMessage("Do You Want To Quit?");
        builder.setPositiveButton(android.R.string.yes,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        builder.setNegativeButton(android.R.string.no,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.create().show();
    }
}
