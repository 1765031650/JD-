package com.bw.arp.jd.My.Rlv.presenter;

import com.bw.arp.jd.My.Rlv.bean.RlvBean;
import com.bw.arp.jd.My.Rlv.model.MyRlvModel;
import com.bw.arp.jd.My.Rlv.view.IRlvView;

/**
 * Created by ARP on 2018/4/18.
 */

public class RlvPresenter implements IRlvPresenter {
    private MyRlvModel myRlvModel;
    private IRlvView iRlvView;

    public RlvPresenter(IRlvView iRlvView) {
        this.iRlvView = iRlvView;
        this.myRlvModel = new MyRlvModel();
    }

    public void getZFLData(){
        myRlvModel.getZFLItem(this);
    }
    @Override
    public void Show(RlvBean rlvBean) {
        iRlvView.onSuccess(rlvBean);
    }
}
