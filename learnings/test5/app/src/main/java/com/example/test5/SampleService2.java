package com.example.test5;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.Random;

public class SampleService2 extends Service {

    private static final String TAG = "SampleService2";

    private IBinder binder = new LocalBinder();
    private Random random = new Random();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class LocalBinder extends Binder{
        SampleService2 getBinder()
        {
            return SampleService2.this;
        }
    }

    public int getRandom()
    {
        return  random.nextInt(999);
    }
}
