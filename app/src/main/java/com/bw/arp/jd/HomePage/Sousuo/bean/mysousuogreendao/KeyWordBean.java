package com.bw.arp.jd.HomePage.Sousuo.bean.mysousuogreendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ARP on 2018/5/22.
 */
@Entity
public class KeyWordBean {
    @Id
    private Long id;
    private String name;
    @Generated(hash = 1763108124)
    public KeyWordBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 673900408)
    public KeyWordBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
