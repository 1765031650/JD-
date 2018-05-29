package com.bw.arp.jd.Classify.Zifenlai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bw.arp.jd.Classify.XQing.XQingActivity;
import com.bw.arp.jd.Classify.Zifenlai.adapter.MyZiFenLeiAdapter;
import com.bw.arp.jd.Classify.Zifenlai.bean.ZifenLBean;
import com.bw.arp.jd.Classify.Zifenlai.presenter.ZPresenter;
import com.bw.arp.jd.Classify.Zifenlai.view.ZFLIView;
import com.bw.arp.jd.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZiFenLeiActivity extends AppCompatActivity implements ZFLIView {

    @BindView(R.id.zfl_rlv)
    RecyclerView mZflRlv;
    private ZPresenter zPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zi_fen_lei);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String pscid = intent.getStringExtra("pscid");
        zPresenter = new ZPresenter(this);
        zPresenter.getZFLData(pscid);
    }

    @Override
    public void onSuccess(ZifenLBean zifenLBean) {
        List<ZifenLBean.DataBean> zifenLBeanData = zifenLBean.getData();
        MyZiFenLeiAdapter adapter = new MyZiFenLeiAdapter(zifenLBeanData, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mZflRlv.setLayoutManager(manager);
        mZflRlv.setAdapter(adapter);
        adapter.setOnZFLItemLinister(new MyZiFenLeiAdapter.onZFLItem() {
            @Override
            public void setOnZFl(int i, View view, String pid) {
                //Toast.makeText(ZiFenLeiActivity.this,"Pid是："+pid,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ZiFenLeiActivity.this, XQingActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onFailed(ZifenLBean zifenLBean) {

    }
}
