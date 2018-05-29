package com.bw.arp.jd.HomePage.Sousuo.model;

import android.content.Context;

import com.bw.arp.jd.HomePage.Sousuo.bean.SousuoBean;
import com.bw.arp.jd.HomePage.Sousuo.presenter.ISousuoPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/28.
 */

public class SousuoModel {
    private Context context;
    public void getSousuo(String keywords, String source, final ISousuoPresenter iSousuoPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getsousuo(keywords, source)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SousuoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iSousuoPresenter.Failed(new Exception(e));
                    }

                    @Override
                    public void onNext(SousuoBean sousuoBean) {
                        iSousuoPresenter.Show(sousuoBean);
                    }
                })
        );
    }
}
