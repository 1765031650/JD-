package com.bw.arp.jd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.arp.jd.My.Reg.bean.RegBean;
import com.bw.arp.jd.My.Reg.presenter.RegPresenter;
import com.bw.arp.jd.My.Reg.view.IRegView;
import com.bw.arp.jd.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegActivity extends AppCompatActivity implements IRegView {

    @BindView(R.id.reg_et_mobile)
    EditText mEtMobile;
    @BindView(R.id.reg_et_password)
    EditText mEtPassword;
    @BindView(R.id.reg_bt)
    Button mBtReg;
    @BindView(R.id.reg_login)
    TextView mBtLiLogin;
    @BindView(R.id.reg_imgback)
    ImageView mRegImgback;
    @BindView(R.id.reg_yan)
    TextView mRegYan;
    private RegPresenter regPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.reg_bt, R.id.reg_login, R.id.reg_imgback, R.id.reg_yan})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.reg_bt:
                regPresenter = new RegPresenter(this);
                String mobile = mEtMobile.getText().toString();
                String password = mEtPassword.getText().toString();
                regPresenter.getRegData(mobile, password);
                break;
            case R.id.reg_login:
                Intent intent = new Intent(RegActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.reg_imgback:
                finish();
                break;
            case R.id.reg_yan:
                Toast.makeText(this, "暂未开放该功能", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onSuccess(RegBean regBean) {
        String code = regBean.getCode();
        if (code.equals("0")) {
            Toast.makeText(this, regBean.getMsg(), Toast.LENGTH_SHORT).show();
            RegActivity.this.finish();
        } else {
            Toast.makeText(this, regBean.getMsg(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onFailed(RegBean regBean) {
        Toast.makeText(this, regBean.getMsg(), Toast.LENGTH_SHORT).show();
    }
}
