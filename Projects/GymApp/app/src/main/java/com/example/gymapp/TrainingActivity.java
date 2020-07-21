package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TrainingActivity extends AppCompatActivity  implements AskForDetails.GetDetails {

    private static final String TAG = "TrainingActivity";

    @Override
    public void onGetDetails(Plan plan) {
        Log.d(TAG, "onGetDetails: called");
        Util.addToPlan(plan);
        Intent intent = new Intent(this, PlanActivity.class);
        intent.setFlags((Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
        intent.putExtra("plan", plan);
        startActivity(intent);
    }

    private Button btnAddToPlan;
    private TextView trainingName, trainingLongDesc;
    private ImageView trainingImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        init();

        Intent intent = getIntent();

        try {
            final GymTraining incomingTraining = intent.getParcelableExtra("training");
            trainingName.setText(incomingTraining.getName());
            trainingLongDesc.setText(incomingTraining.getLongDesc());
            Glide.with(this)
                    .asBitmap()
                    .load(incomingTraining.getImageUrl())
                    .into(trainingImage);

            btnAddToPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO: show dialog
                    AskForDetails askForDetails = new AskForDetails();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("training", incomingTraining);
                    askForDetails.setArguments(bundle);
                    askForDetails.show(getSupportFragmentManager(), "ask for details");
                }
            });

        }catch (NullPointerException e)
        {
            e.getMessage();
        }
    }

    public void init(){

        Log.d(TAG, "init: started");

        btnAddToPlan = findViewById(R.id.btnAddToPlan);
        trainingImage = findViewById(R.id.trainingImage);
        trainingName = findViewById(R.id.trainingName);
        trainingLongDesc = findViewById(R.id.trainingLongDescription);
    }
}