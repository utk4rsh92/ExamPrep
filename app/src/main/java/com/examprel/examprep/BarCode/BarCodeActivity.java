package com.examprel.examprep.BarCode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.examprel.examprep.R;

public class BarCodeActivity extends AppCompatActivity {
    private Button btnScan;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code);
        btnScan = (Button)findViewById(R.id.btn_scan);
        tvResult = (TextView)findViewById(R.id.tv_result) ;
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BarCodeActivity.this,ScannerActivity.class);
                startActivityForResult(intent,7);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 7 && resultCode == RESULT_OK){
            tvResult.setText(data.getExtras().getString("CODE"));

        }
    }
}
