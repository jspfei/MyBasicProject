package com.example.admin.basicproject.special_effect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.basicproject.R;
import com.example.admin.basicproject.special_effect.activity.GridDragActivity;
import com.example.admin.basicproject.ui.activity.AnimationActivity;
import com.example.admin.basicproject.ui.adapter.UiListAdapter;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by admin on 2016/12/23.
 */

public class SpecialEffectActivity extends Activity {
    @BindView(R.id.lv_special_effect_list)
    ListView list_view_special_effect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_effect);
        ButterKnife.bind(this);
        String[] titls = this.getResources().getStringArray(R.array.special_effect);

        List list = Arrays.asList(titls);

        list_view_special_effect.setAdapter(new UiListAdapter(this, list));
    }

    @OnItemClick(R.id.lv_special_effect_list)
    void onItemClick(int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent(this, GridDragActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }

    }
}
