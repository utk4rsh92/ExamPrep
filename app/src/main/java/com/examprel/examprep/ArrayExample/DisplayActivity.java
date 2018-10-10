package com.examprel.examprep.ArrayExample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.examprel.examprep.R;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    private EditText ed1,ed2,ed3,ed4,ed5;
    private Button btns;
    ArrayList<String> name ; 
    String val1,val2,val3,val4,val5;
    TextView tvOutput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        name = new ArrayList<String>();
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        ed4 = (EditText) findViewById(R.id.ed4);
        ed5 = (EditText) findViewById(R.id.ed5);
        tvOutput = (TextView)findViewById(R.id.txtResult);
        btns = (Button)findViewById(R.id.btnarray);
        
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                val1 = ed1.getText().toString();
                val2 = ed2.getText().toString();
                val3 = ed3.getText().toString();
                val4 = ed4.getText().toString();
                val5 = ed5.getText().toString();

                putName();

       displayDataOfName();


            }
        });

    }

    private void displayDataOfName() {
        tvOutput.setText("");
        for (int i =0 ;i<name.size();i++){
        tvOutput.append("\n"+name.get(i)+"\n");

        }
    }

    private void putName() {

        name.add(val1);
        name.add(val2);
        name.add(val3);
        name.add(val4);
        name.add(val5);
    }
}
