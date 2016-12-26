package com.example.admin.basicproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.admin.basicproject.cache.ImageCacheActivity;
import com.example.admin.basicproject.data_save.DataStorageActivity;
import com.example.admin.basicproject.data_save.activity.SharedPreferencesActivity;
import com.example.admin.basicproject.special_effect.SpecialEffectActivity;
import com.example.admin.basicproject.ui.UIListManagerActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    int[] mainImageIds = {R.drawable.icon_0,R.drawable.icon_1,R.drawable.icon_2,R.drawable.icon_3,R.drawable.icon_3};
    String[] mainStrs = {"UI","Jar","MVP","特效","存储"};
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        GridView gridView = (GridView) findViewById(R.id.gv_show);
        //动态生成数组，传入数据
        ArrayList<HashMap<String,Object>> listItem = new ArrayList<HashMap<String, Object>>();
        for(int i = 0 ;i<mainImageIds.length;i++){
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("itemsImg",mainImageIds[i]);
            map.put("itemsStr",mainStrs[i]);
            listItem.add(map);
        }

        SimpleAdapter imageItems = new SimpleAdapter(this,listItem,R.layout.grid_items,new String[]{"itemsImg","itemsStr"},
                new int[]{R.id.itemImage,R.id.itemText});
        gridView.setAdapter(imageItems);

        //点击图片进入响应操作
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent1 = new Intent(MainActivity.this, UIListManagerActivity.class);
                        startActivity(intent1);
                        break;
                    case 1:

                        Intent intent = new Intent(MainActivity.this, ImageCacheActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Toast.makeText(mContext,"MVP",Toast.LENGTH_LONG).show();
                        break;

                    case 3:
                        Intent intent2 = new Intent(MainActivity.this, SpecialEffectActivity.class);
                        startActivity(intent2);
                        break;
                    case 4:
                        Intent intent3 = new Intent(MainActivity.this,  DataStorageActivity.class);
                        startActivity(intent3);
                        break;

                }
            }
        });
    }
}
