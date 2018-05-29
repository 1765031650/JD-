package com.bw.arp.jd.Find.view;

import com.bw.arp.jd.Find.bean.DuanziBean;

/**
 * Created by ARP on 2018/4/26.
 */

public interface IDuanZiView {
    void onSuccess(DuanziBean duanziBean);
    void onFailed(DuanziBean duanziBean);
}
