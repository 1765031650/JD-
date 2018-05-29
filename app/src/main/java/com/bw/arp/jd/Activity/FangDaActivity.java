package com.bw.arp.jd.Activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bw.arp.jd.R;
import com.bw.arp.jd.Utils.ZoomImageView;

import java.util.ArrayList;
import java.util.List;

public class FangDaActivity extends AppCompatActivity {
    private ViewPager viewPager;
    List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fang_da);



        /*viewPager =  findViewById(R.id.view_pager);*/
        viewPager = (ViewPager) findViewById(R.id.view_pager);


        list = getIntent().getStringArrayListExtra("list");
        Log.d("aa", "张" + list);

        if (list != null) {
            viewPager.setAdapter(new PagerAdapter() {

                @Override
                public Object instantiateItem(ViewGroup container, int position) {

                    ZoomImageView imageView = new ZoomImageView(FangDaActivity.this);

                    Glide.with(FangDaActivity.this).load(list.get(position)).into(imageView);

                    container.addView(imageView);
                    return imageView;
                }

                @Override
                public void destroyItem(ViewGroup container, int position, Object object) {
                    container.removeView((View) object);
                }

                @Override
                public int getCount() {
                    return list.size();
                }

                @Override
                public boolean isViewFromObject(View view, Object object) {
                    return view == object;
                }
            });


        }
    }
    }

