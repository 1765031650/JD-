package com.bw.arp.jd.ShoppingCar.MyDingdan;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bw.arp.jd.R;
import com.bw.arp.jd.ShoppingCar.MyDingdan.Fragments.Fragment01;
import com.bw.arp.jd.ShoppingCar.MyDingdan.Fragments.Fragment02;
import com.bw.arp.jd.ShoppingCar.MyDingdan.Fragments.Fragment03;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DingdanListActivity extends AppCompatActivity {

    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private List<Fragment> list;
    private Fragment01 fragmen1;
    private Fragment02 fragmen2;
    private Fragment03 fragmen3;
    private String[] tabs ={"待支付","已支付","已取消"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingdan_list);
        ButterKnife.bind(this);
        initData();
        mViewpager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        mTablayout.setTabMode(TabLayout.MODE_FIXED);
        mTablayout.setupWithViewPager(mViewpager);
    }

    private void initData() {
        list = new ArrayList<>();
        fragmen1 = new Fragment01();
        fragmen2 = new Fragment02();
        fragmen3 = new Fragment03();
        list.add(fragmen1);
        list.add(fragmen2);
        list.add(fragmen3);
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter{

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
}
