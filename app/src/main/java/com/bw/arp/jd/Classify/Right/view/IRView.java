package com.bw.arp.jd.Classify.Right.view;


import com.bw.arp.jd.Classify.Right.bean.RightBean;

/**
 * Created by ARP on 2018/4/15.
 */

public interface IRView {
    void onRSuccess(RightBean rightBean);
    void onRFailed(RightBean rightBean);
}
