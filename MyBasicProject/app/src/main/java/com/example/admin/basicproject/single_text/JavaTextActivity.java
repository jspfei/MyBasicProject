package com.example.admin.basicproject.single_text;

import java.util.Date;

/**
 * Created by admin on 2016/12/28.
 */

public class JavaTextActivity {
    private int date;
    public void JavaTextActivity(){

    }

    public String sayHello(int now , String user){
        date = now;
        String tall = "Hi,"+user+"."+getGreeting();
        return  tall;
    }

    public String getGreeting() {

        if(date == 1)
            return "Happy new year!";
        else if(date >1 && date<6)
            return "Good morning!";
        else if(date==6)
            return "Good afternoon!";
        else
            return "Good night!";
    }
}
