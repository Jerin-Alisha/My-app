package com.example.internetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Button;
import android.widget.TextView;

import static android.Manifest.permission.READ_PHONE_STATE;
import static android.telephony.TelephonyManager.NETWORK_TYPE_CDMA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_EDGE;
import static android.telephony.TelephonyManager.NETWORK_TYPE_EVDO_0;
import static android.telephony.TelephonyManager.NETWORK_TYPE_EVDO_A;
import static android.telephony.TelephonyManager.NETWORK_TYPE_EVDO_B;
import static android.telephony.TelephonyManager.NETWORK_TYPE_GPRS;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSDPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSPAP;
import static android.telephony.TelephonyManager.NETWORK_TYPE_IDEN;
import static android.telephony.TelephonyManager.NETWORK_TYPE_LTE;
import static android.telephony.TelephonyManager.NETWORK_TYPE_NR;
import static android.telephony.TelephonyManager.NETWORK_TYPE_UMTS;

public class Activity3 extends AppCompatActivity {

    public TextView textView2;
    public TelephonyManager telephonyManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        textView2 = findViewById(R.id.textView2);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, PackageManager.PERMISSION_GRANTED);
        telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        switch (telephonyManager.getDataNetworkType()) {
            case NETWORK_TYPE_EDGE:
            case NETWORK_TYPE_GPRS:
            case NETWORK_TYPE_CDMA:
            case NETWORK_TYPE_IDEN:
                textView2.setText("2G");
                break;
            case NETWORK_TYPE_UMTS:
            case NETWORK_TYPE_HSDPA:
            case NETWORK_TYPE_HSPA:
            case NETWORK_TYPE_HSPAP:
            case NETWORK_TYPE_EVDO_0:
            case NETWORK_TYPE_EVDO_A:
            case NETWORK_TYPE_EVDO_B:
                textView2.setText("3G");
                break;
            case NETWORK_TYPE_LTE:
                textView2.setText("4G");
                break;
            case NETWORK_TYPE_NR:
                textView2.setText("5G");
                break;

            default:
                textView2.setText("Unknown");
        }
    }
}