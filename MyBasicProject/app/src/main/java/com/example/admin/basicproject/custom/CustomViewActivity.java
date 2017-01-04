package com.example.admin.basicproject.custom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.admin.basicproject.R;
import com.example.admin.basicproject.custom.activity.CounterViewActivity;
import com.example.admin.basicproject.custom.activity.MyListViewActivity;
import com.example.admin.basicproject.custom.view.MyListView;

/**
 * 自定义View控件
 * Created by admin on 2017/1/4.
 */

public class CustomViewActivity extends Activity {

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_custom_view);
    }

    public void showSelfPainView(View view){
        Intent intent = new Intent(CustomViewActivity.this, CounterViewActivity.class);
        startActivity(intent);
    }

    public void showCombinationView(View view){
        Intent intent = new Intent(CustomViewActivity.this, CounterViewActivity.class);
        startActivity(intent);
    }
    public void showExtendsView(View view){
        Intent intent = new Intent(CustomViewActivity.this, MyListViewActivity.class);
        startActivity(intent);
    }
}
