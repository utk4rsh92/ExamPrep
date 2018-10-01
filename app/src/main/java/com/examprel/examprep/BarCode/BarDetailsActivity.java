package com.examprel.examprep.BarCode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.examprel.examprep.R;

public class BarDetailsActivity extends AppCompatActivity {
   private RecyclerView recyclerView;
   private BarAdapter barAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_details);
        recyclerView = (RecyclerView)findViewById(R.id.bar_recyclerview);
    }
}
