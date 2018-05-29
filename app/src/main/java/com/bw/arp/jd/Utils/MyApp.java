package com.bw.arp.jd.Utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by Administrator on 2017/10/11 0011.
 */

public class MyApp extends Application {

    private static MyApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化二维码
        ZXingLibrary.initDisplayOpinion(this);
        mInstance=this;
        Fresco.initialize(this);
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoaderConfiguration defaultcof = ImageLoaderConfiguration.createDefault(getApplicationContext());
        ImageLoader.getInstance().init(build);

    }
    public static MyApp getInstance(){
        return mInstance;
    };

}
