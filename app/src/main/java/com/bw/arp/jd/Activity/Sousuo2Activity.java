package com.bw.arp.jd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bw.arp.jd.Classify.XQing.XQingActivity;
import com.bw.arp.jd.HomePage.Sousuo.adapter.MySousuoAdapter;
import com.bw.arp.jd.HomePage.Sousuo.bean.SousuoBean;
import com.bw.arp.jd.HomePage.Sousuo.presenter.SousuoPresenter;
import com.bw.arp.jd.HomePage.Sousuo.view.ISousuoView;
import com.bw.arp.jd.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Sousuo2Activity extends AppCompatActivity implements ISousuoView {

    @BindView(R.id.img_fanhui)
    ImageView mImgFanhui;
    @BindView(R.id.edit_neirong)
    EditText mEditNeirong;
    @BindView(R.id.sousuo2_rlv)
    RecyclerView mSousuo2Rlv;
    private SousuoPresenter sousuoPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo2);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String keywords = intent.getStringExtra("keywords");
        sousuoPresenter = new SousuoPresenter(this);
        sousuoPresenter.getSousuoData(keywords,"android");
        mEditNeirong.setText(keywords);
    }

    @Override
    public void onSuccess(SousuoBean sousuoBean) {
        List<SousuoBean.DataBean> data = sousuoBean.getData();
        MySousuoAdapter adapter = new MySousuoAdapter(data,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mSousuo2Rlv.setLayoutManager(linearLayoutManager);
        mSousuo2Rlv.setAdapter(adapter);
        adapter.setOnSousuoItemLinister(new MySousuoAdapter.onSousuoItem() {
            @Override
            public void setOnSousuo(int i, View view, String pid) {
                Intent intent = new Intent(Sousuo2Activity.this, XQingActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onFailed(Exception e) {
        Log.e("TAG",e.getMessage());
    }

    @OnClick(R.id.img_fanhui)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img_fanhui:
                finish();
                break;
        }
    }
}
