package com.dialog.jf.readexcel;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dialog.jf.readexcel.bean.Book;
import com.dialog.jf.readexcel.custom.TitleView;
import com.dialog.jf.readexcel.view.MainView;
import com.dialog.jf.readexcel.presenter.MainPresenter;
import com.dialog.jf.readexcel.presenter.MainPresenterImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener ,MainView {
   private TextView id_show_txt;
    private MainPresenter mainPresenter;
    MediaPlayer player = null;
    boolean m2Click = true;
    private Button startBtn ;
    private Button nextBtn;
    private ArrayList<Book> bookArrayList;
    private Book currentBook;
    private Boolean isShowNext = false;
    private Button leftButton;
    private TextView titleText;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bookArrayList =  (ArrayList<Book>) getIntent().getSerializableExtra("books");
        context = this;
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenterImpl(this,this);
        titleText = (TextView) findViewById(R.id.title_text);
        leftButton = (Button)findViewById(R.id.button_left);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destory();
            }
        });
        id_show_txt = (TextView) findViewById(R.id.id_show_txt);
        id_show_txt.setMovementMethod(ScrollingMovementMethod.getInstance());
        startBtn = (Button) findViewById(R.id.startMp3) ;
        startBtn.setOnClickListener(this);
        nextBtn = (Button) findViewById(R.id.next);
        nextBtn.setOnClickListener(this);
        currentBook = bookArrayList.get(0);

        initData();
        read();
        playMp3();
    }
    private void destory(){
        player.stop();
        player = null;
        this.finish();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        destory();
    }
    private void playMp3() {
        player = null;
        AssetManager am = getAssets();
        try {
            AssetFileDescriptor afd = am.openFd(currentBook.getMp3());
            player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),
                    afd.getStartOffset());
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.stop();
                    mp.release();
                    startBtn.setText(context.getResources().getString(R.string.start_str));
                }
            });
            player.prepare();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    private void initData(){
        titleText.setText(currentBook.getTitle());
    }

    private void read(){
      mainPresenter.readAssetsTxt(currentBook.getTxt());//"1_1.txt"
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startMp3:
                startMp3();
                break;
            case R.id.next:
                showCurrentBook();
                break;
        }
    }
    private void startMp3(){
        if(m2Click){
            player.start();
            startBtn.setText(context.getResources().getString(R.string.pause_str));
        }
        else{
            player.pause();
            startBtn.setText(context.getResources().getString(R.string.start_str));
        }
        m2Click = !m2Click;
    }
    private void showCurrentBook(){

        isShowNext = !isShowNext;
        if(isShowNext){
            currentBook = bookArrayList.get(1);
            nextBtn.setText(getResources().getString(R.string.previous_page));
        }else{
            currentBook = bookArrayList.get(0);
            nextBtn.setText(getResources().getString(R.string.next));
        }
        initData();
        read();

        playNextMp3();
        playMp3();

    }
    private void playNextMp3() {
        player.stop();
        startBtn.setText("开始");
        m2Click = !m2Click;
    }

    @Override
    public void showTxt(String v) {
        id_show_txt.setText(v);
    }
}
