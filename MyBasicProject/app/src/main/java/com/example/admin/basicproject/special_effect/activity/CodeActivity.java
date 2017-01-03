package com.example.admin.basicproject.special_effect.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.basicproject.R;

public class CodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
    }


    public void toastShowView(){
        Context context = getApplicationContext();
        String msg = "Cheers!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,msg,duration);
        toast.setGravity(Gravity.TOP,0,0);

        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);

        TextView textView = new TextView(context);

        textView.setText(msg);

        int lHeight = LinearLayout.LayoutParams.MATCH_PARENT;
        int lWidth = LinearLayout.LayoutParams.WRAP_CONTENT;

        ll.addView(textView,new LinearLayout.LayoutParams(lHeight,lWidth));

        ll.setPadding(40,50,0,0);

        toast.setView(ll);
        toast.show();
    }
    public void createNotificationManager(){
        String svcName = Context.NOTIFICATION_SERVICE;
        NotificationManager notificationManager;
        notificationManager = (NotificationManager)getSystemService(svcName);
    }

    public void createNotification(){
        int icon = R.drawable.icon_0;
        String tickerText = "Notification";
        long when = System.currentTimeMillis();

        Notification notification = new Notification(icon,tickerText,when);


        Context context = getApplicationContext();
        //在扩展的状态窗口中显示的文本；
        String expandedText = "Extended status text";
        //展开的状态的标题
        String expandedTitle = "Notification Title";
      /*  //当单击扩展的文本的时候，启动一个活动的Intent；
        Intent intent = new Intent(this,MyActiity.class);
        PendingIntent launchIntent = PendingIntent.getActivity(context,0,intent,0);
        notification.setLatestEventInfo(context,expandedTitle,expandedText,launchIntent);*/
    }

    public void setNotification(){

    }
}
