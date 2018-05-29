package com.bw.arp.jd.Classify.Left.view;


import com.bw.arp.jd.Classify.Left.bean.LeftBean;

/**
 * Created by ARP on 2018/4/15.
 */

public interface ILView {
    void onSuccess(LeftBean leftBean);
    void onFailed(LeftBean leftBean);
}
