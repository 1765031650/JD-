package com.bw.arp.jd.Classify.XQing.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.arp.jd.Activity.FangDaActivity;
import com.bw.arp.jd.Classify.XQing.bean.XQingBean;
import com.bw.arp.jd.R;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ARP on 2018/4/18.
 */

public class MyXQingAdapter extends RecyclerView.Adapter<MyXQingAdapter.MyHolder> {
    private XQingBean data;
    private Context context;
    ArrayList<String> list;

    public MyXQingAdapter(XQingBean data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public MyXQingAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.xqing_item,null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyXQingAdapter.MyHolder holder, int position) {
        String[] split = data.getData().getImages().split("\\|");

//        Uri uri = Uri.parse(list.get(position).getImages().split("\\|")[0]);
        list = new ArrayList<>();
        for (int i = 0; i <split.length ; i++) {
            list.add(split[i]);
        }

        holder.xq_banner.setImageLoader(new MyBanner());
        holder.xq_banner.setImages(Arrays.asList(split));
        holder.xq_banner.start();

        holder.tv1.setText(data.getData().getTitle());
        holder.tv2.setText("原价："+data.getData().getBargainPrice()+"");
        //中间横线
        holder.tv2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.tv3.setText("优惠价："+data.getData().getPrice()+"");
        holder.xq_banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
//                holder.xq_banner.setVisibility(View.GONE);
                Intent intent1 = new Intent(context,FangDaActivity.class);
                intent1.putStringArrayListExtra("list", (ArrayList<String>) list);
                context.startActivity(intent1);
            }
        });
        holder.xq_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView xq_img;
        private final Banner xq_banner;
        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;

        public MyHolder(View itemView) {
            super(itemView);
            xq_img = itemView.findViewById(R.id.XQ_img);
            xq_banner = itemView.findViewById(R.id.XQ_banner);
            tv1 = itemView.findViewById(R.id.XQ_name);
            tv2 = itemView.findViewById(R.id.XQ_price);
            tv3 = itemView.findViewById(R.id.XQ_youhui);
        }
    }
}
