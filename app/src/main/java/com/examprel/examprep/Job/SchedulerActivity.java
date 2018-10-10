package com.examprel.examprep.Job;

import android.content.ComponentName;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.examprel.examprep.R;

public class SchedulerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);
    }
     public void scheduleJob(View v){
         ComponentName componentName = new ComponentName(this,JobExample.class);
        // JobInfo jobInfo = new JobInfo().Builder(123,componentName);

     }
     public void cancelJob(View v){


     }
}
