package com.bw.arp.jd.ShoppingCar.view;

import com.bw.arp.jd.ShoppingCar.bean.ShoppingCarBean;

/**
 * Created by ARP on 2018/4/19.
 */

public interface IShoppingView {
    void onSuccess(ShoppingCarBean shoppingCarBean);
    void onFailed(ShoppingCarBean shoppingCarBean);
}
