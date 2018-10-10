package com.examprel.examprep.ArrayExample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.examprel.examprep.R;

import java.util.ArrayList;

public class ArrayResult extends AppCompatActivity {
    TextView tvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_result);
        tvList = (TextView)findViewById(R.id.tvnextData);
        ArrayList<String> ar = (ArrayList<String>)getIntent().getSerializableExtra("myData");
        tvList.setText("");
        for (int i =0 ;i<ar.size();i++){
            tvList.append("\n"+ar.get(i)+"\n");

        }
    }
}
