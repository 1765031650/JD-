package com.bw.arp.jd.Classify.Zifenlai.presenter;

import com.bw.arp.jd.Classify.Zifenlai.bean.ZifenLBean;
import com.bw.arp.jd.Classify.Zifenlai.model.MyZModel;
import com.bw.arp.jd.Classify.Zifenlai.view.ZFLIView;

/**
 * Created by ARP on 2018/4/18.
 */

public class ZPresenter implements IZPresenter{
    private MyZModel myZModel;
    private ZFLIView zfliView;

    public ZPresenter(ZFLIView zfliView) {
        this.zfliView = zfliView;
        this.myZModel = new MyZModel();
    }

    public void getZFLData(String pscid){
        myZModel.getZFLItem(pscid,this);
    }
    @Override
    public void Show(ZifenLBean zifenLBean) {
        zfliView.onSuccess(zifenLBean);
    }
}
