package com.bw.arp.jd.ShoppingCar.model;

import android.content.Context;
import android.util.Log;

import com.bw.arp.jd.ShoppingCar.bean.ShoppingCarBean;
import com.bw.arp.jd.ShoppingCar.presenter.IShoppingPresenter;
import com.bw.arp.jd.Utils.DataManager;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/19.
 */

public class ShoppModel {
    private Context context;
    public void getselectcar(String uid,String source, final IShoppingPresenter iShoppingPresenter){
        DataManager manager = new DataManager(context);
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.add(
                manager.getselectcar(uid,source)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShoppingCarBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("onCompleted","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError","onError");
                    }

                    @Override
                    public void onNext(ShoppingCarBean shoppingCarBean) {
                        Log.e("onNext","onNext");
                        iShoppingPresenter.Show(shoppingCarBean);
                        List<ShoppingCarBean.DataBean> data = shoppingCarBean.getData();
                        Log.e("aaaaaa",data+"");
                    }
                })
        );
    }
}
