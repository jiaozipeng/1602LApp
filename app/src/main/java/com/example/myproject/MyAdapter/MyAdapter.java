package com.example.myproject.MyAdapter;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myproject.Application.Myapplication;
import com.nostra13.universalimageloader.core.ImageLoader;



public class MyAdapter extends PagerAdapter{

    private Context context;
    private String [] image;
    private Handler handler;

    public MyAdapter(Context context, String[] image, Handler handler) {
        this.context = context;
        this.image = image;
        this.handler = handler;
    }

    @Override
    public int getCount() {
                return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //创建图片
        ImageView imageView = new ImageView(context);

        ImageLoader.getInstance().displayImage(image[position%image.length],imageView, Myapplication.getoptions());

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:

                        handler.removeCallbacksAndMessages(null);
                        break;
                    case MotionEvent.ACTION_MOVE:

                        handler.removeCallbacksAndMessages(null);
                        break;

                    case MotionEvent.ACTION_UP:

                        handler.sendEmptyMessageDelayed(0,2000);
                        break;
                    case MotionEvent.ACTION_CANCEL:

                        handler.sendEmptyMessageDelayed(0,2000);
                        break;
                }
                return false;
            }
        });

        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);
    }
}
