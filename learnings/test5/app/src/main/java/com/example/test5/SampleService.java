package com.example.test5;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class SampleService extends IntentService {

    private static final String TAG = "SampleService";

    public SampleService() {
        super("hello");
    }

    public SampleService(String name) {
        super("Download Thread");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            int number = intent.getIntExtra("number", 0);

            for (int i = 0; i <=number ; i++) {
                Log.d(TAG, "onHandleIntent: downloading at: " + (i*100)/number + " percent");
                Thread.sleep(1000);
            }
        }catch (Exception e)
        {
            e.getMessage();
        }
    }


}
