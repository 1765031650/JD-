package com.bw.arp.jd.My.Reg.presenter;

import com.bw.arp.jd.My.Reg.bean.RegBean;
import com.bw.arp.jd.My.Reg.model.RegModel;
import com.bw.arp.jd.My.Reg.view.IRegView;

/**
 * Created by ARP on 2018/4/19.
 */

public class RegPresenter implements IRegPresenter{
    private RegModel regModel;
    private IRegView iRegView;

    public RegPresenter(IRegView iRegView) {
        this.iRegView = iRegView;
        this.regModel = new RegModel();
    }
    public void getRegData(String mobile,String password){
        regModel.getLogin(mobile,password,this);
    }
    @Override
    public void Show(RegBean regBean) {
        iRegView.onSuccess(regBean);
    }
}
