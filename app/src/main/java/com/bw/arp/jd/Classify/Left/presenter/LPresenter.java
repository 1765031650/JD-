package com.bw.arp.jd.Classify.Left.presenter;


import com.bw.arp.jd.Classify.Left.bean.LeftBean;
import com.bw.arp.jd.Classify.Left.model.MyLModel;
import com.bw.arp.jd.Classify.Left.view.ILView;

/**
 * Created by ARP on 2018/4/15.
 */

public class LPresenter implements Ipre {
    private ILView ilView;
    private MyLModel myLModel;

    public LPresenter(ILView ilView) {
        this.ilView = ilView;
        this.myLModel = new MyLModel();
    }
    public void getdata(){

       myLModel.getData(this);
    }

    @Override
    public void Show(LeftBean leftBean) {
        ilView.onSuccess(leftBean);
    }
}
