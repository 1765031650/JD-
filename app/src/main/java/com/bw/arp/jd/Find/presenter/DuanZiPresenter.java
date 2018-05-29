package com.bw.arp.jd.Find.presenter;

import com.bw.arp.jd.Find.bean.DuanziBean;
import com.bw.arp.jd.Find.model.DuanZiModel;
import com.bw.arp.jd.Find.view.IDuanZiView;

/**
 * Created by ARP on 2018/4/26.
 */

public class DuanZiPresenter implements IDuanZiPresenter {
    private DuanZiModel duanZiModel;
    private IDuanZiView iDuanZiView;

    public DuanZiPresenter(IDuanZiView iDuanZiView) {
        this.iDuanZiView = iDuanZiView;
        this.duanZiModel = new DuanZiModel();
    }

    public void getDuanZi(int page,String source,String appVersion){
        duanZiModel.getDuanzi(page,source,appVersion,this);
    }
    @Override
    public void Show(DuanziBean duanziBean) {
        iDuanZiView.onSuccess(duanziBean);
    }
}
