package com.examprel.examprep.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.examprel.examprep.ArrayExample.AnimalListActivity;
import com.examprel.examprep.R;

public class LoginActivity extends AppCompatActivity {
    TextView tvRegister;
    EditText edEmail;
    EditText edPassword;
    Button btLogin;
    String stEmail, stPassword;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvRegister = (TextView)findViewById(R.id.tv_register);
        edEmail = (EditText)findViewById(R.id.ed_email);
        edPassword = (EditText)findViewById(R.id.ed_password);
        btLogin = (Button)findViewById(R.id.btnLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stEmail  = edEmail.getText().toString();
                stPassword = edPassword.getText().toString();
                if(stEmail.isEmpty() && stPassword.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Cannot be blank",Toast.LENGTH_SHORT).show();

                }
                else {
                   verifyFromDatabase();
                }
            }
        });
    }

    private void verifyFromDatabase() {
        if(databaseHelper.checkUser(edEmail.getText().toString().trim(), edPassword.getText().toString().trim())){
            Intent intent = new Intent(LoginActivity.this, AnimalListActivity.class);
            intent.putExtra("EMAIL",edEmail.getText().toString());
            startActivity(intent);
        }

    }
}
