package com.examprel.examprep.AddSub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.examprel.examprep.R;

public class FirstExpActivity extends AppCompatActivity {
    EditText edOne;
    EditText edTwo;
    TextView tvResult;
  Button btnResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_exp);
        edOne = (EditText)findViewById(R.id.ed_one);
        tvResult = (TextView)findViewById(R.id.textviewResult);
         edTwo = (EditText)findViewById(R.id.ed_two);
        btnResult = (Button)findViewById(R.id.btn_result);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edOne.getText().toString().equals("")
                        || edTwo.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please input numbers",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int number1 = Integer.parseInt(edOne.getText().toString());
                    int number2 = Integer.parseInt(edTwo.getText().toString());

                    Intent intent = new Intent(FirstExpActivity.this,SecExpActivity.class);
                    intent.putExtra("number1",number1);
                    intent.putExtra("number2",number2);
                    startActivityForResult(intent,1);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                int result = data.getIntExtra("result",0);
                tvResult.setText(""+result);
                edOne.setText("");
                edTwo.setText("");
            }
            if(resultCode == RESULT_CANCELED){
                tvResult.setText("Nothing selected");
                edOne.setText("");
                edTwo.setText("");
            }
        }
    }
}
