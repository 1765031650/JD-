package com.bw.arp.jd.Classify.XQing.model;

import android.content.Context;
import android.util.Log;

import com.bw.arp.jd.Classify.XQing.bean.XQingBean;
import com.bw.arp.jd.Classify.XQing.presenter.IXQingPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/18.
 */

public class XQingModel {
    private Context context;
    public void getXQing(String pid, String source , final IXQingPresenter ixQingPresenter)
    {
        DataManager manager = new DataManager(context);

        CompositeSubscription subscription = new CompositeSubscription();

        subscription.add(
                manager.getXqing(pid, source)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<XQingBean>() {
                            @Override
                            public void onCompleted() {
                                Log.e("onCompleted","onCompleted");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("onError","onError");
                            }

                            @Override
                            public void onNext(XQingBean xQingBean) {
                                Log.e("onNext","onNext");
                                ixQingPresenter.Show(xQingBean);
                            }
                        })
        );
    }
}
