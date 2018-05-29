package com.bw.arp.jd.My.MyMessage.model;

import android.content.Context;

import com.bw.arp.jd.My.MyMessage.bean.MyMessageBean;
import com.bw.arp.jd.My.MyMessage.presenter.IMessagePresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/25.
 */

public class MessageModel {
    private Context context;
    public void getMine(String uid, final IMessagePresenter iMessagePresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getmymessage(uid)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<MyMessageBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(MyMessageBean myMessageBean) {
                                iMessagePresenter.Show(myMessageBean);
                            }
                        })
        );
    }
}
