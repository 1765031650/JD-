package com.bw.arp.jd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.bw.arp.jd.MainActivity;
import com.bw.arp.jd.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivity extends AppCompatActivity {
    private int recLen = 5;//跳过倒计时提示5秒
    @BindView(R.id.tv)
    TextView mTv;
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag,flag);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        timer.schedule(task,1000,1000);//等待时间一秒，停顿时间一秒
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //从闪屏界面跳转到首界面
                startActivity(new Intent(StartActivity.this,MainActivity.class));
                finish();
            }
        },5000);//延迟5S后发送handler信息
    }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recLen--;
                    mTv.setText("跳过 "+recLen);
                    if (recLen<0){
                        timer.cancel();
                        mTv.setVisibility(View.GONE);//倒计时到0隐藏字体

                    }
                }
            });
        }
    };
    @OnClick(R.id.tv)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv:
                startActivity(new Intent(StartActivity.this,MainActivity.class));
                finish();
                break;
        }
    }
}
