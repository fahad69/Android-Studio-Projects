package com.example.gymapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class AskForDetails extends DialogFragment {

    private static final String TAG = "AskForDetails";

    private EditText timeEditText;
    private Button btnAdd, btnCancel;
    private Spinner spinnerDay;

    public interface GetDetails{
        void onGetDetails(Plan plan);
    }

    private GetDetails getDetails;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_ask_for_details, null);

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Enter Details")
                .setView(view);

        init(view);

        ArrayList<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, days);
        spinnerDay.setAdapter(adapter);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        try {
            getDetails = (GetDetails) getActivity();
        }catch (ClassCastException e)
        {
            e.printStackTrace();
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: pass data to parent
                Bundle bundle = getArguments();
                GymTraining training = bundle.getParcelable("training");
                if(null!=training)
                {
                    Plan plan = new Plan();
                    plan.setComplete(false);
                    plan.setDay(spinnerDay.getSelectedItem().toString());
                    plan.setMinutes(Integer.valueOf(timeEditText.getText().toString()));
                    plan.setTraining(training);

                    getDetails.onGetDetails(plan);
                }
            }
        });

        return builder.create();
    }

    private void init(View view)
    {
        Log.d(TAG, "init: called");
        timeEditText = (EditText) view.findViewById(R.id.editTextTime);
        btnAdd = (Button) view.findViewById(R.id.btnAdd);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        spinnerDay = (Spinner) view.findViewById(R.id.SpinnerDay);
    }
}
