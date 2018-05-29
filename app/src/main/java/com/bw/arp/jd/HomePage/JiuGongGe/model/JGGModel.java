package com.bw.arp.jd.HomePage.JiuGongGe.model;

import android.content.Context;
import android.util.Log;

import com.bw.arp.jd.HomePage.JiuGongGe.bean.JGGBean;
import com.bw.arp.jd.HomePage.JiuGongGe.presenter.IJGGPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/17.
 */

public class JGGModel {

    private Context context;
    public void getBanner(final IJGGPresenter iBannerPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getJgg()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JGGBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("onCompleted","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError","onError");
                    }

                    @Override
                    public void onNext(JGGBean jggBean) {
                        Log.e("onNext","onNext");
                        iBannerPresenter.Show(jggBean);
                    }
                })
        );
    }
}
