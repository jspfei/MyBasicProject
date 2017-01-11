package com.dialog.jf.readexcel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dialog.jf.readexcel.bean.Book;
import com.dialog.jf.readexcel.custom.TitleView;
import com.dialog.jf.readexcel.view.MainView;
import com.dialog.jf.readexcel.presenter.MainPresenter;
import com.dialog.jf.readexcel.presenter.MainPresenterImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
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
    private Boolean isPlayComplete = false;
    private SeekBar id_process_bar;
    private int playIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bookArrayList =  (ArrayList<Book>) getIntent().getSerializableExtra("books");
        playIndex = Integer.valueOf( getIntent().getStringExtra("index"));
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

        id_process_bar = (SeekBar) findViewById(R.id.id_process_bar);
        id_process_bar.setOnSeekBarChangeListener(new ProcessBarListener());

        currentBook = bookArrayList.get(playIndex);

        initSetTitleData();
        read();
        playMp3();
    }

    //播放进度条

    class ProcessBarListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            // TODO Auto-generated method stub
            if (fromUser==true) {
                player.seekTo(progress);
                id_process_bar.setProgress(progress);
            }
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
        }
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
        AssetManager am = getAssets();
        try {
            AssetFileDescriptor afd = am.openFd(currentBook.getMp3());
            player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),
                    afd.getStartOffset());
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    startBtn.setText(context.getResources().getString(R.string.start_str));
                    handler.removeCallbacks(r);
                    id_process_bar.setProgress(0);
                    m2Click = true;
                }
            });
            player.prepare();
            id_process_bar.setProgress(0);
            int mMax=player.getDuration();
            id_process_bar.setMax(mMax);

        } catch(IOException e){
            e.printStackTrace();
        }
    }
    private void initSetTitleData(){
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
                showNextBook();
                break;
        }
    }
    private void startMp3(){

        isPlayComplete = false;

        if(m2Click){
            player.start();
            startBtn.setText(context.getResources().getString(R.string.pause_str));
           StrartbarUpdate();
        }
        else{
            player.pause();
            startBtn.setText(context.getResources().getString(R.string.start_str));

        }
        m2Click = !m2Click;
    }
    private void showNextBook(){

        isShowNext = !isShowNext;
        if(isShowNext){
            currentBook = bookArrayList.get(1);
            nextBtn.setText(getResources().getString(R.string.previous_page));

        }else{
            currentBook = bookArrayList.get(0);
            nextBtn.setText(getResources().getString(R.string.next));

        }

        initSetTitleData();
        read();
        playNextMp3();
        playMp3();

    }
    private void playNextMp3() {
        player.pause();
        startBtn.setText(context.getResources().getString(R.string.start_str));
        m2Click = true;
    }

    Handler handler=new Handler();
    public void StrartbarUpdate(){
        handler.post(r);
    }
    Runnable r=new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            int CurrentPosition=player.getCurrentPosition();
            int mMax=player.getDuration();
            id_process_bar.setMax(mMax);
            id_process_bar.setProgress(CurrentPosition);
            handler.postDelayed(r, 100);
        }
    };
    @Override
    public void showTxt(String v) {
        id_show_txt.setText(v);
    }
}
