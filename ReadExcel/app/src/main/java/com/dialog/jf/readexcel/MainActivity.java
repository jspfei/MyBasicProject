package com.dialog.jf.readexcel;

import android.app.Activity;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bookArrayList =  (ArrayList<Book>) getIntent().getSerializableExtra("books");

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

        //initPlay();
    }

    private void destory(){
        this.finish();
    }

    private void initPlay() {
        AssetManager am = getAssets();
        try {
            AssetFileDescriptor afd = am.openFd("a.mp3");
            player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor());
            player.setAudioStreamType(AudioManager.STREAM_RING);
           /* FileInputStream fis = new FileInputStream(new File("a.mp3"));
            player.setDataSource(fis.getFD());*/
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.stop();
                    mp.release();
                }
            });
            player.setLooping(false);
            player.prepare();
            player.setVolume(1f, 1f);

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
               /* if(m2Click){
                    player.start();
                    startBtn.setText("暂停");
                }
                else{
                    player.pause();
                    startBtn.setText("开始");
                }
                m2Click = !m2Click;*/
                break;
            case R.id.next:
                showNext();
                break;
        }
    }
    private void showNext(){
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
    }

    @Override
    public void showTxt(String v) {
        id_show_txt.setText(v);
    }
}
