package com.bw.arp.jd.Classify.Zifenlai.model;

import android.content.Context;

import com.bw.arp.jd.Classify.Zifenlai.bean.ZifenLBean;
import com.bw.arp.jd.Classify.Zifenlai.presenter.IZPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/18.
 */

public class MyZModel {
    private Context context;
    public void getZFLItem(String pscid, final IZPresenter izPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getZFL(pscid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZifenLBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ZifenLBean zifenLBean) {
                        izPresenter.Show(zifenLBean);
                    }
                })
        );
    }
}
