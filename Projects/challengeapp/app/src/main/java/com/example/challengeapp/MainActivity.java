package com.example.challengeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView backarrow, settings, voice, cart, car;
    private EditText name_edit_text, email_edit_text, description_edit_text, website_edit_text;
    private Spinner spinner;
    private RadioGroup radioGroup;
    private Button submit;
    private ArrayList<String> countries = new ArrayList<>();
    private String country = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initwidgets();


        countries.add("USA");
        countries.add("UK");
        countries.add("Bangladesh");
        countries.add("Wadiya");
        countries.add("Switzerland");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this ,
                android.R.layout.simple_spinner_dropdown_item,
                countries);

        spinner.setAdapter(adapter);

        init_on_click_listeners();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submission_finished();
            }
        });

    }

    private void initwidgets()
    {
        backarrow = (ImageView) findViewById(R.id.topbackarrow);
        settings = (ImageView) findViewById(R.id.topsettings);
        voice = (ImageView) findViewById(R.id.voice);
        cart = (ImageView) findViewById(R.id.cart);
        car = (ImageView) findViewById(R.id.car);

        name_edit_text = (EditText) findViewById(R.id.typename);
        email_edit_text = (EditText) findViewById(R.id.typeemail);
        website_edit_text = (EditText) findViewById(R.id.typeWebsite);
        description_edit_text = (EditText) findViewById(R.id.typedescription);

        spinner = (Spinner) findViewById(R.id.countryspinner);

        submit = (Button) findViewById(R.id.submitbtn);

        radioGroup = (RadioGroup) findViewById(R.id.genderRadiogroup);
    }

    private void submission_finished()
    {
        String name = name_edit_text.getText().toString();
        String email = email_edit_text.getText().toString();
        String description = description_edit_text.getText().toString();
        String website = website_edit_text.getText().toString();

        String gender = "";


        int checkedRb = radioGroup.getCheckedRadioButtonId();
        if(checkedRb == R.id.rbmale)
            gender = "Male";
        else if(checkedRb == R.id.rbfemale)
            gender = "Female";
        else
            gender = "Other";


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country = countries.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                country = "No Country";
            }
        });

        String finalMessage = "";
        finalMessage = "Name: " + name + "\nEmail: " + email + "\nCountry: ";
        finalMessage += country + "\nWebsite: " + website + "\nGender: " + gender;
        finalMessage += "\nDescription: " + description;

        Toast.makeText(this, finalMessage, Toast.LENGTH_LONG).show();


    }

    private void init_on_click_listeners()
    {
        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Back Arrow", Toast.LENGTH_SHORT).show();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
            }
        });
        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Voice", Toast.LENGTH_SHORT).show();
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Shop", Toast.LENGTH_SHORT).show();
            }
        });
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Car", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
