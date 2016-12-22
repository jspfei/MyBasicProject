package com.example.admin.basicproject.ui.utils;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

/**
 * Created by admin on 2016/12/22.
 */

public class SystemUtils {
    private static void scaleHeight(ViewGroup.LayoutParams params, int width){

        int oHeight = params.height;
        int oWidth = params.width;

        params.height = oHeight * (width/oWidth);
        params.width = width;

    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth(Activity activity){

        DisplayMetrics dm = new DisplayMetrics();

        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);

        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeight(Activity activity){

        DisplayMetrics dm = new DisplayMetrics();

        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);

        return dm.heightPixels;
    }
}
