package com.bw.arp.jd.HomePage.JiuGongGe.presenter;

import com.bw.arp.jd.HomePage.JiuGongGe.bean.JGGBean;
import com.bw.arp.jd.HomePage.JiuGongGe.model.JGGModel;
import com.bw.arp.jd.HomePage.JiuGongGe.view.IJGGView;

/**
 * Created by ARP on 2018/4/17.
 */

public class JGGPresenter implements IJGGPresenter {
    private JGGModel jggModel;
    private IJGGView ijggView;

    public JGGPresenter(IJGGView iBannerView) {
        this.ijggView = iBannerView;
        this.jggModel = new JGGModel();
    }
    public void getDataBanner(){
        jggModel.getBanner(this);
    }

    @Override
    public void Show(JGGBean jggBean) {
        if (jggBean.getCode().equals("0")){
            ijggView.onSuccess(jggBean);
        }
    }
}
