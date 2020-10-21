package com.example.internetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    public TextView textView1;
    public TelephonyManager telephonyManager;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textView1 = findViewById(R.id.textView1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, PackageManager.PERMISSION_GRANTED);
        telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        textView1.setText("" + telephonyManager.getNetworkOperatorName());
    }
}