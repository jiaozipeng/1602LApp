package com.example.myproject.HttpUtils;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtils {

    public static HttpUtils httpUtils;
    private HttpInter httpInter;

    public static HttpUtils getintence(){

        if(httpUtils==null){
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }

    public void getdata(String url){
        Myasycntask myasycntask = new Myasycntask();
        myasycntask.execute(url);

    }

    class Myasycntask extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... strings) {


            DefaultHttpClient httpClient = new DefaultHttpClient();

            HttpGet get = new HttpGet(strings[0]);

            String s="";

            try {
                HttpResponse execute = httpClient.execute(get);
                if(execute.getStatusLine().getStatusCode()==200){
                    HttpEntity entity = execute.getEntity();
                    s = EntityUtils.toString(entity);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }


            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            httpInter.getjsondata(s);
        }
    }
    //创建接口
    public interface HttpInter{

        void getjsondata(String json);

    }

    //向外提供接口
    public  void setHttpListener(HttpInter httpInter){
        this.httpInter= httpInter;
    }
}
