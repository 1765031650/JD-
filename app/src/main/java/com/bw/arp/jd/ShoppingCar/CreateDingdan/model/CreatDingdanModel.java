package com.bw.arp.jd.ShoppingCar.CreateDingdan.model;

import android.content.Context;

import com.bw.arp.jd.ShoppingCar.CreateDingdan.bean.CreateDingdanBean;
import com.bw.arp.jd.ShoppingCar.CreateDingdan.presenter.ICreateDingdanPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/21.
 */

public class CreatDingdanModel {
    private Context context;
    public void getcreatedingdan(String uid, String price, final ICreateDingdanPresenter iCreateDingdanPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getcreatedingdan(uid, price)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CreateDingdanBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CreateDingdanBean createDingdanBean) {
                        iCreateDingdanPresenter.Show(createDingdanBean);
                    }
                })
        );
    }
}
