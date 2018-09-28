package com.examprel.examprep.ArrayExample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.examprel.examprep.R;

public class ListActivity extends AppCompatActivity {
    Button btnpopulate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        btnpopulate = (Button)findViewById(R.id.butttonShowAnimal);
        btnpopulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(ListActivity.this,AnimalListActivity.class));
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
