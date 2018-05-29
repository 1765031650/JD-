package com.bw.arp.jd.ShoppingCar.DeleteShopp.view;

import com.bw.arp.jd.ShoppingCar.DeleteShopp.bean.DeleteBean;

/**
 * Created by ARP on 2018/4/27.
 */

public interface IDeleteView {
    void onSuccess(DeleteBean deleteBean);
    void onFailed(DeleteBean deleteBean);
}
