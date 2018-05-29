package com.bw.arp.jd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.bw.arp.jd.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String url = intent.getStringExtra("Url");
        String detailUrl = intent.getStringExtra("detailUrl");
        String detailUrl2 = intent.getStringExtra("detailUrl2");
        mWebview.loadUrl(url);
        mWebview.loadUrl(detailUrl);
        mWebview.loadUrl(detailUrl2);
    }
}
