package com.bw.arp.jd.My.MyMessage.view;

import com.bw.arp.jd.My.MyMessage.bean.MyMessageBean;

/**
 * Created by ARP on 2018/4/25.
 */

public interface IMessageView {
    void onSuccess(MyMessageBean myMessageBean);
    void onFailed(MyMessageBean myMessageBean);
}
