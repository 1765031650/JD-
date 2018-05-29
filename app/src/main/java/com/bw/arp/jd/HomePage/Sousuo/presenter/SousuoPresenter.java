package com.bw.arp.jd.HomePage.Sousuo.presenter;

import com.bw.arp.jd.HomePage.Sousuo.bean.SousuoBean;
import com.bw.arp.jd.HomePage.Sousuo.model.SousuoModel;
import com.bw.arp.jd.HomePage.Sousuo.view.ISousuoView;

/**
 * Created by ARP on 2018/4/28.
 */

public class SousuoPresenter implements ISousuoPresenter {
    private SousuoModel sousuoModel;
    private ISousuoView iSousuoView;

    public SousuoPresenter(ISousuoView iSousuoView) {
        this.iSousuoView = iSousuoView;
        this.sousuoModel = new SousuoModel();
    }

    public void getSousuoData(String keywords,String source){
        sousuoModel.getSousuo(keywords,source,this);
    }

    @Override
    public void Show(SousuoBean sousuoBean) {
        iSousuoView.onSuccess(sousuoBean);
    }

    @Override
    public void Failed(Exception e) {
        iSousuoView.onFailed(e);
    }
}
