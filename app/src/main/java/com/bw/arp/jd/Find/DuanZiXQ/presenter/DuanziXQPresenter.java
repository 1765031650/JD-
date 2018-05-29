package com.bw.arp.jd.Find.DuanZiXQ.presenter;

import com.bw.arp.jd.Find.DuanZiXQ.bean.DuanziXQBean;
import com.bw.arp.jd.Find.DuanZiXQ.model.DuanziXQModel;
import com.bw.arp.jd.Find.DuanZiXQ.view.DuanziXQView;

/**
 * Created by ARP on 2018/4/28.
 */

public class DuanziXQPresenter implements IDuanziXQPresenter {
    private DuanziXQModel duanziXQModel;
    private DuanziXQView duanziXQView;

    public DuanziXQPresenter(DuanziXQView duanziXQView) {
        this.duanziXQView = duanziXQView;
        this.duanziXQModel = new DuanziXQModel();
    }

    public void getDuanziXQData(String jid,String source,String appVersion){
        duanziXQModel.getDuanziXQ(jid,source,appVersion,this);
    }

    @Override
    public void Show(DuanziXQBean duanziXQBean) {
        duanziXQView.onSuccess(duanziXQBean);
    }
}
