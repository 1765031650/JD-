package com.bw.arp.jd.HomePage.Bottom.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.arp.jd.HomePage.Bottom.bean.BottomBean;
import com.bw.arp.jd.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by ARP on 2018/4/17.
 */

public class MyBottomAdapter extends RecyclerView.Adapter<MyBottomAdapter.MyHolder> {
    private List<BottomBean.TuijianBean.ListBean> list;
    private Context context;

    public MyBottomAdapter(List<BottomBean.TuijianBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    //点击事件接口
    public interface OnItemClickListener{
        void OnItemClick(View view,int position);
    }
    @Override
    public MyBottomAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.bottom_item,null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyBottomAdapter.MyHolder holder, final int position) {
        Uri uri = Uri.parse(list.get(position).getImages().split("\\|")[0]);
        holder.bottom_img.setImageURI(uri);
        holder.bottom_tv.setText(list.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pid = list.get(position).getPid();
                int layoutPosition = holder.getLayoutPosition();
                onItemClickListener.OnItemClick(view,layoutPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView bottom_img;
        private final TextView bottom_tv;
        public MyHolder(View itemView) {
            super(itemView);
            bottom_img = itemView.findViewById(R.id.bottom_img);
            bottom_tv = itemView.findViewById(R.id.bottom_tv);
        }
    }
}
