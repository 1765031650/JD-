package com.bw.arp.jd.Utils;


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

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by win764-1 on 2016/12/12.
 */

public interface RetrofitService {
    //登录
    @FormUrlEncoded
    @POST(MyAPI.LOGIN)
    Observable<LoginBean> login(@Field("mobile") String mobile,
                                @Field("password") String password
                                );
    //注册
    @FormUrlEncoded
    @POST(MyAPI.REG)
    Observable<RegBean> reg(@Field("mobile") String mobile,
                            @Field("password") String password);
     // //首页广告（轮播图+京东秒杀+最底部的为你推荐）
    @GET(MyAPI.BANNER)
    Observable<BannerBean> banner();
    //首  页 九 宫 格
    @GET(MyAPI.JGG)
    Observable<JGGBean> jgg();
    //底部数据
    @GET(MyAPI.BANNER)
    Observable<BottomBean> bottom();
    //左边
    @GET(MyAPI.LEFT)
    Observable<LeftBean> leftbt();
    //右边
    @GET(MyAPI.RIGHT)
    Observable<RightBean> rightbt(@Query("cid") String cid);
    //右边商品列表
    @GET(MyAPI.RIGHT_ITEM)
    Observable<ZifenLBean> ZiFen(@Query("pscid") String pscid);
    //子分类详情
    @GET(MyAPI.XIANGQING)
    Observable<XQingBean> XQing(@Query("pid") String pid,
                                @Query("source") String source);
    //加入购物车
    @GET(MyAPI.ADDCAR)
    Observable<AddCarBean> addcar(@Query("uid") String uid,
                                  @Query("pid") String pid,
                                  @Query("source") String source);
    //查询购物车
    @GET(MyAPI.SELECTCAR)
    Observable<ShoppingCarBean> selectcar(@Query("uid") String uid,
                                          @Query("source") String source);
    //创建订单
    @GET(MyAPI.CREATEDINGDAN)
    Observable<CreateDingdanBean> createdingdan(@Query("uid") String uid,
                                                @Query("price") String price
                                                );
    //订单列表
    @GET(MyAPI.DINGDANLIST)
    Observable<DingdanListBean> dingdanlist(@Query("uid") String uid);
    //Rlv
    @GET(MyAPI.BANNER)
    Observable<RlvBean> rlv();
    //个人信息
    @GET(MyAPI.MINE)
    Observable<MyMessageBean> mymessage(@Query("uid") String uid);
    //发现
    @GET(MyAPI.DUANZI)
    Observable<DuanziBean> myduanzi(@Query("page") int page,
                                    @Query("source") String source,
                                    @Query("appVersion") String appVersion
                                    );
    //删除购物车
    @GET(MyAPI.DELETECAR)
    Observable<DeleteBean> mydelete(@Query("uid") String uid,
                                    @Query("pid") String pid
                                    );
    //段子详情
    @GET(MyAPI.DUANZIXQ)
    Observable<DuanziXQBean> myduanzixq(@Query("jid") String jid,
                                        @Query("source") String source,
                                        @Query("appVersion") String appVersion
                                        );
    //搜索页面
    @GET(MyAPI.SOUSUO)
    Observable<SousuoBean> mysousuo(@Query("keywords") String keywords,
                                    @Query("source") String source
                                    );
    //请求方式
    //
    //http://api.tianapi.com/huabian/?key=71e58b5b2f930eaf1f937407acde08fe&num
//    @GET("book/search")
//    //Observable
//    //@Query() ?后面用它去拼接
//    //@QueryMap ?后面拼接数组用的
//   /* @Path：所有在网址中的参数（URL的问号前面），如：
//    http://102.10.10.132/api/Accounts/{accountId}
//    @Query：URL问号后面的参数，如：
//    http://102.10.10.132/api/Comments?access_token={access_token}
//    @QueryMap：相当于多个@Query
//    @Field：用于POST请求，提交单个数据
//    @Body：相当于多个@Field，以对象的形式提交
//*/
//
//    Observable<Book> getSearchBooks(@Query("q") String name,
//                                    @Query("tag") String tag, @Query("start") int start,
//
//                       @Query("count") int count);
}
