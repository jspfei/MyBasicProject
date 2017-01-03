package com.example.admin.basicproject.io;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by admin on 2016/12/30.
 */

public class Text {

    public   int all(int num){
        int sum  = 0 ;
        for(int i = 1;i<=num;i++){
            sum = getN(i)+sum;
        }
        return sum;
    }
    public  int getN(int i){
        return (int) ((i+2)*(Math.pow(2,i)-1)*2);
    }


}
