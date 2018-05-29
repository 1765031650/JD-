package com.bw.arp.jd.ShoppingCar.MyDingdan.presenter;

import com.bw.arp.jd.ShoppingCar.MyDingdan.bean.DingdanListBean;
import com.bw.arp.jd.ShoppingCar.MyDingdan.model.DingdanListModel;
import com.bw.arp.jd.ShoppingCar.MyDingdan.view.IDingdanListView;

/**
 * Created by ARP on 2018/4/22.
 */

public class DingdanListPresenter implements IDingdanListPresenter{
    private DingdanListModel dingdanListModel;
    private IDingdanListView iDingdanListView;

    public DingdanListPresenter(IDingdanListView iDingdanListView) {
        this.iDingdanListView = iDingdanListView;
        this.dingdanListModel = new DingdanListModel();
    }

    public void getdingdanlist(String uid){
        dingdanListModel.getdingdanlist(uid,this);
    }

    @Override
    public void Show(DingdanListBean dingdanListBean) {
        iDingdanListView.onSuccess(dingdanListBean);
    }
}
