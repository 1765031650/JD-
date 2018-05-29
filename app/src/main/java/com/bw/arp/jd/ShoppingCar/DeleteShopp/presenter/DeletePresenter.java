package com.bw.arp.jd.ShoppingCar.DeleteShopp.presenter;

import com.bw.arp.jd.ShoppingCar.DeleteShopp.bean.DeleteBean;
import com.bw.arp.jd.ShoppingCar.DeleteShopp.model.DeleteModel;
import com.bw.arp.jd.ShoppingCar.DeleteShopp.view.IDeleteView;

/**
 * Created by ARP on 2018/4/27.
 */

public class DeletePresenter implements IDeletePresenter {
    private DeleteModel deleteModel;
    private IDeleteView iDeleteView;

    public DeletePresenter(IDeleteView iDeleteView) {
        this.iDeleteView = iDeleteView;
        this.deleteModel = new DeleteModel();
    }

    public void getdeletdata(String uid,String pid){
        deleteModel.getdelete(uid,pid,this);
    }
    @Override
    public void Show(DeleteBean deleteBean) {
        iDeleteView.onSuccess(deleteBean);
    }
}
