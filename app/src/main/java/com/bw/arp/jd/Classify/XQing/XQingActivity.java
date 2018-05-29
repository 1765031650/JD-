package com.bw.arp.jd.Classify.XQing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bw.arp.jd.Activity.LoginActivity;
import com.bw.arp.jd.Classify.AddCar.bean.AddCarBean;
import com.bw.arp.jd.Classify.AddCar.presenter.AddPresenter;
import com.bw.arp.jd.Classify.AddCar.view.IAddView;
import com.bw.arp.jd.Classify.XQing.adapter.MyXQingAdapter;
import com.bw.arp.jd.Classify.XQing.bean.XQingBean;
import com.bw.arp.jd.Classify.XQing.presenter.XQPresenter;
import com.bw.arp.jd.Classify.XQing.view.IXQView;
import com.bw.arp.jd.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XQingActivity extends AppCompatActivity implements IXQView,IAddView{

    @BindView(R.id.XQ_rlv)
    RecyclerView mXQRlv;
    @BindView(R.id.bt_add)
    Button mBtAdd;
    private XQPresenter xqPresenter;
    private AddPresenter addPresenter;
    private SharedPreferences pwk;
    private boolean isLogin;
    private String pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xqing);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        xqPresenter = new XQPresenter(this);
        xqPresenter.getXQingDatas(pid,"android");

        addPresenter = new AddPresenter(this);
    }

    @OnClick(R.id.bt_add)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_add:
                pwk = getSharedPreferences("pwk",MODE_PRIVATE);
                isLogin = pwk.getBoolean("isLogin", false);
                if (isLogin){
                    String uid = pwk.getString("uid", "");
                    addPresenter.Addcar(uid,pid,"android");
                }else {
                    Toast.makeText(XQingActivity.this,"登录后才能添加哦~",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(XQingActivity.this, LoginActivity.class);
                    startActivity(intent);
                    XQingActivity.this.finish();
                }

        }
    }

    @Override
    public void onSuccess(XQingBean xQingBean) {
        MyXQingAdapter adapter = new MyXQingAdapter(xQingBean,XQingActivity.this);
        LinearLayoutManager manage = new LinearLayoutManager(this);
        mXQRlv.setLayoutManager(manage);
        mXQRlv.setAdapter(adapter);
    }

    @Override
    public void onFailed(XQingBean xQingBean) {

    }

    @Override
    public void onSuccess(AddCarBean addCarBean) {
        Toast.makeText(this,addCarBean.getMsg(),Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onFailed(AddCarBean addCarBean) {
        Toast.makeText(this,addCarBean.getMsg(),Toast.LENGTH_SHORT).show();
    }
}
