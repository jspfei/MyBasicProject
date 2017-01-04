package com.example.admin.basicproject.custom.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.admin.basicproject.R;

/**
 * Created by admin on 2017/1/4.
 */

public class CounterViewActivity extends Activity {

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_counter_view);
    }

}
