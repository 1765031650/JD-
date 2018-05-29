package com.bw.arp.jd.Classify.XQing.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 * Created by ARP on 2018/4/18.
 */

public class MyBanner extends ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        com.nostra13.universalimageloader.core.ImageLoader imageLoader = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
        imageLoader.displayImage((String) path,imageView);
    }
}
