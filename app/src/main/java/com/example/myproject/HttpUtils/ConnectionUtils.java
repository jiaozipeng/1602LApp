package com.example.myproject.HttpUtils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionUtils  {

    public static ConnectionUtils connectionUtils;
    private boolean isConnectivit;
    public static ConnectionUtils getInstence(){

         connectionUtils = new ConnectionUtils();
        return ConnectionUtils.connectionUtils;
    }

    public boolean isMash(Context context){

        //得到系统的服务
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //得到网络
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        //判断是否有网络
        if(networkInfo != null && networkInfo.isConnected()){

          isConnectivit=false;
        }else{

            isConnectivit=true;
        }

        return isConnectivit;


    }
}
