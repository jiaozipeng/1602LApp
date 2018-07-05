package com.example.myproject;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int i =5;
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText(msg.what+"S");
            if(i==0){
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取资源ID
        textView = findViewById(R.id.textview);

        new Thread(){
            @Override
            public void run() {
                super.run();
                while (i>=0){
                    i--;
                    try {
                        sleep(1000);

                        handler.sendEmptyMessage(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
    }
}
