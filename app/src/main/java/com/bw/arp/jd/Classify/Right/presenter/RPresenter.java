package com.bw.arp.jd.Classify.Right.presenter;


import com.bw.arp.jd.Classify.Right.bean.RightBean;
import com.bw.arp.jd.Classify.Right.model.RModel;
import com.bw.arp.jd.Classify.Right.view.IRView;

/**
 * Created by ARP on 2018/4/15.
 */

public class RPresenter implements Presen {
    private IRView irView;
    private RModel rModel;

    public RPresenter(IRView irView) {
        this.irView = irView;
        this.rModel = new RModel();
    }

    public void getdata(String cid){
        rModel.getjson(cid,this);

    }

    @Override
    public void rightShow(RightBean rightBean) {
        irView.onRSuccess(rightBean);
    }
}
