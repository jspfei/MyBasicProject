package com.example.admin.basicproject.data_save.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.admin.basicproject.R;
import com.example.admin.basicproject.data_save.bean.Userbean;
import com.example.admin.basicproject.data_save.utils.ListDataSave;
import com.example.admin.basicproject.data_save.utils.ObjectDataSave;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SharedPreferencesActivity extends AppCompatActivity implements View.OnClickListener {
    Context mContext;
    ListDataSave listDataSave;

    private ArrayList<Userbean> listBean;
    private ArrayList<String> listString;
    private ArrayList<Map<String,Object>> listMap;
    private Userbean userBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_addString).setOnClickListener(this);
        findViewById(R.id.btn_addJavaBean).setOnClickListener(this);
        findViewById(R.id.btn_addMap).setOnClickListener(this);
        findViewById(R.id.btn_getString).setOnClickListener(this);
        findViewById(R.id.btn_getJavaBean).setOnClickListener(this);
        findViewById(R.id.btn_getMap).setOnClickListener(this);
        findViewById(R.id.btn_addObject).setOnClickListener(this);
        findViewById(R.id.btn_getObject).setOnClickListener(this);
        mContext = getApplicationContext();
        listDataSave = new ListDataSave(mContext,"jf");
        listString = new ArrayList<String>();
        listBean = new ArrayList<Userbean>();
        listMap = new ArrayList<Map<String,Object>>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_addString:
                String s = "小米";
                String s1 = "小米1";
                listString.add(s);
                listString.add(s1);
                listDataSave.setDataList("string",listString);

                break;
            case R.id.btn_getString:
                Toast.makeText(mContext,listDataSave.getDataList("string").toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_addJavaBean:
                Userbean user = new Userbean();
                user.setName("小凡");
                user.setAge(16);
                listBean.add(user);
                listDataSave.setDataList("javaBean",listBean);
                break;
            case R.id.btn_getJavaBean:
                Toast.makeText(mContext,listDataSave.getDataList("javaBean").toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_addMap:
                Map<String ,Object> map = new HashMap<String,Object>();
                map.put("name","小凡");
                map.put("age",18);
                listMap.add(map);
                listDataSave.setDataList("listMap",listMap);
                break;
            case R.id.btn_getMap:
                Toast.makeText(mContext,listDataSave.getDataList("listMap").toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_addObject:
                Userbean userb = new Userbean();
                userb.setName("张无忌");
                userb.setAge(19);
                ObjectDataSave.saveObject(mContext,"jf_object",userb);
                break;
            case R.id.btn_getObject:
                Userbean user_data = (Userbean) ObjectDataSave.readObject(mContext,"jf_object");
                Gson gson = new Gson();
                String user_str = gson.toJson(user_data);
                Toast.makeText(mContext,user_str,Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
