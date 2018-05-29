package com.bw.arp.jd.HomePage.Bottom.view;

import com.bw.arp.jd.HomePage.Bottom.bean.BottomBean;

/**
 * Created by ARP on 2018/4/17.
 */

public interface IBottomView {
    void onSuccess(BottomBean bottomBean);
    void onFailed(BottomBean bottomBean);
}
