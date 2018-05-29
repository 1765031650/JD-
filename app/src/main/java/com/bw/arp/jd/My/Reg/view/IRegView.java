package com.bw.arp.jd.My.Reg.view;

import com.bw.arp.jd.My.Reg.bean.RegBean;

/**
 * Created by ARP on 2018/4/19.
 */

public interface IRegView {
    void onSuccess(RegBean regBean);
    void onFailed(RegBean regBean);
}
