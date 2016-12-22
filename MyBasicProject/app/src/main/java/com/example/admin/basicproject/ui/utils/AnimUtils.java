package com.example.admin.basicproject.ui.utils;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.admin.basicproject.ui.activity.AnimationActivity;

/**
 * Created by admin on 2016/12/22.
 */

public class AnimUtils {

    /**
     * 自由落体
     * @param activity
     * @param img
     */
    public static void verticalRun(Activity activity, final ImageView img)
    {
        ValueAnimator animator = ValueAnimator.ofFloat(0, SystemUtils.getScreenHeight(activity)
                - img.getHeight());
        animator.setTarget(img);
        animator.setDuration(1000).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                img.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
    }
    /**
     * 抛物线
     * @param img
     */
    public static void paowuxian(Activity activity, final ImageView img)
    {

        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>()
        {
            // fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startValue,
                                   PointF endValue)
            {
                Log.e("", fraction * 3 + "");
                // x方向200px/s ，则y方向0.5 * 10 * t
                PointF point = new PointF();
                point.x = 200 * fraction * 3;
                point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                PointF point = (PointF) animation.getAnimatedValue();
                img.setX(point.x);
                img.setY(point.y);

            }
        });
    }
}
