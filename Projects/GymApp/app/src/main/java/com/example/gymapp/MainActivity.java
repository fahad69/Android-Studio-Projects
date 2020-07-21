package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button btnSeePlan, btnAllActivities, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Util.initAll();

        init();

        setOnClickListeners();


    }

    private void setOnClickListeners()
    {
        Log.d(TAG, "setOnClickListeners: started");
        btnAllActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllTraining.class);
                startActivity(intent);
            }
        });


        btnSeePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlanActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAbout dialogAbout = new DialogAbout();
                dialogAbout.show(getSupportFragmentManager(), "about dialog");
            }
        });
    }


    private void init()
    {
        Log.d(TAG, "init: Started");
        btnSeePlan = (Button) findViewById(R.id.btnSeeYourPlan);
        btnAllActivities = (Button) findViewById(R.id.btnSeeAll);
        btnAbout = (Button) findViewById(R.id.btnAbout);



    }
}