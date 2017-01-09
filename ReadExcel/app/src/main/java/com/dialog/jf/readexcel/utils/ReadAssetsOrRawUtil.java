package com.dialog.jf.readexcel.utils;

import android.content.Context;
import android.util.Log;

import com.dialog.jf.readexcel.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * //
 * Created by admin on 2017/1/9.
 */

public class ReadAssetsOrRawUtil {


    //读取res/raw 下文件
    private void readRaw(Context context) {
        try {
            //获取文件中的内容
            InputStream inputStream=context.getResources().openRawResource(R.raw.phone);
            //将文件中的字节转换为字符
            InputStreamReader isReader=new InputStreamReader(inputStream,"GBK");
            //使用bufferReader去读取字符
            BufferedReader reader=new BufferedReader(isReader);
            String out="";
            try {
                while((out=reader.readLine())!=null){
                    Log.d("从raw文件夹中读取到的数据:",out);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //读取 assets 下文件

    private void readAsset(Context context ,String filename) {
        try{
            InputStream inputStream = context.getResources().getAssets().open(filename);
            InputStreamReader isReadr = new InputStreamReader(inputStream,"gbk");
            BufferedReader reader = new BufferedReader(isReadr);
            String out = "";
            while((out=reader.readLine())!=null){
                Log.d("读取到的文件信息:",out);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
