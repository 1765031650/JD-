package com.bw.arp.jd.Classify.Zifenlai.view;

import com.bw.arp.jd.Classify.Zifenlai.bean.ZifenLBean;

/**
 * Created by ARP on 2018/4/18.
 */

public interface ZFLIView {
    void onSuccess(ZifenLBean zifenLBean);
    void onFailed(ZifenLBean zifenLBean);
}
