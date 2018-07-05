package com.example.myproject;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

public class WindouPopup extends AppCompatActivity {

    private PopupWindow popup;
    private TextView getdj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentshow);


        //获取ID资源

        getdj= findViewById(R.id.getdj);
        View view= View.inflate(WindouPopup.this,R.layout.popup,null);

        popup= new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        popup.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        popup.setFocusable(false);
        getdj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup.showAsDropDown(view);
            }
        });


    }


}
