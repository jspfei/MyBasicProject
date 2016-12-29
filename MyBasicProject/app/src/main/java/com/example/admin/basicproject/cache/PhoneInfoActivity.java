package com.example.admin.basicproject.cache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.admin.basicproject.R;
import com.example.phoninfo.PhoneInfo;

public class PhoneInfoActivity extends AppCompatActivity {
    private final String TAG = "PhoneInfoActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_info);

        PhoneInfo info = new PhoneInfo(this);
        Log.d(TAG,"devices id: "+info.getDeviceId());
        Log.d(TAG,"getPhoneModule: "+info.getPhoneModule());
        Log.d(TAG,"getSerialNumber: "+info.getSerialNumber());
        Log.d(TAG,"getPhoneNumber: "+info.getPhoneNumber());
        Log.d(TAG,"getMacAddress: "+info.getMacAddress());
        Log.d(TAG,"getCpuInfo: "+info.getCpuInfo());
        Log.d(TAG,"getTotalMemory: "+info.getTotalMemory());
    }
}
