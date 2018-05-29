package com.bw.arp.jd.Classify.Right.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.arp.jd.Classify.Right.bean.RightBean;
import com.bw.arp.jd.Classify.Zifenlai.ZiFenLeiActivity;
import com.bw.arp.jd.R;

import java.util.List;

/**
 * Created by ARP on 2018/4/15.
 */

public class Right_Adapter2 extends RecyclerView.Adapter<Right_Adapter2.MyHolder> {
    private List<RightBean.DataBean> list;
    private Context context;

    public Right_Adapter2(List<RightBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.right_item2, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.right_name2.setText(list.get(position).getName());
        Right_Adapter adapter = new Right_Adapter(list.get(position).getList(),context);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3);
        holder.right_rlv2.setLayoutManager(gridLayoutManager);
        holder.right_rlv2.setAdapter(adapter);
        adapter.setSetOnItemClick(new Right_Adapter.setOn() {
            @Override
            public void setonItem(int i, View view, String pscid) {
//                Toast.makeText(context,pscid+"",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, ZiFenLeiActivity.class);
                intent.putExtra("pscid",pscid);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private final TextView right_name2;
        private final RecyclerView right_rlv2;
        public MyHolder(View itemView) {
            super(itemView);
            right_name2 = (TextView) itemView.findViewById(R.id.right_name2);
            right_rlv2 = (RecyclerView) itemView.findViewById(R.id.right_rlv2);
        }
    }
}
