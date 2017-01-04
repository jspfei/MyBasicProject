package com.example.admin.basicproject.custom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by admin on 2017/1/4.
 */

public class CounterView extends View implements View.OnClickListener {
    private Paint mPanit;

    private Rect mBounds;

    private int mCount;

    public CounterView(Context context , AttributeSet attrs){
        super(context,attrs);
        mPanit = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds = new Rect();
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        mPanit.setColor(Color.BLUE);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPanit);
        mPanit.setColor(Color.YELLOW);
        mPanit.setTextSize(50);
        String text = String.valueOf(mCount);
        mPanit.getTextBounds(text,0,text.length(),mBounds);

        float textWidth = mBounds.width();
        float textHeight = mBounds.height();
        canvas.drawText(text,getWidth()/2 -textWidth/2,getHeight()/2+
        textHeight/2,mPanit);

    }

    @Override
    public void onClick(View v) {
        mCount++;
        invalidate();
    }
}
