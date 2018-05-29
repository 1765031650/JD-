package com.bw.arp.jd.Classify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.arp.jd.Classify.Left.adapter.Left_Adapter;
import com.bw.arp.jd.Classify.Left.bean.LeftBean;
import com.bw.arp.jd.Classify.Left.presenter.LPresenter;
import com.bw.arp.jd.Classify.Left.view.ILView;
import com.bw.arp.jd.Classify.Right.adapter.Right_Adapter2;
import com.bw.arp.jd.Classify.Right.bean.RightBean;
import com.bw.arp.jd.Classify.Right.presenter.RPresenter;
import com.bw.arp.jd.Classify.Right.view.IRView;
import com.bw.arp.jd.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/17.
 */

public class Classify extends Fragment implements ILView,IRView{
    @BindView(R.id.leftRlv)
    RecyclerView mLeftRlv;
    @BindView(R.id.rightRlv)
    RecyclerView mRightRlv;
    private View view;
    private Unbinder unbinder;
    private List<LeftBean.DataBean> list;
    private LPresenter lPresenter;
    private RPresenter rPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.classify, container, false);
        unbinder = ButterKnife.bind(this, view);

        //左边的P层
        lPresenter = new LPresenter(this);
        lPresenter.getdata();
        //右边的P层
        rPresenter = new RPresenter(this);


        rPresenter.getdata("1");
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSuccess(LeftBean leftBean) {
        list = leftBean.getData();
        Log.e("onSuccess", list.size()+"");
        Left_Adapter adapter1 = new Left_Adapter(list,getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mLeftRlv.setLayoutManager(layoutManager);
        mLeftRlv.setAdapter(adapter1);
        adapter1.setOnClicklistener(new Left_Adapter.setOn() {
            @Override
            public void Itemlisten(int position, String cid, View view) {
                rPresenter.getdata(cid);
            }
        });
    }

    @Override
    public void onFailed(LeftBean leftBean) {

    }


    @Override
    public void onRSuccess(RightBean rightBean) {
        List<RightBean.DataBean> data = rightBean.getData();
        Right_Adapter2 adapter = new Right_Adapter2(data,getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRightRlv.setLayoutManager(manager);
        mRightRlv.setAdapter(adapter);
    }

    @Override
    public void onRFailed(RightBean rightBean) {

    }

    @Override
    public void onStop() {
        super.onStop();
        new CompositeSubscription().unsubscribe();
    }
}
