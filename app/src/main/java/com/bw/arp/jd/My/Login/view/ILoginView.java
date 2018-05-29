package com.bw.arp.jd.My.Login.view;

import com.bw.arp.jd.My.Login.bean.LoginBean;

/**
 * Created by ARP on 2018/4/19.
 */

public interface ILoginView {
    void onSuccess(LoginBean loginBean);
    void onFailed(LoginBean loginBean);
}
