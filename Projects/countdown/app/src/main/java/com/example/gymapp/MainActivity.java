package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Spinner spinner;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);

        InnerAsyncTask innerAsyncTask = new InnerAsyncTask();
        innerAsyncTask.execute(10);
    }

    private class InnerAsyncTask extends AsyncTask<Integer, Integer, String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView = (TextView) findViewById(R.id.txtNumber);

        }

        @Override
        protected String doInBackground(Integer... integers) {

            for (int i = integers[0]; i>0 ; i--) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Finish";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            textView.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }
}