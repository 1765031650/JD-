package com.bw.arp.jd.Classify.Right.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.arp.jd.Classify.Right.bean.RightBean;
import com.bw.arp.jd.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by ARP on 2018/4/15.
 */

public class Right_Adapter extends RecyclerView.Adapter<Right_Adapter.MyHolder>{
    private List<RightBean.DataBean.ListBean> list;
    private Context context;

    public Right_Adapter(List<RightBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    setOn setOnItemClick;



    public void setSetOnItemClick(setOn setOnItemClick) {
        this.setOnItemClick = setOnItemClick;
    }

    public interface setOn{
        void setonItem(int i, View view, String pscid);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.right_item,null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        Uri uri = Uri.parse(list.get(position).getIcon());
//        holder.right_simpledraweeview.setController(controller);
        holder.right_simpledraweeview.setImageURI(uri);
        holder.right_name.setText(list.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pscid = list.get(position).getPscid();
                setOnItemClick.setonItem(position,view,pscid);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
         private SimpleDraweeView right_simpledraweeview;
         private TextView right_name;
        public MyHolder(View itemView) {
            super(itemView);
            right_simpledraweeview = itemView.findViewById(R.id.right_simpledraweeview);
            right_name = itemView.findViewById(R.id.right_name);
        }
    }
}
