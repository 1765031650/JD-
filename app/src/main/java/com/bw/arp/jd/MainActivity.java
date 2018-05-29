package com.bw.arp.jd;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bw.arp.jd.Classify.Classify;
import com.bw.arp.jd.Find.Find;
import com.bw.arp.jd.HomePage.HomePage;
import com.bw.arp.jd.My.My;
import com.bw.arp.jd.ShoppingCar.ShoppingCar;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottombar)
    BottomTabBar mBottombar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mBottombar.init(getSupportFragmentManager())
                .setImgSize(40,20)
                .setFontSize(12)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.BLACK)
                .addTabItem("首页",R.drawable.shouye, HomePage.class)
                .addTabItem("分类",R.drawable.fenlei, Classify.class)
                .addTabItem("发现",R.drawable.faxian, Find.class)
                .addTabItem("购物车",R.drawable.shoppcar, ShoppingCar.class)
                .addTabItem("我的",R.drawable.wode, My.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });

    }
}
