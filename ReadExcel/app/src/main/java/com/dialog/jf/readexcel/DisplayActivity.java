package com.dialog.jf.readexcel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.dialog.jf.readexcel.adapter.MyGridViewAdapter;
import com.dialog.jf.readexcel.bean.Book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/1/9.
 */

public class DisplayActivity extends Activity {
    String[] title = new String[]{"第一册","第二册","第三册","第四册","第五册","第六册",};
    private List<String> titleLists = new ArrayList<String>();

    private GridView id_grid_view;
    private MyGridViewAdapter myGridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        initView();
    }

    private void initView() {

        id_grid_view = (GridView) findViewById(R.id.id_grid_view);
        for (int i = 0 ;i<title.length;i++){
            titleLists.add(title[i]);
        }

        myGridViewAdapter = new MyGridViewAdapter(DisplayActivity.this,titleLists);

        id_grid_view.setAdapter(myGridViewAdapter);
        id_grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gotoDetailScreen(position);
            }
        });
    }

    private void gotoDetailScreen(int i){
        ArrayList<Book> listObj = getData(i);
        Intent intent = new Intent(DisplayActivity.this,MainActivity.class);
        intent.putExtra("books", (Serializable) listObj);
        startActivity(intent);
    }
    private ArrayList<Book> getData(int i){
        ArrayList<Book> books = new ArrayList<Book>();
        books.add( getOnePartBook(i));
        books.add(getTwoPartBook(i));
        return books;
    }
    private Book getOnePartBook(int i){ //生成单数文件名称 1_1.txt ;2_1.txt
        Book book = new Book();
        String left = Integer.toString(i+1);
        book.setTitle(titleLists.get(i));
        book.setTxt(left+"_1.txt");
        //mp3
        return book;
    }
    private Book getTwoPartBook(int i){ //生成双数文件名称 1_2.txt ;2_2.txt
        Book book = new Book();
        String left = Integer.toString(i+1);
        book.setTitle(titleLists.get(i));
        book.setTxt(left+"_2.txt");
        //mp3
        return book;
    }
}
