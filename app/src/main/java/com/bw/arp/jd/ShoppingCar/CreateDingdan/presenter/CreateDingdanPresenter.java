package com.bw.arp.jd.ShoppingCar.CreateDingdan.presenter;

import com.bw.arp.jd.ShoppingCar.CreateDingdan.bean.CreateDingdanBean;
import com.bw.arp.jd.ShoppingCar.CreateDingdan.model.CreatDingdanModel;
import com.bw.arp.jd.ShoppingCar.CreateDingdan.view.ICreateView;

/**
 * Created by ARP on 2018/4/21.
 */

public class CreateDingdanPresenter implements ICreateDingdanPresenter{
    private ICreateView iCreateView;
    private CreatDingdanModel creatDingdanModel;

    public CreateDingdanPresenter(ICreateView iCreateView) {
        this.iCreateView = iCreateView;
        this.creatDingdanModel = new CreatDingdanModel();
    }
    public void getcreateDingdans(String uid,String price){
        creatDingdanModel.getcreatedingdan(uid,price,this);
    }
    @Override
    public void Show(CreateDingdanBean createDingdanBean) {
        iCreateView.onSuccess(createDingdanBean);
    }
}
