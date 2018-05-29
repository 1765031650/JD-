package com.bw.arp.jd.ShoppingCar.presenter;

import com.bw.arp.jd.ShoppingCar.bean.ShoppingCarBean;
import com.bw.arp.jd.ShoppingCar.model.ShoppModel;
import com.bw.arp.jd.ShoppingCar.view.IShoppingView;

/**
 * Created by ARP on 2018/4/19.
 */

public class ShoppingPresenter implements IShoppingPresenter {
    private ShoppModel shoppModel;
    private IShoppingView iShoppingView;

    public ShoppingPresenter(IShoppingView iShoppingView) {
        this.iShoppingView = iShoppingView;
        this.shoppModel = new ShoppModel();
    }
    public void getcars(String uid,String source){
        shoppModel.getselectcar(uid, source,this);
    }
    @Override
    public void Show(ShoppingCarBean shoppingCarBean) {
        String code = shoppingCarBean.getCode();
        if (code.equals("0")){
            iShoppingView.onSuccess(shoppingCarBean);
        }

    }
}
