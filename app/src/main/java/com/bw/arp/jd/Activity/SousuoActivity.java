package com.bw.arp.jd.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.arp.jd.HomePage.Sousuo.adapter.MyLSAdapter;
import com.bw.arp.jd.HomePage.Sousuo.bean.mysousuogreendao.KeyWordBean;
import com.bw.arp.jd.HomePage.Sousuo.presenter.SousuoPresenter;
import com.bw.arp.jd.R;
import com.bw.arp.jd.greendemo.DaoMaster;
import com.bw.arp.jd.greendemo.DaoSession;
import com.bw.arp.jd.greendemo.KeyWordBeanDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SousuoActivity extends AppCompatActivity {

    @BindView(R.id.img_fanhui)
    ImageView mImgFanhui;
    @BindView(R.id.edit_neirong)
    EditText mEditNeirong;
    @BindView(R.id.sousuo)
    TextView mSousuo;
    @BindView(R.id.sousuo_rlv)
    RecyclerView mSousuoRlv;
    @BindView(R.id.tv_clear)
    TextView mTvClear;
    private SousuoPresenter sousuoPresenter;
    private KeyWordBeanDao keyWordBeanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo);
        ButterKnife.bind(this);
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "pwk.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        keyWordBeanDao = daoSession.getKeyWordBeanDao();
        Queryy();
    }


    @OnClick({R.id.img_fanhui, R.id.sousuo, R.id.tv_clear})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img_fanhui:
                SousuoActivity.this.finish();
                break;
            case R.id.sousuo:
                //获取输入内容
                String keywords = mEditNeirong.getText().toString();
//                Log.e("AAAA",keywords+"");
                //得到数据
                if (keywords.equals("")) {
                    Toast.makeText(this, "请输入关键字~", Toast.LENGTH_SHORT).show();
                } else {
//                    sousuoPresenter.getSousuoData(keywords,"android");
                    KeyWordBean keyWordBean = new KeyWordBean(null, keywords);
                    //添加
                    long end = keyWordBeanDao.insert(keyWordBean);

                    Queryy();
                    Intent intent = new Intent(SousuoActivity.this, Sousuo2Activity.class);
                    intent.putExtra("keywords", keywords);
                    startActivity(intent);
                    this.finish();
                }

                break;
            case R.id.tv_clear:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示！");
                builder.setMessage("确定清楚历史搜索吗？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        keyWordBeanDao.deleteAll();
                        Queryy();
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.show();

                Queryy();
                break;
        }
    }

    private void Queryy() {
        //查询
        List<KeyWordBean> keyWordBeans = keyWordBeanDao.loadAll();
        MyLSAdapter adapter = new MyLSAdapter(keyWordBeans, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mSousuoRlv.setLayoutManager(linearLayoutManager);
        mSousuoRlv.setAdapter(adapter);
    }
}
