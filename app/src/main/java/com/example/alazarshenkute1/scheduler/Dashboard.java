package com.example.alazarshenkute1.scheduler;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dashboard extends Activity {


    String [] workScheduleArray = {
            "Today - Sunny - 88/63",
            "Tomorrow - Sunny - 88/63",
            "Weds - Sunny - 88/63",
            "Thurs - Sunny - 88/63",
            "Fri - Sunny - 88/63",
            "Sat - Sunny - 88/63",
            "Sun - Sunny - 88/63" };

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        TextView listView = (TextView) findViewById( R.id.textView );
        List<String> list = new ArrayList<String>( Arrays.asList( workScheduleArray ) );
        // intilaize adapter
        ArrayAdapter<String> scheduleAdapter =
                new ArrayAdapter<String>( this, R.layout.dashboard, R.id.textView, list );


    }

}
