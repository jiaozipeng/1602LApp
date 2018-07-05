package com.example.myproject.Fragment;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myproject.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment {



    private ViewPager viewpager;
    private HorizontalScrollView horizontal;
    private LinearLayout linear;
    private String[] titles = {"头条", "娱乐", "科技", "信息", "八卦", "北京", "上海", "天津","重庆", "大大燕网" };
    private List<TextView> lists;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_fragment_one, container, false);

        //获取资源ID
        viewpager = view.findViewById(R.id.viewpager);
        horizontal = view.findViewById(R.id.horizontal);
        linear = view.findViewById(R.id.linear);


        //创建数据源
        lists = new ArrayList<>();

        //for循环
        for (int i = 0; i < titles.length; i++) {

            //创建个文本
            final TextView textView = new TextView(getActivity());
            //获取数组中的每个位置
            textView.setText(titles[i]);
            //设置字体的大小
            textView.setTextSize(25);
            //获取数组的ID
            textView.setId(i + 1000);

            //设置的监听
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   int id=   view.getId();
                   viewpager.setCurrentItem(id-1000);
                }
            });
            if (i == 0) {
                textView.setTextColor(Color.RED);
            } else {
                textView.setTextColor(Color.BLACK);
            }

            //创建一个layout
            LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layout.setMargins(50, 10, 50, 10);
            linear.addView(textView,layout);
            lists.add(textView);


        }
        //创建适配器
        viewpager.setAdapter(new myAdapter(getActivity().getSupportFragmentManager()));
        //设置viewpager监听
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                for (int k = 0; k < lists.size(); k++) {
                    if (i == k) {
                        lists.get(k).setTextColor(Color.RED);
                    } else {
                        lists.get(k).setTextColor(Color.BLACK);
                    }
                }

                TextView textView = lists.get(i);
                //这是每次滑动的间距
                int width = textView.getWidth() + 10;

                //让scrollView滑动   滑动距离是textview之间的间距

                horizontal.scrollTo(width * i, 0);
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });




        return view;


    }






    class myAdapter extends FragmentPagerAdapter{

        public myAdapter(FragmentManager fragment){
            super(fragment);
        }

        @Override
        public Fragment getItem(int i) {
            return FragmentShow.getinstence(lists.get(i).getText().toString());
        }

        @Override
        public int getCount() {
            return lists.size();
        }
    }




}
