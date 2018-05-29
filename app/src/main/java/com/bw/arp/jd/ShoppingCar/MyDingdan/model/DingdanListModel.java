package com.bw.arp.jd.ShoppingCar.MyDingdan.model;

import android.content.Context;

import com.bw.arp.jd.ShoppingCar.MyDingdan.bean.DingdanListBean;
import com.bw.arp.jd.ShoppingCar.MyDingdan.presenter.IDingdanListPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/22.
 */

public class DingdanListModel {
    private Context context;
    public void getdingdanlist(String uid, final IDingdanListPresenter iDingdanListPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getdingdanlist(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DingdanListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DingdanListBean dingdanListBean) {
                        iDingdanListPresenter.Show(dingdanListBean);
                    }
                })
        );
    }
}
