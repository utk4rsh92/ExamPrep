package com.examprel.examprep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
   private List<Data> dataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerAdapter = new RecyclerAdapter(dataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(layoutManager);
        prepareData();

    }

    private void prepareData() {

        recyclerAdapter.notifyDataSetChanged(); Data data = new Data("Aman","seven","Science");
        dataList.add(data);
        data = new Data("Rahul","twelve","commerce");
        dataList.add(data);
        data = new Data("Mehul","eighth","Science");
        dataList.add(data);
        data = new Data("Rahul","eighth","Science");
        dataList.add(data);
        data =  new Data("Suchita","fifth", "english");
        dataList.add(data);
        data = new Data("Megha","ninth","Maths");
        dataList.add(data);

    }
}
