package com.dialog.jf.readexcel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dialog.jf.readexcel.R;

import java.util.List;

/**
 * Created by admin on 2017/1/9.
 */

public class MyGridViewAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public MyGridViewAdapter(Context context, List<String> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_view_item,null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.tv_show);
        textView.setText(list.get(position));
        return convertView;
    }
}
