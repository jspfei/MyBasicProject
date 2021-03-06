package com.example.admin.basicproject.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.basicproject.R;
import com.example.admin.basicproject.ui.activity.AnimationActivity;
import com.example.admin.basicproject.ui.adapter.UiListAdapter;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class UIListManagerActivity extends AppCompatActivity {

    @BindView(R.id.lv_ui_list) ListView lv_ui_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uilist_manager);
        ButterKnife.bind(this);

        String[] titls = this.getResources().getStringArray(R.array.ui_names);

        List list = Arrays.asList(titls);

        lv_ui_list.setAdapter(new UiListAdapter(this,list));
    }
    @OnItemClick(R.id.lv_ui_list)
    void onItemClick(int i){
      switch (i){
          case 0:
              Toast.makeText(this,"TextView",Toast.LENGTH_SHORT).show();
              break;
          case 14:
              Intent intent = new Intent(this, AnimationActivity.class);
              startActivity(intent);
              break;
          default:
              break;
      }


    }
}
