package com.example.admin.basicproject.litepal;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.basicproject.R;
import com.example.admin.basicproject.litepal.model.Comment;
import com.example.admin.basicproject.litepal.model.News;
import com.example.admin.basicproject.litepal.utils.MySQLiteHelper;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.System.in;

/**
 * Created by admin on 2017/1/5.
 */

public class LitePalActivity extends Activity{
    private static final String TAG = "LitePalActivity";
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_lite_pal);

        litePalCreateDataView();

      //  saveOneData();

        saveAllToOneData();
        //listSaveData();
        //updateDataWay2();
       // updateAllData();

       // updateData(3);
       // deleteData();
        //deleteAllData(1);
     /*   litePalQuery(1);
        litePalQuery(2);
        litePalQuery(3);
        litePalQueryLists(1);

        litePalQueryLists(2);

        litePalQueryLists(3);*/
/*
        listePalOneToOne(1);
        listePalOneToOne(2);
        listePalOneToOne(3);
        listePalOneToOne(4);
        listePalOneToOne(5);*/
        litePalRadicalQuery();
        LitePalNativeQuery();
    }

    private void litePalCreateDataView() {
        SQLiteDatabase db = Connector.getDatabase();
    }
    private void saveOneData(){
        News news = new News();
        news.setTitle("这是一条新闻标题");
        news.setContent("这是一条新闻内容");
        news.setPublishDate(new Date());
        Log.d(TAG,"     id   "+news.getId());
        news.save();
        Log.d(TAG,"     id   "+news.getId());
        if(news.save()){
            Toast.makeText(this,"save success",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"save fail",Toast.LENGTH_SHORT).show();
        }

    }
    private News saveAllToOneData(){
        Comment comment1 = new Comment();
        comment1.setContent("nice comment!");
        comment1.setPublishDate(new Date());
        comment1.save();
        Comment comment2 = new Comment();
        comment2.setPublishDate(new Date());
        comment2.save();
        News  news = new News();
        news.getCommentList().add(comment1);
        news.getCommentList().add(comment2);
        news.setTitle("this is two title");
        news.setContent("this is two comment");
        news.setPublishDate(new Date());
        news.setCommentCount(news.getCommentList().size());
        news.save();

        return news;
    }
    private void listSaveData(){
        List<News> newsList = new ArrayList<News>();
        for(int i = 0;i<4 ;i++){
            News news = saveAllToOneData();
            news.setTitle(news.getTitle()+" "+i);
        }

        DataSupport.saveAll(newsList);
    }
    public void updateData(int i){
        //对象修改
        switch (i){
            case 1:
                News updateNews = new News();
                updateNews.setTitle("Iphone6");
                updateNews.update(2);
                break;
            case 2:
                News news = new News();
                news.setTitle("iphone7 Plus");
                news.updateAll("title = ? and commentcount > ?","iphone7" ,"0"); //所有title 是 iphone7 并且评论数量>0 的 改为 iphone7 Plus
                break;
            case 3:
                News news1 = new News();
                news1.setToDefault("commentCount");
                news1.updateAll("id = ?","3");//将id 3 的数量更新为 0
                break;
            default:
                break;
        }


    }
    public void updateDataWay2(){
        ContentValues values = new ContentValues();
        values.put("title","iphone5");
        DataSupport.update(News.class,values,3);
    }
    public void updateAllDataByWhere(){
        ContentValues values = new ContentValues();
        values.put("title","iphone7");
        DataSupport.updateAll(News.class,values,"title = ? and commentcount > ?","iphone5","0");//有几个 ？ ，在条件语句后就有几个参数 逐个对应 ？

    }
    public void updateAllData(){
        ContentValues values = new ContentValues();
        values.put("title","iphone7");
        DataSupport.updateAll(News.class,values );//没有条件句，就是修改全部
    }
    private void deleteData(){
        int deleteCount =    DataSupport.delete(News.class,2);//删除ID = 2 的news  返回总共删除的 记录 。包括 ID = 2 的外键 如 comment 中news_id = 2 的数据
        Log.d("TAG","delete count is "+deleteCount);
    }
    private void deleteAllData(int i){

        switch (i){
            case 1: // 条件删除数据
                DataSupport.deleteAll(News.class,"title = ? and commentcount = ?" ,"iphone7 Plus","0");
                break;
            case 2:  //删除表中全部数据
                DataSupport.deleteAll(News.class);
                break;
            default:
                break;
        }
    }
    private void litePalQuery(int i){
        Log.d("TAG","------------------------litePalQuery---------------------------");
        News news = null;
        switch (i){
            case 1: //根据ID查询
                news = DataSupport.find(News.class,1);//查詢 id =1
                break;
            case 2://查询 第一条记录
                news = DataSupport.findFirst(News.class);
                break;
            case 3://查询 最后一条数据
                news = DataSupport.findLast(News.class);
                break;
        }

        Log.d("TAG","id  "+news.getId());
        Log.d("TAG","title  "+news.getTitle());
    }
    private void litePalQueryLists(int i){
        Log.d("TAG","------------------------litePalQueryLists---------------------------");
        List<News> newsList = null;
        switch (i){
            case 1://查询指定的多个ID
                newsList = DataSupport.findAll(News.class,1,3,4,5);
                break;
            case 2://ID 封装到数组中查询
                long[] ids = new long[]{1,3,4,5};
                newsList = DataSupport.findAll(News.class,ids);
                break;
            case 3://查询所有的数据
                newsList = DataSupport.findAll(News.class);
                break;
            default:
                break;
        }
        Log.d("TAG","-size----------  "+newsList.size());
        for(News news : newsList){
            Log.d("TAG","id  "+news.getId());
            Log.d("TAG","title  "+news.getTitle());
        }
    }
    private void listePalOneToOne(int i){ //连缀查询
        Log.d("TAG","------------------------litePalQueryLists---------------------------");
        List<News> newsList = null;
        switch (i) {
            case 1://条件查询
                newsList = DataSupport.where("commentcount > ?","0").find(News.class);
                break;
            case 2://自定义返回的列
                newsList = DataSupport.select("title","content")
                        .where("commentcount > ?","0").find(News.class);
                break;
            case 3:// 按照 发布时间排序  asc 正序排序，desc道墟排序
                newsList = DataSupport.select("title","content")
                        .where("commentcount > ?","0")
                        .order("publishdate desc").find(News.class);
                break;
            case 4: //限制返回 前 3条数据
                newsList = DataSupport.select("title","content")
                        .where("commentcount > ?","0")
                        .order("publishdate desc").limit(3).find(News.class);
                break;
            case 5://设置偏移量 来到分页显示   offset(3),表示显示 4,5，6三条  ;offset(6) 表示显示 7,8,9三条
                newsList = DataSupport.select("title","content")
                        .where("commentcount > ?","0")
                        .order("publishdate desc").limit(3).offset(3).find(News.class);
                break;
            default:
                break;
        }
        Log.d("TAG","-size----------  "+newsList.size());
        for(News news : newsList){
            Log.d("TAG","id  "+news.getId());
            Log.d("TAG","title  "+news.getTitle());
        }
    }

    public void litePalRadicalQuery(){ //激进查询 ，不推荐使用， 可以查找关联表数据

        Log.d("TAG","------------------------litePalRadicalQuery---------------------------");
        News news = DataSupport.find(News.class, 1, true);
        Log.d("TAG","id  "+news.getId());
        Log.d("TAG","title  "+news.getTitle());
        List<Comment> commentList = news.getCommentList();
        Log.d("TAG","-size----------  "+commentList.size());
        for(Comment comment : commentList){
            Log.d("TAG","id  "+comment.getId());
            Log.d("TAG","title  "+comment.getContent());
        }
        //直接用懒加载模式读取关联表数据

       /* public class News extends DataSupport{

            public List<Comment> getComments() {
                return DataSupport.where("news_id = ?", String.valueOf(id)).find(Comment.class);
            }

        }*/
    }
    public void LitePalNativeQuery(){ //原生查询
        Log.d("TAG","------------------------litePalRadicalQuery---------------------------");
        Cursor cursor = DataSupport.findBySQL("select * from news where commentcount>?", "0");


        List<News> newsList = new ArrayList<News>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String content = cursor.getString(cursor.getColumnIndex("content"));
                Date publishDate = new Date(cursor.getLong(cursor.getColumnIndex("publishdate")));
                int commentCount = cursor.getInt(cursor.getColumnIndex("commentcount"));
                News news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setContent(content);
                news.setPublishDate(publishDate);
                news.setCommentCount(commentCount);
                newsList.add(news);
            } while (cursor.moveToNext());
        }

        Log.d("TAG","-size----------  "+newsList.size());
        for(News news : newsList){
            Log.d("TAG","id  "+news.getId());
            Log.d("TAG","title  "+news.getTitle());
        }
    }


    /***
     *
     * sqlite 处理数据库
     * */
    private void sqLiteOpenHelperCreateData(){
        //添加一个新表 comment  版本升级 2
        SQLiteOpenHelper dbHelper = new MySQLiteHelper(this, "demo.db", null, 2);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }
    public void sqlTo3(){
        //comment 中添加一列 版本升级3
        SQLiteOpenHelper dbHelper = new MySQLiteHelper(this, "demo.db", null, 3);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
    }
    public void sqlAdddata(){
        SQLiteOpenHelper dbHelper = new MySQLiteHelper(this, "demo.db", null, 3);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", "这是一条新闻标题");
        values.put("content", "这是一条新闻内容");
        values.put("publishdate", System.currentTimeMillis());
        long id = db.insert("news", null, values);

    }
    private void sqlUptate(){
        SQLiteOpenHelper dbHelper = new MySQLiteHelper(this, "demo.db", null, 3);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", "今日iPhone6发布");
        db.update("news", values, "id = ?", new String[] {"2"});
    }
    private void sqlDelete(){
        SQLiteOpenHelper dbHelper = new MySQLiteHelper(this, "demo.db", null, 3);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("news", "commentcount = ?", new String[] {"0"});
    }
    private void sqlQuery(){
        SQLiteOpenHelper dbHelper = new MySQLiteHelper(this, "demo.db", null, 3);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("news", null, "commentcount>?", new String[]{"0"}, null, null, null);
        List<News> newsList = new ArrayList<News>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String content = cursor.getString(cursor.getColumnIndex("content"));
                Date publishDate = new Date(cursor.getLong(cursor.getColumnIndex("publishdate")));
                int commentCount = cursor.getInt(cursor.getColumnIndex("commentcount"));
                News news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setContent(content);
                news.setPublishDate(publishDate);
                news.setCommentCount(commentCount);
                newsList.add(news);
            } while (cursor.moveToNext());
        }
    }
}
