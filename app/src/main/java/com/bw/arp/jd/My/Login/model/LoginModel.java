package com.bw.arp.jd.My.Login.model;

import android.content.Context;

import com.bw.arp.jd.My.Login.bean.LoginBean;
import com.bw.arp.jd.My.Login.presenter.ILoginPresenter;
import com.bw.arp.jd.Utils.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/19.
 */

public class LoginModel {
    private Context context;
    public void getLogin(String mobile, String password, final ILoginPresenter iLoginPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getlogin(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        iLoginPresenter.Show(loginBean);
                    }
                })
        );
    }
}
