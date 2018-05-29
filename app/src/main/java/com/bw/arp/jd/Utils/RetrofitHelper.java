package com.bw.arp.jd.Utils;

import android.content.Context;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



/**
 * Created by win764-1 on 2016/12/12.
 */

public class  RetrofitHelper {

    public Context mCntext;


   //初始化
   OkHttpClient interceptor = new OkHttpClient();


    //gson工厂
    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;
    //单例模式
    public static RetrofitHelper getInstance(Context context){
        if (instance == null){
            instance = new RetrofitHelper(context);
        }
        return instance;
    }
    private RetrofitHelper(Context mContext){
        mCntext = mContext;

        init();
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {
        //拦截器
        HttpLoggingInterceptor interceptor1 = new HttpLoggingInterceptor();
        interceptor1.setLevel(HttpLoggingInterceptor.Level.BASIC);
        //初始化retrofit
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .client(interceptor)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    public RetrofitService getServer(){
        return mRetrofit.create(RetrofitService.class);
    }

}
