package com.examprel.examprep.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.examprel.examprep.R;

public class SqliteActivity extends AppCompatActivity {
    EditText edName;
    EditText edStandard;
    EditText edStream;
    Button btnSubmit,btnView;
    String stname,ststandard,ststream;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        edName = (EditText)findViewById(R.id.ed_name);
        edStandard = (EditText)findViewById(R.id.ed_standard);
        edStream = (EditText)findViewById(R.id.ed_stream);
         btnView = (Button) findViewById(R.id.btn_view);

        btnSubmit = (Button)findViewById(R.id.btn_submit);
        submitButton();
        viewButton();
    }

    private void viewButton() {
    btnView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        startActivity(new Intent(SqliteActivity.this,ViewActivity.class));


        }
    });
    }

    private void submitButton() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Toast.makeText(getApplicationContext(),"help",Toast.LENGTH_SHORT).show();
              stname = edName.getText().toString();
              ststandard = edStandard.getText().toString();
              ststream = edStream.getText().toString();
              if(stname.isEmpty()&& ststandard.isEmpty()&& ststream.isEmpty()){
                  edName.setError("Cannot be blank");
                  edStandard.setError("Cannot be blank");
                  edStream.setError("Cannot be blank");
              }
              else {
                  databaseHelper.insertdata(stname,ststandard,ststream);
                  edName.setText("");
                  edStandard.setText("");
                  edStream.setText("");
                Intent intent = new Intent(SqliteActivity.this,ViewActivity.class);
                startActivity(intent);
                  //  Toast.makeText(getApplicationContext(),"Data inserted",Toast.LENGTH_SHORT).show();
              }
            }
        });
    }
}
