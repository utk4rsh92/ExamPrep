package com.examprel.examprep.sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.examprel.examprep.R;

import java.util.List;

public class ViewActivity extends AppCompatActivity {
    Button btnshow;
    DatabaseHelper databaseHelper;
    RecyclerView recyclerView;
    SqLiteRecycler sqLiteRecycler;
List<DataModel>datamodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
       btnshow = (Button) findViewById(R.id.view);
       btnshow.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               databaseHelper = new DatabaseHelper(ViewActivity.this);
               datamodel = databaseHelper.getData();

               sqLiteRecycler = new SqLiteRecycler(datamodel);
               RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
               recyclerView.setLayoutManager(layoutManager);
               recyclerView.setItemAnimator(new DefaultItemAnimator());
               recyclerView.setAdapter(sqLiteRecycler);
           }
       });
    }
}
