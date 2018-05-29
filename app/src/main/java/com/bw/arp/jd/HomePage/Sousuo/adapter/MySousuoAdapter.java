package com.bw.arp.jd.HomePage.Sousuo.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.arp.jd.HomePage.Sousuo.bean.SousuoBean;
import com.bw.arp.jd.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by ARP on 2018/4/28.
 */

public class MySousuoAdapter extends RecyclerView.Adapter<MySousuoAdapter.MyHolder>{
    private List<SousuoBean.DataBean> list;
    private Context context;

    public MySousuoAdapter(List<SousuoBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    private onSousuoItem onSousuoItemLinister;

    public void setOnSousuoItemLinister(onSousuoItem onSousuoItemLinister) {
        this.onSousuoItemLinister = onSousuoItemLinister;
    }

    public interface onSousuoItem{
        void setOnSousuo(int i,View view,String pid);
    }

    @Override
    public MySousuoAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.sousuo_item,null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MySousuoAdapter.MyHolder holder, final int position) {
        Uri uri = Uri.parse(list.get(position).getImages().split("\\|")[0]);
        holder.sousuo_sdv.setImageURI(uri);
        holder.sousuo_tv1.setText(list.get(position).getTitle());
        holder.sousuo_tv2.setText("原价："+list.get(position).getPrice()+"");
        holder.sousuo_tv2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.sousuo_tv3.setText("优惠价："+list.get(position).getBargainPrice()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pid = list.get(position).getPid();
                onSousuoItemLinister.setOnSousuo(position,view,pid);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private final TextView sousuo_tv1;
        private final TextView sousuo_tv2;
        private final TextView sousuo_tv3;
        private final SimpleDraweeView sousuo_sdv;
        public MyHolder(View itemView) {
            super(itemView);
            sousuo_tv1 = itemView.findViewById(R.id.sousuo_tv1);
            sousuo_tv2 = itemView.findViewById(R.id.sousuo_tv2);
            sousuo_tv3 = itemView.findViewById(R.id.sousuo_tv3);
            sousuo_sdv = itemView.findViewById(R.id.sousuo_sdv);
        }
    }
}
