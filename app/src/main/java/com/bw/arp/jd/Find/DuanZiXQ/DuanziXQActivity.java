package com.bw.arp.jd.Find.DuanZiXQ;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bw.arp.jd.Find.DuanZiXQ.adapter.DuanZiXQAdapter;
import com.bw.arp.jd.Find.DuanZiXQ.bean.DuanziXQBean;
import com.bw.arp.jd.Find.DuanZiXQ.presenter.DuanziXQPresenter;
import com.bw.arp.jd.Find.DuanZiXQ.view.DuanziXQView;
import com.bw.arp.jd.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DuanziXQActivity extends AppCompatActivity implements DuanziXQView{

    @BindView(R.id.DuanziXQ_rlv)
    RecyclerView mDuanziXQRlv;
    private DuanziXQPresenter duanziXQPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duanzi_xq);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        String jid = intent.getStringExtra("jid");
        Log.e("AAAAAAAAA",jid+"");

        duanziXQPresenter = new DuanziXQPresenter(this);
        duanziXQPresenter.getDuanziXQData(jid,"android","101");
    }

    @Override
    public void onSuccess(DuanziXQBean duanziXQBean) {
        DuanZiXQAdapter adapter = new DuanZiXQAdapter(duanziXQBean,DuanziXQActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mDuanziXQRlv.setLayoutManager(linearLayoutManager);
        mDuanziXQRlv.setAdapter(adapter);
    }

    @Override
    public void onFailed(DuanziXQBean duanziXQBean) {

    }
}
