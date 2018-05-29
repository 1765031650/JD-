package com.bw.arp.jd.HomePage.Sousuo.view;

import com.bw.arp.jd.HomePage.Sousuo.bean.SousuoBean;

/**
 * Created by ARP on 2018/4/28.
 */

public interface ISousuoView {
    void onSuccess(SousuoBean sousuoBean);
    void onFailed(Exception e);
}
