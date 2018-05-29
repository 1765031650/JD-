package com.bw.arp.jd.HomePage.Sousuo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.arp.jd.HomePage.Sousuo.bean.mysousuogreendao.KeyWordBean;
import com.bw.arp.jd.R;

import java.util.List;

/**
 * Created by ARP on 2018/5/22.
 */

public class MyLSAdapter extends RecyclerView.Adapter<MyLSAdapter.MyHolder> {
    private List<KeyWordBean> list;
    private Context context;

    public MyLSAdapter(List<KeyWordBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyLSAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.ls_item,null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyLSAdapter.MyHolder holder, int position) {
        holder.tv.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private final TextView tv;
        public MyHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
