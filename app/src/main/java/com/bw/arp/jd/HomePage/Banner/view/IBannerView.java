package com.bw.arp.jd.HomePage.Banner.view;

import com.bw.arp.jd.HomePage.Banner.bean.BannerBean;

/**
 * Created by ARP on 2018/4/17.
 */

public interface IBannerView {
    void onSuccess(BannerBean bannerBean);
    void onFailed(BannerBean bannerBean);
}
