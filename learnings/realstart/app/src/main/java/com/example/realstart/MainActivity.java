package com.example.realstart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText FirstName;
    EditText LastName;
    EditText Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstName = findViewById(R.id.TypeFirstName);
        LastName = findViewById(R.id.TypeLastName);
        Email = findViewById(R.id.TypeEmail);
    }

    public void onbtnclick(View view)
    {
        TextView Fview = findViewById(R.id.FirstNameView);
        TextView Lview = findViewById(R.id.LastNameView);
        TextView Eview = findViewById(R.id.EmailView);

        //String name = editText.getText().toString();
        //textView.setText("Hello " + name);
        Fview.setText(FirstName.getText().toString());
        Lview.setText(LastName.getText().toString());
        Eview.setText(Email.getText().toString());
    }
}
