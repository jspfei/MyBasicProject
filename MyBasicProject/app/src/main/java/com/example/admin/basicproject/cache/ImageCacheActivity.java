package com.example.admin.basicproject.cache;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.admin.basicproject.R;
import com.example.admin.basicproject.io.JsonRead;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by admin on 2016/12/9.
 */

public class ImageCacheActivity extends Activity{

    private static Context mContext;
    private ImageView iv_cache_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_image_cache);
        mContext=this.getApplicationContext();

        // 图片链接
        String imgUrl = "http://ww1.sinaimg.cn/mw690/805fa900jw1f5q2lmksttg20c8058qv5.gif";
        // 图片控件
        ImageView img = (ImageView) findViewById(R.id.iv_cache_img);

        // 加载图片  支持加载 gif jpg png
        Glide.with(this).load(imgUrl).centerCrop().placeholder(R.drawable.load_ing).crossFade().into(img);

        readJson();

    }

    public   void readJson(){
        JsonRead.readAssets(mContext);
    }

}
