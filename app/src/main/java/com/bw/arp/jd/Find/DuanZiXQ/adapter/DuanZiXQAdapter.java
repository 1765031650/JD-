package com.bw.arp.jd.Find.DuanZiXQ.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.arp.jd.Find.DuanZiXQ.bean.DuanziXQBean;
import com.bw.arp.jd.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by ARP on 2018/4/28.
 */

public class DuanZiXQAdapter extends RecyclerView.Adapter<DuanZiXQAdapter.MyHolder> {
    private DuanziXQBean list;
    private Context context;

    public DuanZiXQAdapter(DuanziXQBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public DuanZiXQAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.duanzixq_item,null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DuanZiXQAdapter.MyHolder holder, int position) {

        holder.tv_neirong.setText(list.getData().getContent());
        holder.tv_shijian.setText(list.getData().getCreateTime());
        String imgUrls = list.getData().getImgUrls();
        Uri uri = Uri.parse(imgUrls);
        holder.dz_slv.setImageURI(uri);
        String icon = list.getData().getUser().getIcon();
        Uri uri1 = Uri.parse(icon);
        holder.dz_vedio.setImageURI(uri1);

        holder.img_back.setOnClickListener(new View.OnClickListener() {
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

        private final ImageView img_xihuan;
        private final ImageView img_back;
        private final ImageView img_xiaoxi;
        private final ImageView img_fenxiang;
        private final SimpleDraweeView dz_vedio;
        private final SimpleDraweeView dz_slv;
        private final TextView tv_neirong;
        private final TextView tv_shijian;

        public MyHolder(View itemView) {
            super(itemView);
            img_xihuan = itemView.findViewById(R.id.img_xihuan);
            img_back = itemView.findViewById(R.id.img_back);
            img_xiaoxi = itemView.findViewById(R.id.img_xiaoxi);
            img_fenxiang = itemView.findViewById(R.id.img_fenxiang);
            dz_slv = itemView.findViewById(R.id.dz_slv);
            dz_vedio = itemView.findViewById(R.id.dz_vedio);
            tv_neirong = itemView.findViewById(R.id.tv_neirong);
            tv_shijian = itemView.findViewById(R.id.tv_shijian);
        }
    }
}
