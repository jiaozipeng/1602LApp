package com.example.myproject.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myproject.HttpUtils.HttpUtils;
import com.example.myproject.MyAdapter.MyAdapter;
import com.example.myproject.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentShow extends Fragment {

    private ViewPager viewpager1;
    private LinearLayout linear1;
    private List<ImageView> imglist= new ArrayList<>();
    private HttpUtils httpUtils;
    private String[] imags = {
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530147896&di=a108779183cfcf652d8b0e575326e3f1&imgtype=jpg&er=1&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F0bd162d9f2d3572ca715ccac8613632763d0c3cf.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1109914389,2791689143&fm=27&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530148203&di=f76108132220d420f20e670007cbfc7c&imgtype=jpg&er=1&src=http%3A%2F%2Ff10.topitme.com%2Fo042%2F10042332873d775e7b.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529553529652&di=b620d433ed2c93c296e1bf5434594399&imgtype=0&src=http%3A%2F%2Fgame.ahgame.com%2Fuploads%2Fallimg%2F171120%2F1-1G120102133.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529553594735&di=4133e5bb6f4221acbc673d0518e34ed6&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D1706558701%2C1505343713%26fm%3D214%26gp%3D0.jpg"
    };
    private int i;//接受当前的页


    private Handler handler = new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        //接受当前的位置
            i = viewpager1.getCurrentItem();
            //改变页的选中
            viewpager1.setCurrentItem(i+1);

            handler.sendEmptyMessageDelayed(1,2000);

    }
};
    private MyAdapter myAdapter;


    public static Fragment getinstence(String text){

        //创建fragment1
        FragmentShow fragmentShow = new FragmentShow();

        //创建bundle
        Bundle bundle = new Bundle();

        //添加至
        bundle.putString("text",text);

        //添加到fragment
        fragmentShow.setArguments(bundle);


        return fragmentShow;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragmentshow,container,false);

        viewpager1=view.findViewById(R.id.viewpager1);
        linear1=view.findViewById(R.id.linear1);



    //创建小圆点的方法
        IntiView();
        return view;

    }

    //创建小圆点的方法
    private void IntiView() {

        for (int i=0;i<imags.length;i++){
            ImageView imageView = new ImageView(getActivity());

            imageView.setImageResource(R.drawable.magselector);

            linear1.addView(imageView);

            imglist.add(imageView);
        }

        //设置默认选中的原点
        imglist.get(0).setSelected(true);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        if(arguments.get("text").equals("头条")) {

            myAdapter = new MyAdapter(getActivity(), imags, handler);
            viewpager1.setAdapter(myAdapter);

            //开始轮播延迟
            handler.sendEmptyMessageDelayed(1, 2000);

            // //滑动相对应的图片
            viewpager1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {

                    for (int k = 0; k < imglist.size(); k++) {
                        if (k == i % imglist.size()) {

                            imglist.get(k).setSelected(true);
                        } else {
                            imglist.get(k).setSelected(false);
                        }
                    }
                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });

        }else {
                linear1.setVisibility(View.GONE);
        }
    }
 @Override
  public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        //获取






    }
}
