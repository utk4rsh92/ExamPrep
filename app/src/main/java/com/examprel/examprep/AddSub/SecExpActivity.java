package com.examprel.examprep.AddSub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.examprel.examprep.R;

public class SecExpActivity extends AppCompatActivity {
    Button btAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_exp);
        btAdd = (Button)findViewById(R.id.btn_Add);

        setTitle("SecExpActivity");
        Intent intent = getIntent();
        final int number1 = intent.getIntExtra("number1", 0);
       final int number2 = intent.getIntExtra("number2",0);

        TextView tv = (TextView)findViewById(R.id.tv_sum);
        tv.setText("Numbers:"+number1+","+number2);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 + number2;
                Intent resultintent = new Intent();
                resultintent.putExtra("result",result);
                setResult(RESULT_OK,resultintent);
                finish();

            }
        });

    }

}
