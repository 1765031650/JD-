package com.bw.arp.jd.ShoppingCar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.arp.jd.R;
import com.bw.arp.jd.ShoppingCar.CreateDingdan.bean.CreateDingdanBean;
import com.bw.arp.jd.ShoppingCar.CreateDingdan.presenter.CreateDingdanPresenter;
import com.bw.arp.jd.ShoppingCar.CreateDingdan.view.ICreateView;
import com.bw.arp.jd.ShoppingCar.DeleteShopp.bean.DeleteBean;
import com.bw.arp.jd.ShoppingCar.DeleteShopp.presenter.DeletePresenter;
import com.bw.arp.jd.ShoppingCar.DeleteShopp.view.IDeleteView;
import com.bw.arp.jd.ShoppingCar.MyDingdan.DingdanActivity;
import com.bw.arp.jd.ShoppingCar.adapter.MyElvAdapter;
import com.bw.arp.jd.ShoppingCar.bean.ShoppingCarBean;
import com.bw.arp.jd.ShoppingCar.presenter.ShoppingPresenter;
import com.bw.arp.jd.ShoppingCar.view.IShoppingView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ARP on 2018/4/17.
 */

public class ShoppingCar extends Fragment implements IShoppingView, MyElvAdapter.ModifyGoodsItemNumberListener, MyElvAdapter.CheckGroupItemListener, ICreateView, IDeleteView {
    //默认是false
    private boolean flag;
    //购买商品的总价
    private double totalPrice = 0.00; //15.55  15  0.55亿
    //购买商品的总数量
    private int totalNum = 0;
    private View view;
    private List<ShoppingCarBean.DataBean> list = new ArrayList<>();
    /**
     * 返回
     */
    private TextView mTvBack;
    /**
     * 编辑
     */
    private TextView mTvRedact;
    private ExpandableListView mElv;
    private MyElvAdapter adapter;
    /**
     * 全选
     */
    private CheckBox mCkAll;
    /**
     * 合计:￥0.00
     */
    private TextView mSumprice;
    /**
     * 结算：（0）
     */
    private TextView mAccount;
    private ShoppingPresenter shoppingPresenter;
    private SharedPreferences pwk;
    private boolean isLogin;
    private CreateDingdanPresenter createDingdanPresenter;
    private String uid;
    private DeletePresenter deletePresenter;
    private SwipeRefreshLayout mSwip;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shoppingcar, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        pwk = getContext().getSharedPreferences("pwk", getContext().MODE_PRIVATE);
        isLogin = pwk.getBoolean("isLogin", false);
        uid = pwk.getString("uid", "");
//        Log.e("AAAA", uid + "");
        if (isLogin) {
            getDatas(uid);
            MyView();
        } else {
            Toast.makeText(getContext(), "请登录后查看", Toast.LENGTH_SHORT).show();
        }

        createDingdanPresenter = new CreateDingdanPresenter(this);
        deletePresenter = new DeletePresenter(this);

    }


    @Override
    public void checkGroupItem(int groupPosition, boolean isChecked) {
        //商家javabean
        ShoppingCarBean.DataBean dataBean = list.get(groupPosition);
        dataBean.setGroupChoosed(isChecked);
        //遍历商家里面的商品，将其置为选中状态
        for (ShoppingCarBean.DataBean.ListBean listBean : dataBean.getList()) {
            listBean.setChildChoosed(isChecked);
        }

        //底部结算那个checkbox状态(全选)
        if (isCheckAll()) {
            mCkAll.setChecked(true);
        } else {
            mCkAll.setChecked(false);
        }

        //刷新适配器
        adapter.notifyDataSetChanged();

        //计算价格
        statisticsPrice();
    }

    @Override
    public void checkChildItem(int groupPosition, int childPosition, boolean isChecked) {
        ShoppingCarBean.DataBean dataBean = list.get(groupPosition);//商家那一层
        List<ShoppingCarBean.DataBean.ListBean> listBeans = dataBean.getList();
        ShoppingCarBean.DataBean.ListBean listBean = listBeans.get(childPosition);

        //你点击商家的商品条目将其选中状态记录
        listBean.setChildChoosed(isChecked);

        //检测商家里面的每一个商品是否被选中，如果被选中，返回boolean
        boolean result = isGoodsCheckAll(groupPosition);
        if (result) {
            dataBean.setGroupChoosed(result);
        } else {
            dataBean.setGroupChoosed(result);
        }

        //底部结算那个checkbox状态(全选)
        if (isCheckAll()) {
            mCkAll.setChecked(true);
        } else {
            mCkAll.setChecked(false);
        }


        //刷新适配器
        adapter.notifyDataSetChanged();

        //计算总价
        statisticsPrice();
    }

    @Override
    public void doIncrease(int groupPosition, int childPosition, View view) {
        ShoppingCarBean.DataBean.ListBean listBean = list.get(groupPosition).getList().get(childPosition);
        //取出当前的商品数量
        int currentNum = listBean.getNum();
        //商品++
        currentNum++;
        //将商品数量设置javabean上
        listBean.setNum(currentNum);

        //刷新适配器
        adapter.notifyDataSetChanged();


        //计算商品价格
        statisticsPrice();

    }

    @Override
    public void doDecrease(int groupPosition, int childPosition, View view) {
        ShoppingCarBean.DataBean.ListBean listBean = list.get(groupPosition).getList().get(childPosition);
        //取出当前的商品数量
        int currentNum = listBean.getNum();
        //直接结束这个方法
        if (currentNum == 1) {
            return;
        }

        currentNum--;
        listBean.setNum(currentNum);
        //刷新适配器
        adapter.notifyDataSetChanged();

        //计算商品价格
        statisticsPrice();
    }

    @Override
    public void onSuccess(ShoppingCarBean shoppingCarBean) {
        if (shoppingCarBean.getData().size() == 0) {
            Toast.makeText(getContext(), "您的购物车里面空空如也~", Toast.LENGTH_SHORT).show();
        } else {
            list.addAll(shoppingCarBean.getData());
            adapter.setList(list);
            defaultExpand();
            adapter.notifyDataSetChanged();
            adapter.setDeleteItemLinister(new MyElvAdapter.DeleteItemLinister() {
                @Override
                public void doDelete(String pid, View view, int i, int i1) {
                    Log.e("AAAAA",pid+"");
                    deletePresenter.getdeletdata(uid, pid);
                    adapter.notifyDataSetChanged();
                }
            });
        }
        //刷新
        mSwip.setColorSchemeColors(Color.GRAY);
        mSwip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwip.setRefreshing(false);
                list.clear();
                shoppingPresenter.getcars(uid, "android");
                Toast.makeText(getContext(),"刷新成功",Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onFailed(ShoppingCarBean shoppingCarBean) {

    }

    //二级列表默认展开
    private void defaultExpand() {

        for (int i = 0; i < adapter.getGroupCount(); ++i) {
            mElv.expandGroup(i);
        }

    }

    private void initView(View view) {
//        mTvBack = (TextView) view.findViewById(R.id.tv_back);
        mTvRedact = (TextView) view.findViewById(R.id.tv_redact);
        mElv = (ExpandableListView) view.findViewById(R.id.elv);
        mCkAll = (CheckBox) view.findViewById(R.id.ck_All);
        mSumprice = (TextView) view.findViewById(R.id.sumprice);
        mAccount = (TextView) view.findViewById(R.id.account);

        mAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totalNum != 0) {
                    Intent intent = new Intent(getActivity(), DingdanActivity.class);
                    intent.putExtra("price", totalPrice + "");
                    getActivity().startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "您还没有选中任何商品，请先选择商品", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mSwip = (SwipeRefreshLayout) view.findViewById(R.id.swip);
    }

    private void getDatas(String uid) {
        //P层
        shoppingPresenter = new ShoppingPresenter(this);
        shoppingPresenter.getcars(uid, "android");
        adapter = new MyElvAdapter(getActivity());
        mElv.setAdapter(adapter);
        //去除默认指示器
        mElv.setGroupIndicator(null);
    }

    private void MyView() {

        //加减
        adapter.setModifyGoodsItemNumberListener(this);
        //CheckBox监听
        adapter.setCheckGroupItemListener(this);
        mCkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChoosedAll(((CheckBox) view).isChecked());
                //总价
                statisticsPrice();
            }
        });
        //编辑
        mTvRedact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!flag) {//编辑 -> 完成\
                    flag = true;
                    mTvRedact.setText("完成");
                    adapter.showDeleteButton(flag);
                } else {
                    flag = false;
                    mTvRedact.setText("编辑");
                    adapter.showDeleteButton(flag);
                }

            }
        });

    }


    //逻辑实行


    /**
     * 检测某个商家的商品是否都选中，如果都选中的话，商家CheckBox应该是选中状态
     *
     * @param groupPosition
     * @return
     */
    private boolean isGoodsCheckAll(int groupPosition) {
        List<ShoppingCarBean.DataBean.ListBean> listBeans = this.list.get(groupPosition).getList();
        //遍历某一个商家的每个商品是否被选中
        for (ShoppingCarBean.DataBean.ListBean listBean : listBeans) {
            if (listBean.isChildChoosed()) {//是选中状态
                continue;
            } else {
                return false;
            }

        }

        return true;
    }

    //购物车商品是否全部选中
    private boolean isCheckAll() {

        for (ShoppingCarBean.DataBean dataBean : list) {
            if (!dataBean.isGroupChoosed()) {
                return false;
            }
        }
        return true;
    }

    //全选与反选
    private void isChoosedAll(boolean isChecked) {

        for (ShoppingCarBean.DataBean dataBean : list) {
            dataBean.setGroupChoosed(isChecked);
            for (ShoppingCarBean.DataBean.ListBean listBean : dataBean.getList()) {
                listBean.setChildChoosed(isChecked);
            }
        }
        //刷新适配器
        adapter.notifyDataSetChanged();

    }


    /**
     * 计算你所选中的商品总价
     */
    private void statisticsPrice() {

        //初始化值
        totalNum = 0;
        totalPrice = 0.00;

        for (ShoppingCarBean.DataBean dataBean : list) {

            for (ShoppingCarBean.DataBean.ListBean listBean : dataBean.getList()) {
                if (listBean.isChildChoosed()) {
                    totalNum++;
                    System.out.println("number : " + totalNum);
                    totalPrice += listBean.getNum() * listBean.getPrice();

                }
            }

        }

        //设置文本信息 合计、结算的商品数量
        mSumprice.setText("合计:￥" + totalPrice);
        mAccount.setText("结算(" + totalNum + ")");


    }

    //创建订单
    @Override
    public void onSuccess(CreateDingdanBean createDingdanBean) {

    }

    @Override
    public void onSuccess(DeleteBean deleteBean) {
        //删除成功
        Toast.makeText(getActivity(), deleteBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(DeleteBean deleteBean) {
        //删除失败
        Toast.makeText(getActivity(), deleteBean.getMsg(), Toast.LENGTH_SHORT).show();
    }
}
