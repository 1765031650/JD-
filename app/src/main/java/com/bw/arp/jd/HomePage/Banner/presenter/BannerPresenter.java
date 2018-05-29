package com.bw.arp.jd.HomePage.Banner.presenter;

import com.bw.arp.jd.HomePage.Banner.bean.BannerBean;
import com.bw.arp.jd.HomePage.Banner.model.BannerModel;
import com.bw.arp.jd.HomePage.Banner.view.IBannerView;

/**
 * Created by ARP on 2018/4/17.
 */

public class BannerPresenter implements IBannerPresenter{
    private BannerModel bannerModel;
    private IBannerView iBannerView;

    public BannerPresenter(IBannerView iBannerView) {
        this.iBannerView = iBannerView;
        this.bannerModel = new BannerModel();
    }
    public void getDataBanner(){
        bannerModel.getBanner(this);
    }
    @Override
    public void Show(BannerBean bannerBean) {
        if (bannerBean.getCode().equals("0")){
            iBannerView.onSuccess(bannerBean);
        }
    }
}
