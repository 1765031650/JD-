package com.bw.arp.jd.Classify.XQing.presenter;

import com.bw.arp.jd.Classify.XQing.bean.XQingBean;
import com.bw.arp.jd.Classify.XQing.model.XQingModel;
import com.bw.arp.jd.Classify.XQing.view.IXQView;

/**
 * Created by ARP on 2018/4/18.
 */

public class XQPresenter implements IXQingPresenter{
    private IXQView ixqView;
    private XQingModel xQingModel;

    public XQPresenter(IXQView ixqView) {
        this.ixqView = ixqView;
        this.xQingModel = new XQingModel();
    }

    public void getXQingDatas(String pid,String source){
        xQingModel.getXQing(pid,source,this);
    }
    @Override
    public void Show(XQingBean xQingBean) {
        ixqView.onSuccess(xQingBean);
    }
}
