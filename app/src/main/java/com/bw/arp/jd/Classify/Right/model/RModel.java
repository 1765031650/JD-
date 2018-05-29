package com.bw.arp.jd.Classify.Right.model;


import android.content.Context;
import android.util.Log;

import com.bw.arp.jd.Classify.Right.bean.RightBean;
import com.bw.arp.jd.Classify.Right.presenter.Presen;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by ARP on 2018/4/15.
 */

public class RModel {

    private Context context;
    public void getjson(String cid, final Presen presen)
    {
        DataManager manager = new DataManager(context);

        CompositeSubscription subscription = new CompositeSubscription();

        subscription.add(
                manager.getcalls(cid)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<RightBean>() {
                            @Override
                            public void onCompleted() {
                                Log.e("onCompleted","onCompleted");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("onError","onError");
                            }

                            @Override
                            public void onNext(RightBean rightBean) {
                                Log.e("onNext","onNext");
                                presen.rightShow(rightBean);
                            }
                        })
        );
    }
}
