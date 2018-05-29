package com.bw.arp.jd.Utils;

import android.content.Context;

import com.bw.arp.jd.Classify.AddCar.bean.AddCarBean;
import com.bw.arp.jd.Classify.Left.bean.LeftBean;
import com.bw.arp.jd.Classify.Right.bean.RightBean;
import com.bw.arp.jd.Classify.XQing.bean.XQingBean;
import com.bw.arp.jd.Classify.Zifenlai.bean.ZifenLBean;
import com.bw.arp.jd.Find.DuanZiXQ.bean.DuanziXQBean;
import com.bw.arp.jd.Find.bean.DuanziBean;
import com.bw.arp.jd.HomePage.Banner.bean.BannerBean;
import com.bw.arp.jd.HomePage.Bottom.bean.BottomBean;
import com.bw.arp.jd.HomePage.JiuGongGe.bean.JGGBean;
import com.bw.arp.jd.HomePage.Sousuo.bean.SousuoBean;
import com.bw.arp.jd.My.Login.bean.LoginBean;
import com.bw.arp.jd.My.MyMessage.bean.MyMessageBean;
import com.bw.arp.jd.My.Reg.bean.RegBean;
import com.bw.arp.jd.My.Rlv.bean.RlvBean;
import com.bw.arp.jd.ShoppingCar.CreateDingdan.bean.CreateDingdanBean;
import com.bw.arp.jd.ShoppingCar.DeleteShopp.bean.DeleteBean;
import com.bw.arp.jd.ShoppingCar.MyDingdan.bean.DingdanListBean;
import com.bw.arp.jd.ShoppingCar.bean.ShoppingCarBean;

import rx.Observable;


/**
 * Created by win764-1 on 2016/12/12.
 */

public class DataManager {
    private RetrofitService mRetrofitService;

    //构造器里获取RetrofitService
    public DataManager(Context context) {
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }
    //网络请求方法getSearchBooks

    //登录
    public Observable<LoginBean> getlogin(String mobile,String password){
        return mRetrofitService.login(mobile, password);
    }
    //注册
    public Observable<RegBean> getreg(String mobile,String password){
        return mRetrofitService.reg(mobile,password);
    }
    //Banner轮播图
    public Observable<BannerBean> getBanner(){
        return mRetrofitService.banner();
    }
    //九宫格
    public Observable<JGGBean> getJgg(){
        return mRetrofitService.jgg();
    }
    //底部数据显示
    public Observable<BottomBean> getbottom(){
        return mRetrofitService.bottom();
    }
    //左边分类
    public Observable<LeftBean> getcall() {

        return mRetrofitService.leftbt();
    }
    //右边分类
    public Observable<RightBean> getcalls(String cid) {
        return mRetrofitService.rightbt(cid);
    }
    //右边分类子条目
    public Observable<ZifenLBean> getZFL(String pscid){
        return mRetrofitService.ZiFen(pscid);
    }
    //子分类详情
    public Observable<XQingBean> getXqing(String pid,String source){
        return mRetrofitService.XQing(pid, source);
    }
    //加入购物车
    public Observable<AddCarBean> getAddcar(String uid,String pid,String source){
        return mRetrofitService.addcar(uid, pid, source);
    }
    //查询购物车
    public Observable<ShoppingCarBean> getselectcar(String uid,String source){
        return mRetrofitService.selectcar(uid,source);
    }
    //创建订单
    public Observable<CreateDingdanBean> getcreatedingdan(String uid,String price){
        return mRetrofitService.createdingdan(uid, price);
    }
    //订单列表
    public Observable<DingdanListBean> getdingdanlist(String uid){
        return mRetrofitService.dingdanlist(uid);
    }
    //Rlv
    public Observable<RlvBean> getRlv(){
        return mRetrofitService.rlv();
    }
    //个人信息
    public Observable<MyMessageBean> getmymessage(String uid){
        return mRetrofitService.mymessage(uid);
    }
    //发现
    public Observable<DuanziBean> getduanzi(int page,String source,String appVersion){
        return mRetrofitService.myduanzi(page, source, appVersion);
    }
    //删除购物车
    public Observable<DeleteBean> getdelete(String uid,String pid){
        return mRetrofitService.mydelete(uid, pid);
    }
    //段子详情
    public Observable<DuanziXQBean> getduanzixq(String jid,String source,String appVersion){
        return mRetrofitService.myduanzixq(jid, source, appVersion);
    }
    //搜索页面
    public Observable<SousuoBean> getsousuo(String keywords,String source){
        return mRetrofitService.mysousuo(keywords, source);
    }
}

