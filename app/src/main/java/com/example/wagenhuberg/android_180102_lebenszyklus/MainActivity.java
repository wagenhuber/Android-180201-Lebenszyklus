package com.example.wagenhuberg.android_180102_lebenszyklus;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView listView;
    private ArrayAdapter<String> adapter;


    public void log(String text) {
        Log.i(TAG, text);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log("onCreate_MeineOnCreateMessage");

        listView = findViewById(R.id.listView);
        final ArrayList<String> personen = new ArrayList<>(Arrays.asList("Andreas", "Hans", "Paul", "Tanja"));
        personen.add("Michael");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, personen);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i(TAG, personen.get(i));
                Toast.makeText(MainActivity.this, "Hallo " + personen.get(i), Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    protected void onStart() {
        super.onStart();
        log("onStart_MeineOnStartMessage");
    }


    @Override
    protected void onResume() {
        super.onResume();
        log("onResume_MeineOnResumeMessage");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        log("onRestart_MeineOnRestartMesssage");
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("onPause_MeineOnPauseMessage");
    }


    //Aufruf beim Drücken auf HomeButton
    @Override
    protected void onStop() {
        super.onStop();
        log("onStop_MeineOnStopLogMessage");
    }

    //Aufruf beim Beenden der App via Taskmanager
    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy_MeineOnDestroyMessage");
    }
}
