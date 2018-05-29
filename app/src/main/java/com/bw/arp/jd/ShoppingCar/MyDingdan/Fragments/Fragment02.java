package com.bw.arp.jd.ShoppingCar.MyDingdan.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.arp.jd.R;
import com.bw.arp.jd.ShoppingCar.MyDingdan.adapter.MyDingdanAdapter;
import com.bw.arp.jd.ShoppingCar.MyDingdan.bean.DingdanListBean;
import com.bw.arp.jd.ShoppingCar.MyDingdan.presenter.DingdanListPresenter;
import com.bw.arp.jd.ShoppingCar.MyDingdan.view.IDingdanListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ARP on 2018/4/22.
 */

public class Fragment02 extends Fragment implements IDingdanListView {

    @BindView(R.id.rlv_f2)
    RecyclerView mRlvF2;
    private DingdanListPresenter dingdanListPresenter;
    private MyDingdanAdapter adapter;
    private View view;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment02, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dingdanListPresenter = new DingdanListPresenter(this);
        dingdanListPresenter.getdingdanlist("71");
    }

    @Override
    public void onSuccess(DingdanListBean dingdanListBean) {
        List<DingdanListBean.DataBean> data = dingdanListBean.getData();
        adapter = new MyDingdanAdapter(getContext(), data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRlvF2.setLayoutManager(linearLayoutManager);
        mRlvF2.setAdapter(adapter);
    }

    @Override
    public void onFailed(DingdanListBean dingdanListBean) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
