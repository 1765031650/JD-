package com.bw.arp.jd.My.Rlv.model;

import android.content.Context;

import com.bw.arp.jd.My.Rlv.bean.RlvBean;
import com.bw.arp.jd.My.Rlv.presenter.IRlvPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/18.
 */

public class MyRlvModel {
    private Context context;
    public void getZFLItem(final IRlvPresenter izPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getRlv()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RlvBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RlvBean rlvBean) {
                        izPresenter.Show(rlvBean);
                    }
                })
        );
    }
}
