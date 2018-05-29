package com.bw.arp.jd.Classify.Left.model;

import android.content.Context;
import android.util.Log;

import com.bw.arp.jd.Classify.Left.bean.LeftBean;
import com.bw.arp.jd.Classify.Left.presenter.Ipre;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/15.
 */

public class MyLModel{

   private Context context;

    public void getData(final Ipre ipre)
    {
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getcall()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<LeftBean>() {
                            @Override
                            public void onCompleted() {
                                Log.e("onCompleted","onCompleted");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("onError","onError");
                            }

                            @Override
                            public void onNext(LeftBean leftBean) {
                                Log.e("onNext","onNext");

                                ipre.Show(leftBean);
                            }
                        })
        );
    }

}
