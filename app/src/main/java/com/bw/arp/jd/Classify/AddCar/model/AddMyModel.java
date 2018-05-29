package com.bw.arp.jd.Classify.AddCar.model;

import android.content.Context;

import com.bw.arp.jd.Classify.AddCar.bean.AddCarBean;
import com.bw.arp.jd.Classify.AddCar.presenter.IAddPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/19.
 */

public class AddMyModel {
    private Context context;
    public void getcars(String uid, String pid, String source, final IAddPresenter iAddPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getAddcar(uid, pid, source)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddCarBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AddCarBean addCarBean) {
                        iAddPresenter.Show(addCarBean);
                    }
                })
        );
    }
}
