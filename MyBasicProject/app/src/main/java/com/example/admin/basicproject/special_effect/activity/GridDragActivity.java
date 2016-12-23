package com.example.admin.basicproject.special_effect.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.basicproject.R;
import com.example.admin.basicproject.special_effect.utils.GridViewInterceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GridDragActivity extends AppCompatActivity {

    int[] image = {

            R.mipmap.icon1, R.mipmap.icon2, R.mipmap.icon3, R.mipmap.icon4,
            R.mipmap.icon5, R.mipmap.icon6, R.mipmap.icon7, R.mipmap.icon8,
            R.mipmap.icon9 };
    private MyAdapter adapter = null;
    private ArrayList<Map<String, Object>> array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_drag);

        GridViewInterceptor gv = (GridViewInterceptor) findViewById(R.id.gride);
        array = getData();
        adapter = new MyAdapter();
        gv.setDropListener(onDrop);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new ItemClickEvent());
    }


    private GridViewInterceptor.DropListener onDrop = new GridViewInterceptor.DropListener() {
        public void drop(int from, int to) {
            Map item = adapter.getItem(from);

            adapter.remove(item);
            adapter.insert(item, to);

        }
    };

    class MyAdapter extends ArrayAdapter<Map<String, Object>> {

        MyAdapter() {
            super(GridDragActivity.this, R.layout.mygrid, array);
        }

        public ArrayList<Map<String, Object>> getList() {
            return array;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.mygrid, parent, false);
            }
            ImageView imageView = (ImageView) row.findViewById(R.id.img);
            imageView.setImageResource(Integer.valueOf(array.get(position)
                    .get("img").toString()));

            return (row);
        }
    }

    private ArrayList<Map<String, Object>> getData() {
        ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < image.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", image[i]);
            list.add(map);

        }
        return list;
    }

    class ItemClickEvent implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {

            arg1.setPressed(false);
            arg1.setSelected(false);
        }
    }
}
