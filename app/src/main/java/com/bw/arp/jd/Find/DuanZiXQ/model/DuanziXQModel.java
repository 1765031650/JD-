package com.bw.arp.jd.Find.DuanZiXQ.model;

import android.content.Context;

import com.bw.arp.jd.Find.DuanZiXQ.bean.DuanziXQBean;
import com.bw.arp.jd.Find.DuanZiXQ.presenter.IDuanziXQPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/28.
 */

public class DuanziXQModel {
    private Context context;
    public void getDuanziXQ(String jid, String source, String appVersion, final IDuanziXQPresenter iDuanziXQPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getduanzixq(jid, source, appVersion)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DuanziXQBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DuanziXQBean duanziXQBean) {
                        iDuanziXQPresenter.Show(duanziXQBean);
                    }
                })
        );
    }
}
