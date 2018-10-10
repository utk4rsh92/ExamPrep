package com.examprel.examprep.Job;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JobExample extends JobService {

    private static final String TAG = "ExampleJobService";
    private boolean jobCancelled = false;

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG,"StartJob:  ");
       dobackgroundwork(params);
        return true;
    }

    private void dobackgroundwork(final JobParameters params) {
    new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 0;i<10;i++){
              Log.d(TAG,"run:"+i);
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
          Log.d(TAG,"job finished");
          jobFinished(params,false);
        }
    }).start();
    }

    @Override
    public boolean onStopJob(JobParameters params) {
 Log.d(TAG,"JOB CANCELLED");
        jobCancelled = false;
        return true;
    }
}
