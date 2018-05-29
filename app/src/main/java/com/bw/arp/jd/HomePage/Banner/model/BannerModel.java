package com.bw.arp.jd.HomePage.Banner.model;

import android.content.Context;
import android.util.Log;

import com.bw.arp.jd.HomePage.Banner.bean.BannerBean;
import com.bw.arp.jd.HomePage.Banner.presenter.IBannerPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/17.
 */

public class BannerModel {

    private Context context;
    public void getBanner(final IBannerPresenter iBannerPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("onCompleted","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError","onError");
                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        Log.e("onNext","onNext");
                        iBannerPresenter.Show(bannerBean);
                    }
                })
        );
    }
}
