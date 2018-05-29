package com.bw.arp.jd.ShoppingCar.MyDingdan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.arp.jd.R;
import com.bw.arp.jd.ShoppingCar.CreateDingdan.bean.CreateDingdanBean;
import com.bw.arp.jd.ShoppingCar.CreateDingdan.presenter.CreateDingdanPresenter;
import com.bw.arp.jd.ShoppingCar.CreateDingdan.view.ICreateView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DingdanActivity extends AppCompatActivity implements ICreateView{

    @BindView(R.id.order_price)
    TextView mOrderPrice;
    @BindView(R.id.dingdan_tuichu)
    Button mDingdanTuichu;
    @BindView(R.id.dingdan_creat)
    Button mDingdanCreat;
    private CreateDingdanPresenter createDingdanPresenter;
    private String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingdan);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        price = intent.getStringExtra("price");
        mOrderPrice.setText("订单价格:"+ price);
    }

    @OnClick({R.id.order_price, R.id.dingdan_tuichu, R.id.dingdan_creat})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.order_price:
                break;
            case R.id.dingdan_tuichu:
                DingdanActivity.this.finish();
                break;
            case R.id.dingdan_creat:
                SharedPreferences pwk = getSharedPreferences("pwk",MODE_PRIVATE);
                String uid = pwk.getString("uid", "");
                createDingdanPresenter = new CreateDingdanPresenter(this);
                createDingdanPresenter.getcreateDingdans(uid,price);
                Intent intent = new Intent(DingdanActivity.this,DingdanListActivity.class);
                intent.putExtra("uid",uid);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onSuccess(CreateDingdanBean createDingdanBean) {
        Toast.makeText(this,createDingdanBean.getMsg(),Toast.LENGTH_SHORT).show();
        finish();
    }
}
