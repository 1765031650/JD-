package com.bw.arp.jd.HomePage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.arp.jd.Activity.SearchActivity;
import com.bw.arp.jd.Activity.SousuoActivity;
import com.bw.arp.jd.Activity.WebActivity;
import com.bw.arp.jd.HomePage.Banner.bean.BannerBean;
import com.bw.arp.jd.HomePage.Banner.presenter.BannerPresenter;
import com.bw.arp.jd.HomePage.Banner.view.IBannerView;
import com.bw.arp.jd.HomePage.Bottom.adapter.MyBottomAdapter;
import com.bw.arp.jd.HomePage.Bottom.bean.BottomBean;
import com.bw.arp.jd.HomePage.Bottom.presenter.BottomPresenter;
import com.bw.arp.jd.HomePage.Bottom.view.IBottomView;
import com.bw.arp.jd.HomePage.JiuGongGe.adapter.MyJGGadapter;
import com.bw.arp.jd.HomePage.JiuGongGe.bean.JGGBean;
import com.bw.arp.jd.HomePage.JiuGongGe.presenter.JGGPresenter;
import com.bw.arp.jd.HomePage.JiuGongGe.view.IJGGView;
import com.bw.arp.jd.R;
import com.bw.arp.jd.Utils.MyImage;
import com.bw.arp.jd.Utils.NoticeView;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ARP on 2018/4/17.
 */

public class HomePage extends Fragment implements IBannerView, IJGGView, IBottomView {
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.rlv_01)
    RecyclerView mRlv01;
    @BindView(R.id.rlv_02)
    RecyclerView mRlv02;
    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.tv_miaosha)
    TextView mTvMiaosha;
    @BindView(R.id.tv_miaosha_time)
    TextView mTvMiaoshaTime;
    @BindView(R.id.tv_miaosha_shi)
    TextView mTvMiaoshaShi;
    @BindView(R.id.tv_miaosha_minter)
    TextView mTvMiaoshaMinter;
    @BindView(R.id.tv_miaosha_second)
    TextView mTvMiaoshaSecond;
    @BindView(R.id.NoticeView)
    NoticeView mNoticeView;
    private View view;
    private Unbinder unbinder;
    private BannerPresenter bannerPresenter;
    private List<BannerBean.DataBean> bannerBeanData;
    private String url;
    private JGGPresenter jggPresenter;
    private BottomPresenter bottomPresenter;
    private SearchActivity searchActivity;
    private ImageView img_sao;
    private TextView et_sou;
    private final static int REQUEST_CODE = 9999;
    //秒杀
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            setTime();
            handler.sendEmptyMessageDelayed(1, 1000);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage, container, false);
        unbinder = ButterKnife.bind(this, view);

        //实例化BannerP层
        bannerPresenter = new BannerPresenter(this);
        bannerPresenter.getDataBanner();
        //Banner的点击事件
        mBanner.setOnBannerListener(new OnBannerListener() {


            @Override
            public void OnBannerClick(int position) {
                url = bannerBeanData.get(position).getUrl();
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("Url", url);
                startActivity(intent);
            }
        });

        //实例九宫格的P层
        jggPresenter = new JGGPresenter(this);
        jggPresenter.getDataBanner();

        //实例化底部P层
        bottomPresenter = new BottomPresenter(this);
        bottomPresenter.getBottom();
        //二维码
        searchActivity = view.findViewById(R.id.myheader);
        img_sao = searchActivity.findViewById(R.id.img_sao);
        img_sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                getActivity().startActivityForResult(intent, REQUEST_CODE);
            }
        });
        //运动时权限
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //申请WRITE_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 1);
        }
        //搜索框
        et_sou = searchActivity.findViewById(R.id.edit_sou);
        et_sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SousuoActivity.class);
                startActivity(intent);
            }
        });
        handler.sendEmptyMessageDelayed(1, 1000);

        //京东快报
        List<String> notices = new ArrayList<>();
        notices.add("大促销下单拆福袋，亿万新年红包随便拿");
        notices.add("家电五折团，抢十亿无门槛现金红包");
        notices.add("星球大战剃须刀首发送200元代金券");
        notices.add("IPhone X 256GB狂跌近2000");
        mNoticeView.addNotice(notices);
        mNoticeView.startFlipping();

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.img)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img:
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("Url", url);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onSuccess(BannerBean bannerBean) {
        bannerBeanData = bannerBean.getData();
        Log.e("CODE", bannerBean.getMsg() + "");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < bannerBeanData.size(); i++) {
            String icon = bannerBeanData.get(i).getIcon().split("\\|")[0];
            list.add(icon);
        }
        mBanner.setImageLoader(new MyImage());
        mBanner.setDelayTime(3000);
        mBanner.setImages(list);
        mBanner.start();
    }

    @Override
    public void onFailed(BannerBean bannerBean) {

    }


    @Override
    public void onSuccess(JGGBean jggBean) {
        List<JGGBean.DataBean> jggBeanData = jggBean.getData();
        MyJGGadapter myJGGadapter = new MyJGGadapter(jggBeanData, getActivity());
        mRlv01.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.HORIZONTAL, false));
        mRlv01.setAdapter(myJGGadapter);
        myJGGadapter.setOnItemClickListener(new MyJGGadapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int postion) {
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("Url", url);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFailed(JGGBean jggBean) {

    }

    @Override
    public void onSuccess(final BottomBean bottomBean) {
        final List<BottomBean.TuijianBean.ListBean> bottomBeanData = bottomBean.getTuijian().getList();
        MyBottomAdapter bottomAdapter = new MyBottomAdapter(bottomBeanData, getActivity());
        mRlv02.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        mRlv02.setAdapter(bottomAdapter);
        bottomAdapter.setOnItemClickListener(new MyBottomAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                    String detailUrl = bottomBeanData.get(position).getDetailUrl();
                    Intent intent = new Intent(getActivity(), WebActivity.class);
                    intent.putExtra("detailUrl", detailUrl);
                    startActivity(intent);


            }
        });
    }

    @Override
    public void onFailed(BottomBean bottomBean) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getContext(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private void setTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String format = df.format(curDate);
        StringBuffer buffer = new StringBuffer();
        String substring = format.substring(0, 11);
        buffer.append(substring);
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour % 2 == 0) {
            mTvMiaoshaTime.setText(hour + "点场");
            buffer.append((hour + 2));
            buffer.append(":00:00");
        } else {
            mTvMiaoshaTime.setText((hour) + "点场");
            buffer.append((hour + 1));
            buffer.append(":00:00");
        }


        String totime = buffer.toString();
        try {
            Date date = df.parse(totime);
            Date date1 = df.parse(format);
            long defferenttime = date.getTime() - date1.getTime();
            long days = defferenttime / (1000 * 60 * 60 * 24);
            long hours = (defferenttime - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minute = (defferenttime - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
            long seconds = defferenttime % 60000;
            long second = Math.round((float) seconds / 1000);
            mTvMiaoshaShi.setText("0" + hours + "");
            if (minute >= 10) {
                mTvMiaoshaMinter.setText(minute + "");
            } else {
                mTvMiaoshaMinter.setText("0" + minute + "");
            }
            if (second >= 10) {
                mTvMiaoshaSecond.setText(second + "");
            } else {
                mTvMiaoshaSecond.setText("0" + second + "");
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (bannerPresenter!=null){
//            bannerPresenter.detachView();
//            bannerPresenter=null;
//            //解绑
//            CompositeSubscription subscription = new CompositeSubscription();
//            subscription.unsubscribe();
//        }
//    }
}
