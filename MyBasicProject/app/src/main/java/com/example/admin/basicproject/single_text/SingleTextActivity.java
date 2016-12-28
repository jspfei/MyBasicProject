package com.example.admin.basicproject.single_text;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.basicproject.R;

/**
 * Created by admin on 2016/12/27.
 */

public class SingleTextActivity extends Activity {
    private TextView tv;
    private Button btn;
    private EditText et;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_single_text);
        findViews();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et.getText().toString();
                tv.setText("Hello,"+name+"!");
            }
        });
    }

    private void findViews() {
        tv = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        et = (EditText) findViewById(R.id.et);
    }
}
