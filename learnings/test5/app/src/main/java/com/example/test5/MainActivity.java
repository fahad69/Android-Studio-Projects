package com.example.test5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private boolean isBound = false;
    private SampleService2 mService;
    private TextView textView;
    Update update;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            SampleService2.LocalBinder binder = (SampleService2.LocalBinder) service;
            mService = binder.getBinder();

            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Intent intent = new Intent(this, SampleService.class);
        intent.putExtra("number", 10);
        startService(intent);*/
        textView = (TextView) findViewById(R.id.ttt);
        displayRandom();
    }

    private void displayRandom()
    {
        Log.d(TAG, "displayRandom: started");

        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    if(isBound && mService != null)
                        Log.d(TAG, "run: random: " + mService.getRandom());
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();*/

        update = new Update();
        update.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, SampleService2.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(isBound)
        {
            unbindService(serviceConnection);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(null!=update){
            update.cancel(true);
        }
    }

    private class Update extends AsyncTask<Void, Integer, Void>
    {
        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i <1550 ; i++) {
                if(isBound && mService != null)
                {
                    publishProgress(mService.getRandom());
                }
                else
                    publishProgress(0);

                try {
                    Thread.sleep(10);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            textView.setText(String.valueOf(values[0]));
            super.onProgressUpdate(values);
        }
    }
}