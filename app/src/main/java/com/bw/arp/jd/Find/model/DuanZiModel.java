package com.bw.arp.jd.Find.model;

import android.content.Context;

import com.bw.arp.jd.Find.bean.DuanziBean;
import com.bw.arp.jd.Find.presenter.IDuanZiPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/26.
 */

public class DuanZiModel {
    private Context context;
    public void getDuanzi(int page, String source, String appVersion, final IDuanZiPresenter iDuanZiPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getduanzi(page, source, appVersion)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DuanziBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DuanziBean duanziBean) {
                        iDuanZiPresenter.Show(duanziBean);
                    }
                })
        );
    }
}
