package com.bw.arp.jd.Utils;



public class MyAPI {
    //登录
    public static final String LOGIN="user/login";
    //注册
    public static final String REG="user/reg";
    //首页广告（轮播图+京东秒杀+最底部的为你推荐）
    public static final String BANNER="ad/getAd";
    //首  页 九 宫 格
    public static final String JGG="product/getCatagory";
    //分类左边
    public static final String LEFT="product/getCatagory";
    //http://120.27.23.105/
    //分类右边
    public static final String RIGHT="product/getProductCatagory";
    //右边商品列表
    public static final String RIGHT_ITEM = "product/getProducts";
    //子分类详情
    public static final String XIANGQING = "product/getProductDetail";
    //加入购物车
    public static final String ADDCAR = "product/addCart";
    //查询购物车
    public static final String SELECTCAR = "product/getCarts";
    //创建订单
    public static final String CREATEDINGDAN = "product/createOrder";
    //订单列表
    public static final String DINGDANLIST = "product/getOrders";
    //个人中心接口
    public static final String MINE="user/getUserInfo";
    //发现
    public static final String DUANZI="quarter/getJokes";
    //段子详情
    public static final String DUANZIXQ="quarter/getJokeDetail";
    //删除购物车
    public static final String DELETECAR="product/deleteCart";
    //搜索页面
    public static final String SOUSUO="product/searchProducts";
}
