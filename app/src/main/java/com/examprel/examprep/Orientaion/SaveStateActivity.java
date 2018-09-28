package com.examprel.examprep.Orientaion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.examprel.examprep.R;

public class SaveStateActivity extends AppCompatActivity {
    EditText saveName;
    private String stName;
    Button btnSet;
    TextView tvText;
    private static final String KEY_NAME = "name_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_state);
        saveName = (EditText)findViewById(R.id.ed_savename);
        tvText = (TextView)findViewById(R.id.tvSetTxt);
        btnSet = (Button)findViewById(R.id.btnGo);
        if(savedInstanceState !=null){
            String stsaveName = savedInstanceState.getString(KEY_NAME);
            tvText.setText(stsaveName);
        }

        else {
            Toast.makeText(getApplicationContext(),"No",Toast.LENGTH_SHORT).show();
        }
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stName = saveName.getText().toString();
                tvText.setText(stName);
            }
        });

    }

   @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_NAME, tvText.getText().toString());
        super.onSaveInstanceState(outState);

  }

  }
