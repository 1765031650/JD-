package com.bw.arp.jd.My;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.arp.jd.Activity.LoginActivity;
import com.bw.arp.jd.Activity.TuiChuActivity;
import com.bw.arp.jd.Activity.WebActivity;
import com.bw.arp.jd.HomePage.Bottom.adapter.MyBottomAdapter;
import com.bw.arp.jd.MainActivity;
import com.bw.arp.jd.My.MyMessage.bean.MyMessageBean;
import com.bw.arp.jd.My.MyMessage.presenter.MessagePresenter;
import com.bw.arp.jd.My.MyMessage.view.IMessageView;
import com.bw.arp.jd.My.Rlv.adapter.MyRlvAdapter;
import com.bw.arp.jd.My.Rlv.bean.RlvBean;
import com.bw.arp.jd.My.Rlv.presenter.RlvPresenter;
import com.bw.arp.jd.My.Rlv.view.IRlvView;
import com.bw.arp.jd.R;
import com.bw.arp.jd.ShoppingCar.MyDingdan.DingdanListActivity;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ARP on 2018/4/17.
 */

public class My extends Fragment implements IRlvView, IMessageView {


    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static Uri tempUri;
    @BindView(R.id.my_image_sz)
    ImageView mMyImageSz;

    private Bitmap mBitmap;


    @BindView(R.id.tv_login)
    TextView mTvLogin;
    @BindView(R.id.img_dingdan)
    ImageView mImgDingdan;
    @BindView(R.id.my_relv)
    RecyclerView mMyRelv;
    @BindView(R.id.user_image)
    ImageView mUserImage;
    private View view;
    private Unbinder unbinder;
    private RlvPresenter rlvPresenter;
    private SharedPreferences pwk;
    private String uid;
    private MessagePresenter messagePresenter;
    private boolean isLogin;
    private String username;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my, container, false);
        unbinder = ButterKnife.bind(this, view);
        rlvPresenter = new RlvPresenter(this);
        rlvPresenter.getZFLData();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pwk = getContext().getSharedPreferences("pwk", getContext().MODE_PRIVATE);
        String uid = pwk.getString("uid", "");
        isLogin = pwk.getBoolean("isLogin", false);
        username = pwk.getString("username", "");
        messagePresenter = new MessagePresenter(this);
        messagePresenter.getMessageData(uid);

    }

    @Override
    public void onResume() {
        super.onResume();
        mTvLogin.setText("登录/注册>");

    }

    //    @Override
//    public void onResume() {
//        super.onResume();
//        if (isLogin) {
//            mTvLogin.setVisibility(View.INVISIBLE);
//            mTvReg.setVisibility(View.INVISIBLE);
//            mTv1.setVisibility(View.INVISIBLE);
//            mTv2.setVisibility(View.INVISIBLE);
//        }
//    }

    @OnClick({R.id.tv_login, R.id.img_dingdan, R.id.user_image, R.id.my_image_sz})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_login:
                    Intent intentlogin = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intentlogin);


                break;
            case R.id.img_dingdan:
                Intent intent = new Intent(getActivity(), DingdanListActivity.class);
                startActivity(intent);
                break;
            case R.id.user_image:
                mUserImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showChoosePicDialog();
//                        Toast.makeText(getContext(),"请登录",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
//            case R.id.tv_username:
//                Intent intent1 = new Intent(getActivity(), TuiChuActivity.class);
//                intent1.putExtra("username",username);
//                startActivity(intent1);
//                break;
            case R.id.my_image_sz:
                Intent intent1 = new Intent(getActivity(), TuiChuActivity.class);
                intent1.putExtra("username", username);
                startActivity(intent1);
                break;
        }
    }

    protected void showChoosePicDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("上传头像");
        String[] items = {"选择本地照片", "拍照"};
        builder.setNegativeButton("取消", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case CHOOSE_PICTURE:// 选择本地照片
                        Intent openAlbumIntent = new Intent(
                                Intent.ACTION_GET_CONTENT);
                        openAlbumIntent.setType("image/*");
                        //用startActivityForResult方法，待会儿重写onActivityResult()方法，拿到图片做裁剪操作
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;
                    case TAKE_PICTURE://拍照
                        Intent openCameraIntent = new Intent(
                                MediaStore.ACTION_IMAGE_CAPTURE);
                        tempUri = Uri.fromFile(new File(Environment
                                .getExternalStorageDirectory(), "temp_image.jpg"));
                        // 将拍照所得的相片保存到SD卡根目录
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                        startActivityForResult(openCameraIntent, TAKE_PICTURE);
                        break;
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == MainActivity.RESULT_OK) {
            switch (requestCode) {
                case TAKE_PICTURE:
                    cutImage(tempUri); // 对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    cutImage(data.getData()); // 对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 裁剪图片方法实现
     */
    protected void cutImage(Uri uri) {
        if (uri == null) {
            Log.i("alanjet", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        //com.android.camera.action.CROP这个action是用来裁剪图片用的
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }

    /**
     * 保存裁剪之后的图片数据
     */
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            mBitmap = extras.getParcelable("data");
            //这里图片是方形的，可以用一个工具类处理成圆形（很多头像都是圆形，这种工具类网上很多不再详述）
            mUserImage.setImageBitmap(mBitmap);//显示图片
            //在这个地方可以写上上传该图片到服务器的代码，后期将单独写一篇这方面的博客，敬请期待...
        }
    }

    @Override
    public void onSuccess(final RlvBean rlvBean) {
        List<RlvBean.TuijianBean.ListBean> lists = rlvBean.getTuijian().getList();
        MyRlvAdapter adapter = new MyRlvAdapter(lists, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mMyRelv.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        mMyRelv.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyBottomAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                String detailUrl2 = rlvBean.getTuijian().getList().get(position).getDetailUrl();
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("detailUrl2", detailUrl2);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFailed(RlvBean rlvBean) {

    }

    @Override
    public void onSuccess(MyMessageBean myMessageBean) {
//        Toast.makeText(getActivity(),myMessageBean.getMsg(),Toast.LENGTH_SHORT).show();
//        if (myMessageBean.getCode().equals("0")){
//            username = myMessageBean.getData().getUsername();
//            mTvUsername.setText(username);
//        }
        mTvLogin.setText(myMessageBean.getData().getUsername());
    }

    @Override
    public void onFailed(MyMessageBean myMessageBean) {

    }

    //解绑
    @Override
    public void onDestroy() {
        super.onDestroy();
        CompositeSubscription subscription = new CompositeSubscription();
        subscription.unsubscribe();
    }
}
