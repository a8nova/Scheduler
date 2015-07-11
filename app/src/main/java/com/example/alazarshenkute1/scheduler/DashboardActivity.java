package com.example.alazarshenkute1.scheduler;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DashboardActivity extends ListActivity {


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
        setContentView( R.layout.dashboard );

        ListView list = getListView();
        setListAdapter( new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, workScheduleArray ) );
    }

}
