package com.bw.arp.jd.Classify.AddCar.presenter;

import com.bw.arp.jd.Classify.AddCar.bean.AddCarBean;
import com.bw.arp.jd.Classify.AddCar.model.AddMyModel;
import com.bw.arp.jd.Classify.AddCar.view.IAddView;

/**
 * Created by ARP on 2018/4/19.
 */

public class AddPresenter implements IAddPresenter{

    private AddMyModel addMyModel;
    private IAddView iAddView;

    public AddPresenter(IAddView iAddView) {
        this.iAddView = iAddView;
        this.addMyModel = new AddMyModel();
    }
    public void Addcar(String uid,String pid,String source){
        addMyModel.getcars(uid,pid,source,this);
    }
    @Override
    public void Show(AddCarBean addCarBean) {
        iAddView.onSuccess(addCarBean);
    }

}
