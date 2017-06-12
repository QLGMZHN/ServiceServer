package com.example.king.movies_qgmzhn;

import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import android.os.Handler;

/**
 * Created by king on 2017/6/11.
 */
public class movieAdapter extends BaseAdapter {
        private List<movieInfo> mData;//定义数据。
        private LayoutInflater mInflater;//定义Inflater,加载我们自定义的布局。

        /*
        定义构造器，在Activity创建对象Adapter的时候将数据data和Inflater传入自定义的Adapter中进行处理。
        */
        public movieAdapter(LayoutInflater inflater,List<movieInfo> data){
            mInflater = inflater;
            mData = data;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup viewGroup) {
            //获得ListView中的view
            View viewmovie = mInflater.inflate(R.layout.movieinfo,null);
            //获得电影对象
            final movieInfo movieInfo = mData.get(position);
            //获得自定义布局中每一个控件的对象。
            final ImageView imageP = (ImageView) viewmovie.findViewById(R.id.movieimage);
            TextView name = (TextView) viewmovie.findViewById(R.id.name);
            TextView duration = (TextView) viewmovie.findViewById(R.id.duration);
            TextView director = (TextView) viewmovie.findViewById(R.id.director);
            TextView score = (TextView) viewmovie.findViewById(R.id.score);
            TextView brief = (TextView) viewmovie.findViewById(R.id.brief);
            Button price = (Button) viewmovie.findViewById(R.id.price);
            //将数据一一添加到自定义的布局中。
            //图片放的是连接
             final Handler handle = new Handler() {
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 0:
                            System.out.println("111");
                            Bitmap bmp=(Bitmap)msg.obj;
                            imageP.setImageBitmap(bmp);
                            break;
                    }
                };
            };
            new Thread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    Bitmap bmp = getURLimage(movieInfo.getImage_url());
                    Message msg = new Message();
                    msg.what = 0;
                    msg.obj = bmp;
                    System.out.println("000");
                    handle.sendMessage(msg);
                }
            }).start();
            //getURLimage
            //
            name.setText(movieInfo.getMovie_name());
            director.setText(movieInfo.getDirector());
            duration.setText(movieInfo.getDuration());
            score.setText(movieInfo.getScore());
            price.setText(movieInfo.getPrice());
            brief.setText(movieInfo.getBrief());

           /* imagePhoto.setImageResource(student.getImag());
            name.setText(student.getName());
            age.setText(student.getAge());
            sex.setText(student.getSex());
            hobby.setText(student.getHobby());*/

            return viewmovie ;
        }
    public Bitmap getURLimage(String url) {
        Bitmap bmp = null;
        try {
            URL myurl = new URL(url);
            // 获得连接
            HttpURLConnection conn = (HttpURLConnection) myurl.openConnection();
            conn.setConnectTimeout(6000);//设置超时
            conn.setDoInput(true);
            conn.setUseCaches(false);//不缓存
            conn.connect();
            InputStream is = conn.getInputStream();//获得图片的数据流
            bmp = BitmapFactory.decodeStream(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmp;
    }
}
