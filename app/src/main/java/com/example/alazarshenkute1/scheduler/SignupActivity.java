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
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SignupActivity extends Activity {

    private static final String TAG = "SignupActivity";

    DBAdapter dbAdapter = new DBAdapter( this );

    @Override
    public void onCreate( Bundle savedInstanceState ) {

        super.onCreate(savedInstanceState);
        System.out.println(getFilesDir().toString());
       // sginup is the view instantiated by this activity
        setContentView(R.layout.signup);
        try {
            String destPath = getFilesDir().getPath() + getPackageName() + "/databases/MyDB";
            File f = new File(destPath);
            if (!f.exists()) {
                CopyDB( getBaseContext().getAssets().open("mydb"),
                        new FileOutputStream(destPath));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // MUST pass a View argument or it doesn't work
    // I don't know why
    public void submitButtonPressed( View view ){
        // validate data
        // save data
        Boolean isChecked = false;
        // get reference to EditText objects
        EditText []editText = {
                (EditText) findViewById( R.id.name ),
                (EditText) findViewById( R.id.email ),
                (EditText) findViewById( R.id.passwd ),

        };

        CheckBox checkBox = (CheckBox )findViewById( R.id.checkBox );
        if( checkBox.isChecked() )
            isChecked = true;
        dbAdapter.open();

        long id = dbAdapter.insertUser( editText[0].getText().toString(),
                                           editText[1].getText().toString(),
                                           editText[2].getText().toString(),
                                           isChecked );
        dbAdapter.close();
        Log.e( TAG, String.valueOf(editText[0].getText()));
        //---display file saved message---
        Toast.makeText(getBaseContext(),
                "saved!",
                Toast.LENGTH_SHORT).show();
    }

    public void CopyDB(InputStream inputStream, OutputStream outputStream) throws IOException
    {
        //---copy 1K bytes at a time---
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write( buffer, 0, length );
        }
        inputStream.close();
        outputStream.close();
    }

}
