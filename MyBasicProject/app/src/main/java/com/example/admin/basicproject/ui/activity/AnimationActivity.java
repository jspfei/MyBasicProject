package com.example.admin.basicproject.ui.activity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.content.res.ObbScanner;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.basicproject.R;
import com.example.admin.basicproject.ui.utils.AnimUtils;

public class AnimationActivity extends Activity {
    private ImageView ball;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        initView();
    }

    private void initView() {
        ball = (ImageView) findViewById(R.id.ball);
    }

    public void rotateyAnimRun(View view){
        ObjectAnimator
        .ofFloat(view,"rotationX",0.0f,360.f)
        .setDuration(500)
        .start();
    }
    public void propertyValuesHolder(View view)
    {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
                0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
                0, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
                0, 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY,pvhZ).setDuration(1000).start();
    }
    public void verticalRun(View view){
        AnimUtils.verticalRun(AnimationActivity.this,ball);
    }
    public void paowuxian(View view){
        AnimUtils.paowuxian(AnimationActivity.this,ball);
    }
}
