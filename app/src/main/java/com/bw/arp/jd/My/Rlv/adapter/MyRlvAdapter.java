package com.bw.arp.jd.My.Rlv.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.arp.jd.HomePage.Bottom.adapter.MyBottomAdapter;
import com.bw.arp.jd.My.Rlv.bean.RlvBean;
import com.bw.arp.jd.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by ARP on 2018/4/18.
 */

public class MyRlvAdapter extends RecyclerView.Adapter<MyRlvAdapter.MyHolder> {
    private List<RlvBean.TuijianBean.ListBean> list;
    private Context context;

    public MyRlvAdapter(List<RlvBean.TuijianBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private MyBottomAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(MyBottomAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    //点击事件接口
    public interface OnItemClickListener{
        void OnItemClick(View view,int position);
    }

    @Override
    public MyRlvAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.zfenlei_item,null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyRlvAdapter.MyHolder holder, final int position) {

        Uri uri = Uri.parse(list.get(position).getImages().split("\\|")[0]);
        holder.zfl_sdv.setImageURI(uri);
        holder.zfl_tv1.setText(list.get(position).getTitle());
        holder.zfl_tv2.setText("原价："+list.get(position).getPrice()+"");
        //中间横线
        holder.zfl_tv2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.zfl_tv3.setText("优惠价："+list.get(position).getBargainPrice()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        private final TextView zfl_tv1;
        private final TextView zfl_tv2;
        private final TextView zfl_tv3;
        private final SimpleDraweeView zfl_sdv;
        public MyHolder(View itemView) {
            super(itemView);
            zfl_tv1 = itemView.findViewById(R.id.zfl_tv1);
            zfl_tv2 = itemView.findViewById(R.id.zfl_tv2);
            zfl_tv3 = itemView.findViewById(R.id.zfl_tv3);
            zfl_sdv = itemView.findViewById(R.id.zfl_sdv);
        }
    }
}
