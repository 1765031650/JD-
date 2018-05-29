package com.bw.arp.jd.My.Rlv.view;

import com.bw.arp.jd.My.Rlv.bean.RlvBean;

/**
 * Created by ARP on 2018/4/18.
 */

public interface IRlvView {
    void onSuccess(RlvBean rlvBean);
    void onFailed(RlvBean rlvBean);
}
