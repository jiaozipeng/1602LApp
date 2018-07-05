package com.example.myproject.Application;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Environment;

import com.example.myproject.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.io.File;

public class Myapplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        String file = Environment.getExternalStorageDirectory().getPath();
        File file1 = new File(file);
        //进行框架初使化操作-全局配置
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(480, 800)//缓存图片最大的长和宽
                .threadPoolSize(2)//线程池的数量
                .threadPriority(4)
                .memoryCacheSize(5 * 1024 * 1024)//设置内存缓存区大小
                .diskCacheSize(20 * 1024 * 1024)//设置sd卡缓存区大小
                .diskCache(new UnlimitedDiskCache(file1))//自定义磁盘缓存目录
                .writeDebugLogs()//打印日志内容
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//给缓存的文件名进行md5加密处理
                .build();

        ImageLoader.getInstance().init(configuration);

    }

    public static DisplayImageOptions getoptions() {


        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//使用内存缓存
                .cacheOnDisk(true)//使用磁盘缓存
                .showImageOnLoading(R.mipmap.ic_launcher)//设置正在下载的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)//url为空或请求的资源不存在时
                .showImageOnFail(R.mipmap.ic_launcher)//下载失败时显示的图片
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片格式
                .displayer(new RoundedBitmapDisplayer(300))//设置圆角图片
                .build();


        return options;

    }
}