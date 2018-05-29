	package com.bw.arp.jd.Find.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.arp.jd.Find.bean.DuanziBean;
import com.bw.arp.jd.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * Created by ARP on 2018/4/26.
 */

public class MyDuanZiAdapter extends RecyclerView.Adapter<MyDuanZiAdapter.MyHolder> {
    private List<DuanziBean.DataBean> list;
    private Context context;

    public MyDuanZiAdapter(List<DuanziBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    private onDuaziItem onDuaziItemLinister;

    public void setOnDuaziItemLinister(onDuaziItem onDuaziItemLinister) {
        this.onDuaziItemLinister = onDuaziItemLinister;
    }

    public interface onDuaziItem{
        void setOnDuanzi(int i,View view,String jid);
    }

    @Override
    public MyDuanZiAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.duanzi_item,null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyDuanZiAdapter.MyHolder holder, final int position) {
        holder.tv_name.setText(list.get(position).getUser().getNickname()+"");
        holder.tv_time.setText(list.get(position).getCreateTime());
        holder.tv_duanzi.setText(list.get(position).getContent());
        holder.slv_touxiang.setImageURI(list.get(position).getUser().getIcon());
        holder.fb_xihuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"点击了喜欢",Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jid = list.get(position).getJid();
                onDuaziItemLinister.setOnDuanzi(position,view,jid);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView slv_touxiang;
        private final TextView tv_name;
        private final TextView tv_time;
        private final TextView tv_duanzi;
        private final FloatingActionButton fb_xihuan;
        private final FloatingActionButton fb_pinglun;
        private final FloatingActionButton fb_fenxiang;

        public MyHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_duanzi = itemView.findViewById(R.id.tv_duanzi);
            slv_touxiang = itemView.findViewById(R.id.slv_touxiang);
            fb_xihuan = itemView.findViewById(R.id.floating_button_xihuan);
            fb_pinglun = itemView.findViewById(R.id.floating_button_pinglun);
            fb_fenxiang = itemView.findViewById(R.id.floating_button_fenxiang);
        }
    }
}
