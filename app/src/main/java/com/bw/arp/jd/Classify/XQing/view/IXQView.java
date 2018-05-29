package com.bw.arp.jd.Classify.XQing.view;

import com.bw.arp.jd.Classify.XQing.bean.XQingBean;

/**
 * Created by ARP on 2018/4/18.
 */

public interface IXQView {
    void onSuccess(XQingBean xQingBean);
    void onFailed(XQingBean xQingBean);
}
