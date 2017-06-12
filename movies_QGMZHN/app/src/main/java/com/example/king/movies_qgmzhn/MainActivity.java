package com.example.king.movies_qgmzhn;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class MainActivity extends AppCompatActivity {
    EditText user;
    EditText email;
    EditText pass1;
    EditText pass2;
    String usertext;
    String emailtext;
    String pass1text;
    String pass2text;
    //String urlPath = "http://sysuxf.pythonanywhere.com/register/";
//String urlPath = "http://sysuxf.pythonanywhere.com/register/?username=111&email=111&password=111&password2=111";;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取注册用户信息
        user = (EditText)findViewById(R.id.username);
        email = (EditText)findViewById(R.id.email);
        pass1 = (EditText)findViewById(R.id.password);
        pass2 = (EditText)findViewById(R.id.password2);
        Button register = (Button)findViewById(R.id.register);
        //已有账户登录
        final TextView login = (TextView)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
                finish();
            }
        });
        //注册
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,movie.class);
                startActivity(intent);
                finish();

                usertext = user.getText().toString();
                emailtext = email.getText().toString();
                pass1text = pass1.getText().toString();
                pass2text = pass2.getText().toString();
                sendRequestWithHttpURLConnection urlcon = new sendRequestWithHttpURLConnection();
                final String param = "username="+usertext+"&email="+emailtext+"&password="+pass1text+"&password2="+pass2text;
            }
        });
    }

    //用handler更新UI
    /*private Handler handler = new Handler(){
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    try {
                        //jsonToObj(message.obj.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    };
      private void jsonToObj(String jsonStr) throws Exception {
        //PdfRenderer.Page page = new PdfRenderer.Page();
        //String str = "fuck";
        //Log.i("entering", str);
        JSONObject jsonObject = new JSONObject(jsonStr);
        //未来两小时天气预报
        String summary = "实时天气：" + jsonObject.getString("summary");
        //实时温度
        String temp = "实时温度："+jsonObject.getString("temp") + "℃";
        //天气状况
        String skycon = "空气状况："+ jsonObject.getString("skycon");
        //Log.i("skycon", skycon);
        //Log.i("summary:", summary);
    }*/
    //处理url请求的类


}
