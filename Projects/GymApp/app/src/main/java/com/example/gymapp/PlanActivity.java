package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {

    private static final String TAG = "PlanActivity";

    private RecyclerView mondayRecView, tuesdayRecView, wednesdayRecView, thursdayRecView, fridayRecView, saturdayRecView, sundayRecView;
    private Button btnAddPlan;
    private NestedScrollView nestedScrollView;
    private Button mondayEdit, tuesdayEdit, wednesdayEdit, thursdayEdit, fridayEdit, saturdayEdit, sundayEdit;
    private RelativeLayout notAddedRelLayout;

    private PlanRecViewAdapter mondayAdapter, tuesdayAdapter, wednesdayAdapter, thursdayAdapter, fridayAdapter, saturdayAdapter, sundayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        init();
        initAdapters();
        initRecViews();

        if(Util.getUserPlans().size()>0)
        {
            notAddedRelLayout.setVisibility(View.GONE);
            nestedScrollView.setVisibility(View.VISIBLE);
        }
        else {
            notAddedRelLayout.setVisibility(View.VISIBLE);
            nestedScrollView.setVisibility(View.GONE);
        }

        setOnClickListeners();

    }

    public void setOnClickListeners()
    {
        Log.d(TAG, "setOnClickListeners: called");

        mondayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Monday");
                startActivity(intent);
            }
        });

        tuesdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Tuesday");
                startActivity(intent);
            }
        });

        wednesdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Wednesday");
                startActivity(intent);
            }
        });

        thursdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Thursday");
                startActivity(intent);
            }
        });

        fridayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Friday");
                startActivity(intent);
            }
        });

        saturdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Saturday");
                startActivity(intent);
            }
        });

        sundayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Sunday");
                startActivity(intent);
            }
        });

        btnAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, AllTraining.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


    }

    public void init()
    {
        Log.d(TAG, "init: started");

        mondayRecView = (RecyclerView) findViewById(R.id.mondayRecView);
        tuesdayRecView = (RecyclerView) findViewById(R.id.tuesdayRecView);
        wednesdayRecView = (RecyclerView) findViewById(R.id.wednesdayRecView);
        thursdayRecView = (RecyclerView) findViewById(R.id.thursdayRecView);
        fridayRecView = (RecyclerView) findViewById(R.id.fridayRecView);
        saturdayRecView = (RecyclerView) findViewById(R.id.saturdayRecView);
        sundayRecView = (RecyclerView) findViewById(R.id.sundayRecView);

        btnAddPlan = (Button) findViewById(R.id.btnAddAPlan);

        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        mondayEdit = (Button) findViewById(R.id.btnMondayEdit);
        tuesdayEdit = (Button) findViewById(R.id.btnTuesdayEdit);
        wednesdayEdit = (Button) findViewById(R.id.btnWednesEdit);
        thursdayEdit = (Button) findViewById(R.id.btnThursdayEdit);
        fridayEdit = (Button) findViewById(R.id.btnFridayEdit);
        saturdayEdit = (Button) findViewById(R.id.btnSaturdayEdit);
        sundayEdit = (Button) findViewById(R.id.btnSundayEdit);

        notAddedRelLayout = (RelativeLayout) findViewById(R.id.notAdded);

    }


    public void initAdapters()
    {
        Log.d(TAG, "initAdapters: called");
        mondayAdapter = new PlanRecViewAdapter(this);
        tuesdayAdapter = new PlanRecViewAdapter(this);
        wednesdayAdapter = new PlanRecViewAdapter(this);
        thursdayAdapter = new PlanRecViewAdapter(this);
        fridayAdapter = new PlanRecViewAdapter(this);
        saturdayAdapter = new PlanRecViewAdapter(this);
        sundayAdapter = new PlanRecViewAdapter(this);


    }

    public void initRecViews()
    {
        Log.d(TAG, "initRecViews: called");

        mondayRecView.setAdapter(mondayAdapter);
        mondayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        ArrayList<Plan> mondayPlans = new ArrayList<>();
        for(Plan plan: Util.getUserPlans())
        {
            if(plan.getDay().equals("Monday"))
                mondayPlans.add(plan);
        }
        mondayAdapter.setPlans(mondayPlans);

        tuesdayRecView.setAdapter(tuesdayAdapter);
        tuesdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        ArrayList<Plan> tuesdayPlans = new ArrayList<>();
        for(Plan plan: Util.getUserPlans())
        {
            if(plan.getDay().equals("Tuesday"))
                tuesdayPlans.add(plan);
        }
        tuesdayAdapter.setPlans(tuesdayPlans);

        wednesdayRecView.setAdapter(wednesdayAdapter);
        wednesdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        ArrayList<Plan> wednesdayPlans = new ArrayList<>();
        for(Plan plan: Util.getUserPlans())
        {
            if(plan.getDay().equals("Wednesday"))
                wednesdayPlans.add(plan);
        }
        wednesdayAdapter.setPlans(wednesdayPlans);

        thursdayRecView.setAdapter(thursdayAdapter);
        thursdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        ArrayList<Plan> thursdayPlans = new ArrayList<>();
        for(Plan plan: Util.getUserPlans())
        {
            if(plan.getDay().equals("Thursday"))
                thursdayPlans.add(plan);
        }
        thursdayAdapter.setPlans(thursdayPlans);

        fridayRecView.setAdapter(fridayAdapter);
        fridayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        ArrayList<Plan> fridayPlans = new ArrayList<>();
        for(Plan plan: Util.getUserPlans())
        {
            if(plan.getDay().equals("Friday"))
                fridayPlans.add(plan);
        }
        fridayAdapter.setPlans(fridayPlans);

        saturdayRecView.setAdapter(saturdayAdapter);
        saturdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        ArrayList<Plan> saturdayPlans = new ArrayList<>();
        for(Plan plan: Util.getUserPlans())
        {
            if(plan.getDay().equals("Saturday"))
                saturdayPlans.add(plan);
        }
        saturdayAdapter.setPlans(saturdayPlans);

        sundayRecView.setAdapter(sundayAdapter);
        sundayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        ArrayList<Plan> sundayPlans = new ArrayList<>();
        for(Plan plan: Util.getUserPlans())
        {
            if(plan.getDay().equals("Sunday"))
                sundayPlans.add(plan);
        }
        sundayAdapter.setPlans(sundayPlans);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}