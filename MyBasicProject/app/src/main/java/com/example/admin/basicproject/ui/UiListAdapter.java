package com.example.admin.basicproject.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.basicproject.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/12/12.
 */

public class UiListAdapter extends BaseAdapter {
    private List<String> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public UiListAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.adapter_ui_list_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tv_item.setText(data.get(i));
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.tv_item)
        TextView tv_item;

        public ViewHolder(View v) {
            ButterKnife.bind(this, v);
        }
    }
}
