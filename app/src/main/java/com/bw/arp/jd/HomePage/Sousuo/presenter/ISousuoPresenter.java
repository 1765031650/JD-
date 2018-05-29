package com.bw.arp.jd.HomePage.Sousuo.presenter;

import com.bw.arp.jd.HomePage.Sousuo.bean.SousuoBean;

/**
 * Created by ARP on 2018/4/28.
 */

public interface ISousuoPresenter {
    void Show(SousuoBean sousuoBean);
    void Failed(Exception e);
}
