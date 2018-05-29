package com.bw.arp.jd.Classify.AddCar.view;

import com.bw.arp.jd.Classify.AddCar.bean.AddCarBean;

/**
 * Created by ARP on 2018/4/19.
 */

public interface IAddView {
    void onSuccess(AddCarBean addCarBean);
    void onFailed(AddCarBean addCarBean);
}
