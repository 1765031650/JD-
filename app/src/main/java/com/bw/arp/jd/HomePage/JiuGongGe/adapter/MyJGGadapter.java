package com.bw.arp.jd.HomePage.JiuGongGe.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.arp.jd.HomePage.JiuGongGe.bean.JGGBean;
import com.bw.arp.jd.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by ARP on 2018/4/17.
 */

public class MyJGGadapter extends RecyclerView.Adapter<MyJGGadapter.MyHolder>{
    private List<JGGBean.DataBean> list;
    private Context context;

    public MyJGGadapter(List<JGGBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //私有变量用于保存用户设置的监听器及其set方法
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    //定义recyclerView的点击事件接口
    public interface OnItemClickListener{
        void OnItemClick(View view,int postion);
    }

    @Override
    public MyJGGadapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.jgg_item,null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyJGGadapter.MyHolder holder, int position) {
        Uri uri = Uri.parse(list.get(position).getIcon());
        holder.jgg_img.setImageURI(uri);
        holder.jgg_content.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int layoutPosition = holder.getLayoutPosition();
                onItemClickListener.OnItemClick(holder.itemView,layoutPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView jgg_img;
        private final TextView jgg_content;

        public MyHolder(View itemView) {
            super(itemView);
            jgg_img = itemView.findViewById(R.id.jgg_img);
            jgg_content = itemView.findViewById(R.id.jgg_content);
        }
    }
}
