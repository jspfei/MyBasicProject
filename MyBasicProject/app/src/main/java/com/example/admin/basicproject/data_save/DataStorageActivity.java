package com.example.admin.basicproject.data_save;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.admin.basicproject.R;
import com.example.admin.basicproject.data_save.activity.SharedPreferencesActivity;
import com.example.admin.basicproject.litepal.LitePalActivity;

/**
 * Created by admin on 2016/12/26.
 */

public class DataStorageActivity extends Activity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_shared_preference_list).setOnClickListener(this);
        findViewById(R.id.btn_lite_pal).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_shared_preference_list:
                Intent intent = new Intent(DataStorageActivity.this, SharedPreferencesActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_lite_pal:
                Intent intent1 = new Intent(DataStorageActivity.this, LitePalActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
