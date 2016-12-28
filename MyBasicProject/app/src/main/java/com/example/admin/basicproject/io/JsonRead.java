package com.example.admin.basicproject.io;

import android.content.Context;

import com.example.admin.basicproject.bean.JsonBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by admin on 2016/12/27.
 */

public class JsonRead {
    public static void readAssets(Context context) {
        System.out.print("----------------ssssssssssss");

        String strData = null;
        try {
            InputStream inputStream = context.getAssets().open("json01");
            int size = inputStream.available();
            int len = -1;
            byte buf[] = new byte[size];
            inputStream.read(buf);
            inputStream.close();
            strData = new String(buf);

        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println("...............json.................." +strData);
        JsonBean foo = new Gson().fromJson(strData, JsonBean.class);
        System.out.println("...............json.................." + foo.getName());
        System.out.println("...............json.................." + foo.getAddress().getCity());
        System.out.println("...............json.................." + foo.getAge());
    }
}
