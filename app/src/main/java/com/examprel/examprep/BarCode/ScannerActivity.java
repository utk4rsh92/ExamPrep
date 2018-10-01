package com.examprel.examprep.BarCode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private static final String TAG = ScannerActivity.class.getName();

    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        String barCodeFormat = rawResult.getBarcodeFormat().toString();
        String barCode = rawResult.getText();
        // Do something with the result here
        Log.v(TAG, barCode); // Prints scan results
        Log.v(TAG, barCodeFormat); // Prints the scan format (qrcode, pdf417 etc.)

        // If you would like to resume scanning, call this method below:
//        mScannerView.resumeCameraPreview(this);\

        Bundle extras = new Bundle();
        extras.putString("CODE", barCode);
        extras.putString("FORMAT", barCodeFormat);

        Intent data = new Intent();
        data.putExtras(extras);

        setResult(RESULT_OK, data);
        finish();
    }
}
