package com.bw.arp.jd.Find;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.arp.jd.Find.DuanZiXQ.DuanziXQActivity;
import com.bw.arp.jd.Find.DuanZiXQ.presenter.DuanziXQPresenter;
import com.bw.arp.jd.Find.adapter.MyDuanZiAdapter;
import com.bw.arp.jd.Find.bean.DuanziBean;
import com.bw.arp.jd.Find.presenter.DuanZiPresenter;
import com.bw.arp.jd.Find.view.IDuanZiView;
import com.bw.arp.jd.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ARP on 2018/4/17.
 */

public class Find extends Fragment implements IDuanZiView{
    @BindView(R.id.find_rlv)
    RecyclerView mFindRlv;
    @BindView(R.id.springview)
    SwipeRefreshLayout mSpringview;
    private View view;
    private Unbinder unbinder;
    private DuanZiPresenter duanZiPresenter;
    private int page = 1;
    private DuanziXQPresenter duanziXQPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find, container, false);
        unbinder = ButterKnife.bind(this, view);

        //实例化P层
        duanZiPresenter = new DuanZiPresenter(this);
        duanZiPresenter.getDuanZi(page, "android", "101");

        mSpringview.setColorSchemeColors(Color.GRAY);
        mSpringview.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSpringview.setRefreshing(false);
                page++;
                duanZiPresenter.getDuanZi(page, "android", "101");
                Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSuccess(DuanziBean duanziBean) {
        List<DuanziBean.DataBean> data = duanziBean.getData();
        MyDuanZiAdapter duanZiAdapter = new MyDuanZiAdapter(data, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mFindRlv.setLayoutManager(linearLayoutManager);
        mFindRlv.setAdapter(duanZiAdapter);
        duanZiAdapter.setOnDuaziItemLinister(new MyDuanZiAdapter.onDuaziItem() {
            @Override
            public void setOnDuanzi(int i, View view, String jid) {
                Intent intent = new Intent(getContext(), DuanziXQActivity.class);
                intent.putExtra("jid",jid);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFailed(DuanziBean duanziBean) {

    }
}
