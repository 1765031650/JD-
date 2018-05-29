package com.bw.arp.jd.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.arp.jd.MainActivity;
import com.bw.arp.jd.My.Login.bean.LoginBean;
import com.bw.arp.jd.My.Login.presenter.LoginPresenter;
import com.bw.arp.jd.My.Login.view.ILoginView;
import com.bw.arp.jd.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.et_mobile)
    EditText mEtMobile;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.bt_login)
    Button mBtLogin;
    @BindView(R.id.bt_reg)
    TextView mBtReg;
    Button mBtQq;
    @BindView(R.id.login_imgback)
    ImageView mLoginImgback;
    private LoginPresenter loginPresenter;

    //    private static final String APP_ID = "1106853250";//官方获取的APPID
//    private Tencent mTencent;
//    private UserInfo mUserInfo;
//    private BaseUiListener mIUiListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //第三方qq登录
//        mTencent = Tencent.createInstance(APP_ID, LoginActivity.this.getApplicationContext());

    }

    @OnClick({R.id.bt_login, R.id.bt_reg, R.id.login_imgback})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_login:
                loginPresenter = new LoginPresenter(this);
                String mobile = mEtMobile.getText().toString();
                String password = mEtPassword.getText().toString();
                loginPresenter.getLoginData(mobile, password);
                break;
            case R.id.bt_reg:
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                LoginActivity.this.finish();
                break;
            case R.id.login_imgback:
                finish();
                break;
        }
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        Toast.makeText(this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
        String code = loginBean.getCode();
        String uid = loginBean.getData().getUid();
        String username = loginBean.getData().getUsername();
        if (code.equals("0")) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            SharedPreferences pwk = getSharedPreferences("pwk", MODE_PRIVATE);
            SharedPreferences.Editor editor = pwk.edit();
            editor.putBoolean("isLogin", true);
            editor.putString("uid", uid);
            editor.putString("username", username);
            editor.commit();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFailed(LoginBean loginBean) {
        Toast.makeText(this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

}
