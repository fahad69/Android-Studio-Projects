package com.example.jobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;

public class MainActivity extends AppCompatActivity {

    public static final int DOWNLOAD_JOB_ID = 001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
    }


    private void init()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("number", 10);

            ComponentName componentName = new ComponentName(this, SampleJobService.class);
            JobInfo.Builder builder = new JobInfo.Builder(DOWNLOAD_JOB_ID, componentName);
            builder.setExtras(persistableBundle)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            .setPersisted(true);

            if(Build.VERSION.SDK_INT>=24) {
                builder.setPeriodic(30 * 60 * 1000, 60 * 60 * 1000);
            }
            else
                builder.setPeriodic(30*60*1000);

            JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
            jobScheduler.schedule(builder.build());
        }
    }
}