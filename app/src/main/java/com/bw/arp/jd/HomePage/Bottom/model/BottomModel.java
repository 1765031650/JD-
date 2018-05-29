package com.bw.arp.jd.HomePage.Bottom.model;

import android.content.Context;
import android.util.Log;

import com.bw.arp.jd.HomePage.Bottom.bean.BottomBean;
import com.bw.arp.jd.HomePage.Bottom.presenter.IBottomPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/17.
 */

public class BottomModel {

    private Context context;
    public void getBottom(final IBottomPresenter iBottomPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getbottom()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BottomBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("onCompleted","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError","onError");
                    }

                    @Override
                    public void onNext(BottomBean bottomBean) {
                        Log.e("onNext","onNext");
                        iBottomPresenter.Show(bottomBean);
                    }
                })
        );
    }
}
