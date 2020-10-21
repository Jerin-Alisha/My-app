package com.example.internetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {
    public TextView textView3;
    public TelephonyManager telephonyManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        textView3 = findViewById(R.id.textView3);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, PackageManager.PERMISSION_GRANTED);
        telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        textView3.setText("" + telephonyManager.getSignalStrength());
    }
}
