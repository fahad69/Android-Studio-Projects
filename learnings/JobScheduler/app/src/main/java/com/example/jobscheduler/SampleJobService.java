package com.example.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.os.Build;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

public class SampleJobService extends JobService {

    private static final String TAG = "SampleJobService";

    private SampleAsync sampleAsync;

    private JobParameters parameters;

    @Override
    public boolean onStartJob(JobParameters params) {
        this.parameters = params;
        PersistableBundle bundle = params.getExtras();
        int number = bundle.getInt("number");
        sampleAsync = new SampleAsync();
        sampleAsync.execute(number);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG, "onStopJob: cancelled");
        if(sampleAsync!=null)
            sampleAsync.cancel(true);
        return true;
    }

    private class SampleAsync extends AsyncTask<Integer, Integer, String>
    {

        @Override
        protected String doInBackground(Integer... integers) {

            for (int i = 0; i <integers[0] ; i++) {
                publishProgress(i);
                try {
                    Thread.sleep(1000);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return "Job Finished";
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.d(TAG, "onProgressUpdate: i: " + values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d(TAG, "onPostExecute: " + s);
            jobFinished(parameters, true);
            super.onPostExecute(s);
        }
    }
}
