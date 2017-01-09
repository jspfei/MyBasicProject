package com.dialog.jf.readexcel.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.dialog.jf.readexcel.view.MainView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by admin on 2017/1/9.
 */

public class MainPresenterImpl  implements MainPresenter{
    private Context context;
    private MainView mainView;
    public MainPresenterImpl(MainView mainView,Context context){
        this.mainView = mainView;
        this.context = context;
    }

    @Override
    public void readAssetsTxt(String filename) {
        ReadTxtTask readTxtTask = new ReadTxtTask(context);
        readTxtTask.execute(filename);
    }
    class ReadTxtTask extends AsyncTask<String,Void,String> {
        private Context context;
        ReadTxtTask(Context context){
            this.context = context;
        }
        /**
         * 运行在UI线程中，在调用doInBackground()之前执行
         */
        @Override
        protected void onPreExecute() {
            //Toast.makeText(context,"开始执行",Toast.LENGTH_SHORT).show();
        }
        /**
         * 后台运行的方法，可以运行非UI线程，可以执行耗时的方法
         */
        @Override
        protected String  doInBackground(String... params) {
            String txt = "";
            try{
                InputStream inputStream = context.getResources().getAssets().open(params[0]);
                InputStreamReader isReadr = new InputStreamReader(inputStream,"gbk");
                BufferedReader reader = new BufferedReader(isReadr);
                String out = "";
                while((out=reader.readLine())!=null){
                    Log.d("读取到的文件信息:",out);
                    txt = txt +out+"\n";
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return txt;
        }
        /**
         * 运行在ui线程中，在doInBackground()执行完毕后执行
         */
        @Override
        protected void onPostExecute(String values) {
            mainView.showTxt(values);
        }
    }


}
