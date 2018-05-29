package com.bw.arp.jd.ShoppingCar.MyDingdan.view;

import com.bw.arp.jd.ShoppingCar.MyDingdan.bean.DingdanListBean;

/**
 * Created by ARP on 2018/4/22.
 */

public interface IDingdanListView {
    void onSuccess(DingdanListBean dingdanListBean);
    void onFailed(DingdanListBean dingdanListBean);
}
