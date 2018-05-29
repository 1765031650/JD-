package com.bw.arp.jd.ShoppingCar.DeleteShopp.model;

import android.content.Context;

import com.bw.arp.jd.ShoppingCar.DeleteShopp.bean.DeleteBean;
import com.bw.arp.jd.ShoppingCar.DeleteShopp.presenter.IDeletePresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/27.
 */

public class DeleteModel {
    private Context context;
    public void getdelete(String uid, String pid, final IDeletePresenter iDeletePresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getdelete(uid, pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeleteBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DeleteBean deleteBean) {
                        iDeletePresenter.Show(deleteBean);
                    }
                })
        );
    }
}
