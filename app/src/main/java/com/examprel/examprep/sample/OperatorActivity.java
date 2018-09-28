package com.examprel.examprep.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.examprel.examprep.R;

public class OperatorActivity extends AppCompatActivity {
    EditText edVal;
    EditText edValz;
    private Button btnMethod;
    private Button btnCompare;
    String s1,s2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator);
        edVal = (EditText)findViewById(R.id.ed_val1);
        edValz = (EditText)findViewById(R.id.ed_val2);
        btnMethod = (Button) findViewById(R.id.btn_method);
        btnCompare = (Button)findViewById(R.id.btn_operator);

        btnCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = edVal.getText().toString();
                s2 = edValz.getText().toString();
                if (s1.isEmpty()|| s2.isEmpty()) {
                    edVal.setError("Cannot b blank");
                    edValz.setError("Cannot b blank");
                }
                else  if(s1.equals(s2)){
                    Toast.makeText(OperatorActivity.this, "Similar",Toast.LENGTH_SHORT).show();
                    edVal.setText("");
                    edValz.setText("");
                }

                else {
                    Toast.makeText(OperatorActivity.this, "Not Similar", Toast.LENGTH_SHORT).show();
                    edVal.setText("");
                    edValz.setText("");
                }
            }
        });
        btnMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = edVal.getText().toString();
                s2 = edValz.getText().toString();
                if (s1.isEmpty()|| s2.isEmpty()){
                    edVal.setError("Cannot b blank");
                    edValz.setError("Cannot b blank");
                }
                else if(s1 == s2){

                    Toast.makeText(getApplicationContext(), "message",Toast.LENGTH_SHORT).show();
                    edVal.setText("");
                    edValz.setText("");
                }
            }
        });

    }




}

