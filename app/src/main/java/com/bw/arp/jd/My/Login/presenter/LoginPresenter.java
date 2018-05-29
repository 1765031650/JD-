package com.bw.arp.jd.My.Login.presenter;

import com.bw.arp.jd.My.Login.bean.LoginBean;
import com.bw.arp.jd.My.Login.model.LoginModel;
import com.bw.arp.jd.My.Login.view.ILoginView;

/**
 * Created by ARP on 2018/4/19.
 */

public class LoginPresenter implements ILoginPresenter{
    private LoginModel loginModel;
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        this.loginModel = new LoginModel();
    }

    public void getLoginData(String mobile,String password){
        loginModel.getLogin(mobile,password,this);
    }
    @Override
    public void Show(LoginBean loginBean) {
        iLoginView.onSuccess(loginBean);
    }
}
