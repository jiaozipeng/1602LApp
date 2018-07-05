package com.example.myproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.myproject.Fragment.FragmentFour;
import com.example.myproject.Fragment.FragmentOne;
import com.example.myproject.Fragment.FragmentThree;
import com.example.myproject.Fragment.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private ViewPager pager;
    private List<Fragment> list;
    private RadioGroup group;

    private PopupWindow popup;
    private TextView getdj;
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getAdpter();
        //获取资源ID
        getdj= findViewById(R.id.getdj);
        imageview= findViewById(R.id.imageview);


        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,LoginActivity.class);
                startActivity(intent);
            }
        });





        View view= View.inflate(Main2Activity.this,R.layout.popup,null);

        popup= new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        popup.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        popup.setFocusable(true);
        getdj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup.showAsDropDown(view);
            }
        });
    }
    public  void  getAdpter(){
        //获取资源ID
        pager= findViewById(R.id.pager);
        group= findViewById(R.id.group);

        //获取数据源
        list= new ArrayList<Fragment>();
        list.add(new FragmentOne());
        list.add(new FragmentTwo());
        list.add(new FragmentThree());
        list.add(new FragmentFour());



        //创建适配器



        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return  list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                switch (i){
                    case 0:
                        group.check(R.id.button1);
                        break;

                    case 1:
                        group.check(R.id.button2);
                        break;

                    case 2:
                        group.check(R.id.button3);
                        break;

                    case 3:
                        group.check(R.id.button4);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){

                    case R.id.button1:
                        pager.setCurrentItem(0);
                        break;


                    case R.id.button2:
                        pager.setCurrentItem(1);
                        break;



                    case R.id.button3:
                        pager.setCurrentItem(2);
                        break;



                    case R.id.button4:
                        pager.setCurrentItem(3);
                        break;
                }
            }
        });
    }


}
