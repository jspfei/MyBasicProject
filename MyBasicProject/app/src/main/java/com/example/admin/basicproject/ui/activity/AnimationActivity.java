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

/*
    名称
            属性
    备注
    android:shareInterpolator
            是否共享插入器
    共享时，四个子节点都用一个插入器
    android:interpolator
            指定一个动画的插入器
    使用系统资源
    android:fillEnabled

    当设置为true时，fillAfter和fill, Befroe将会都为true，此时会忽略fillBefore 和fillAfter两种属性
    android:fillAfter
            该动画转化是否在动画结束后被应用
    boolean
    android:fillBefore
            该动画转化是否在动画开始前被应用
    boolean
    android:repeatMode
            重复模式
    "restart"  或者 "reverse"
    android:repeatCount
            重复次数
    integer
    android:duration
            动画持续时间
    integer
    android:startOffset
            动画时间间隔
    long
    android:zAdjustment
    定义动画z order的变换
    [normal] or [top] or [bottom]
    android:detachWallpaper

    boolean*/
}
