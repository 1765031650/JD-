package com.bw.arp.jd.My.Reg.model;

import android.content.Context;

import com.bw.arp.jd.My.Reg.bean.RegBean;
import com.bw.arp.jd.My.Reg.presenter.IRegPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/19.
 */

public class RegModel {
    private Context context;
    public void getLogin(String mobile, String password, final IRegPresenter regPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getreg(mobile,password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<RegBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(RegBean regBean) {
                                regPresenter.Show(regBean);
                            }
                        })
        );
    }
}
