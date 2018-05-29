package com.bw.arp.jd.HomePage.Bottom.presenter;

import com.bw.arp.jd.HomePage.Bottom.bean.BottomBean;
import com.bw.arp.jd.HomePage.Bottom.model.BottomModel;
import com.bw.arp.jd.HomePage.Bottom.view.IBottomView;

/**
 * Created by ARP on 2018/4/17.
 */

public class BottomPresenter implements IBottomPresenter {
    private BottomModel bottomModel;
    private IBottomView iBottomView;

    public BottomPresenter(IBottomView iBottomView) {
        this.iBottomView = iBottomView;
        this.bottomModel = new BottomModel();
    }

    public void getBottom(){
        bottomModel.getBottom(this);
    }

    @Override
    public void Show(BottomBean bottomBean) {
        if (bottomBean.getCode().equals("0")){
            iBottomView.onSuccess(bottomBean);
        }
    }
}
