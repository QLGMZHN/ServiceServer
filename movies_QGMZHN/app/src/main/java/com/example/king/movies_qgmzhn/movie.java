package com.example.king.movies_qgmzhn;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by king on 2017/6/11.
 */
public class movie extends AppCompatActivity {
    //定义数据
    private List<movieInfo> mData;
    //定义ListView对象
    private ListView mListViewArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);
        //为ListView对象赋值
        mListViewArray = (ListView) findViewById(R.id.movielist);
        LayoutInflater inflater =getLayoutInflater();
        //初始化数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                try {
                    sendRequestWithHttpURLConnection urlcon = new sendRequestWithHttpURLConnection();
                    String url = "http://sysuxf.pythonanywhere.com/movie/";
                    String result = urlcon.getURL(url);
                    Log.i("resu！！！！！！！！:",result);
                    //测试成功，此处的result是json数据
                    jsonToObj(result);
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
        }).start();
        //创建自定义Adapter的对象
        movieAdapter adapter = new movieAdapter(inflater,mData);
        //将布局添加到ListView中
        mListViewArray.setAdapter(adapter);}


    public void jsonToObj(String jsonStr) throws Exception {
        JSONObject jsonObject = new JSONObject(jsonStr);
        String count = jsonObject.getString("count");
        Log.i("count:",count);
        for (int i = 0; i <Integer.parseInt(count);++i){
            //提取每个电影的信息
            String single = jsonObject.getString("results");
            //Log.i("results:",single.substring(1,single.length()-1));
            single = single.substring(1,single.length()-1);
            JSONObject movie = new JSONObject(single);
            //提取电影名字
            String movie_name = jsonObject.getString("mName");
            //导演名字
            String director = jsonObject.getString("director");
            //时长
            String duration = jsonObject.getString("duration");
            //评分
            String score = jsonObject.getString("score");
            //简介
            String brief = jsonObject.getString("brief");
            //价格
            String price = jsonObject.getString("price");
            //图片地址
            String image_url = jsonObject.getString("image_urls");
            //评论信息
            String comments = jsonObject.getString("comment");
            comments = comments.substring(1,comments.length()-1);
            String commentsarray[] = comments.split(",");
            Log.i("image:",image_url);
            movieInfo movieInfo = new movieInfo(movie_name,director, duration, score,brief, price,image_url);
            mData.add(movieInfo);
        }
    }
}