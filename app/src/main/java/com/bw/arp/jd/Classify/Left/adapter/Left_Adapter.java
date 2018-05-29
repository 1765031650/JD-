package com.bw.arp.jd.Classify.Left.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.arp.jd.Classify.Left.bean.LeftBean;
import com.bw.arp.jd.R;

import java.util.List;

/**
 * Created by ARP on 2018/4/15.
 */

public class Left_Adapter extends RecyclerView.Adapter<Left_Adapter.MyHolder>{

    private List<LeftBean.DataBean> list;
    private Context context;

    public Left_Adapter(List<LeftBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public interface setOn{
        void Itemlisten(int position, String cid, View view);
    }
    setOn onClicklistener;

    public void setOnClicklistener(setOn onClicklistener) {
        this.onClicklistener = onClicklistener;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.left_item, null);
        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.tv.setText(list.get(position).getName()+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cid = list.get(position).getCid();
                onClicklistener.Itemlisten(position,cid,view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        private final TextView tv;

        public MyHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.left_name);
        }
    }
}
