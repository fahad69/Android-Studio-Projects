package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements PlanRecViewAdapter.DeletePlan {
    private static final String TAG = "EditActivity";

    @Override
    public void OnDeletePlan(String day) {
        Log.d(TAG, "OnDeletePlan: called");

        txtday.setText(day);

        ArrayList<Plan> plans = new ArrayList<>();

        for(Plan plan: Util.getUserPlans())
        {
            if(plan.getDay().equals(day))
                plans.add(plan);
        }
        adapter.setPlans(plans);
    }

    private RecyclerView recyclerView;
    private TextView txtday;
    private Button btnAddMorePlan;

    private PlanRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        init();

        adapter = new PlanRecViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setType("edit");

        Intent intent = getIntent();

        try {
            String day = intent.getStringExtra("day");
            if(day!=null)
                txtday.setText(day);

            ArrayList<Plan> plans = new ArrayList<>();
            for (Plan plan: Util.getUserPlans())
            {
                if(plan.getDay().equals(day))
                    plans.add(plan);
            }
            adapter.setPlans(plans);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        btnAddMorePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, AllTraining.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    public void init()
    {
        Log.d(TAG, "init: called");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        txtday = (TextView) findViewById(R.id.txtday);
        btnAddMorePlan = (Button) findViewById(R.id.btnAddMorePlan);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}