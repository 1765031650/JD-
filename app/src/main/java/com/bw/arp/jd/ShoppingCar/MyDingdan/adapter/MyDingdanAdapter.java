package com.bw.arp.jd.ShoppingCar.MyDingdan.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.arp.jd.R;
import com.bw.arp.jd.ShoppingCar.MyDingdan.bean.DingdanListBean;

import java.util.List;

/**
 * Created by ARP on 2018/4/22.
 */

public class MyDingdanAdapter extends RecyclerView.Adapter<MyDingdanAdapter.MyHolder>{
    private Context context;
    private List<DingdanListBean.DataBean> list;

    public MyDingdanAdapter(Context context, List<DingdanListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyDingdanAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.dingdan_adapter,null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyDingdanAdapter.MyHolder holder, final int position) {
        holder.tv.setText(list.get(position).getTitle()+"");
        holder.price.setText("价格是："+list.get(position).getPrice()+"");
        holder.time.setText("创建时间："+list.get(position).getCreatetime()+"");
        String status = list.get(position).getStatus();
        if (status.equals("0")){
            holder.bt1.setText("待支付");
            holder.bt2.setText("取消订单");
        }else if (status.equals("1")){
            holder.bt1.setText("已支付");
            holder.bt2.setText("查看订单");
        }else if (status.equals("2")){
            holder.bt1.setText("已取消");
            holder.bt2.setText("查看订单");
        }

        holder.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("提示");
                builder.setMessage("确定取消订单吗？");
                builder.setNegativeButton("取消",null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context,"取消成功",Toast.LENGTH_SHORT).show();
                        String uid = list.get(position).getUid();
                        String orderid = list.get(position).getOrderid();
                        String status = list.get(position).getStatus();
                    }
                });
                //显示！！！
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private final TextView tv;
        private final TextView price;
        private final TextView time;
        private final Button bt1;
        private final Button bt2;

        public MyHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            time = itemView.findViewById(R.id.time);
            bt1 = itemView.findViewById(R.id.bt1);
            bt2 = itemView.findViewById(R.id.bt2);
        }
    }
}
