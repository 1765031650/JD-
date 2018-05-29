package com.bw.arp.jd.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.arp.jd.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TuiChuActivity extends AppCompatActivity {

    @BindView(R.id.tv_tuichu)
    TextView mTvTuichu;
    @BindView(R.id.bt_tuichu)
    Button mBtTuichu;
    @BindView(R.id.geren_img_back)
    ImageView mGerenImgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tui_chu);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mTvTuichu.setText(username);
    }

    @OnClick({R.id.tv_tuichu, R.id.bt_tuichu, R.id.geren_img_back})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_tuichu:
                break;
            case R.id.bt_tuichu:
                SharedPreferences pwk = getSharedPreferences("pwk", MODE_PRIVATE);
                String username1 = pwk.getString("username", null);
                username1 = null;
                SharedPreferences.Editor editor = pwk.edit();
                editor.putString("username", username1);
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(this, "退出成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.geren_img_back:
                finish();
                break;
        }
    }
}
