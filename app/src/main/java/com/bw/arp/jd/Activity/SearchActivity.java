package com.bw.arp.jd.Activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.arp.jd.R;

public class SearchActivity extends RelativeLayout {
    private ImageView img_message, img_sao;
    private Context mycon;
    private static TextView edit_sou;

    public SearchActivity(Context context) {
        this(context, null);
    }

    public SearchActivity(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchActivity(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //全局变量
        mycon = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.homepage_header, this, true);
//        edit_sou = view.findViewById(R.id.edit_sou);
//        img_message = view.findViewById(R.id.img_message);
//        img_sao = view.findViewById(R.id.img_sao);
//
//        img_message.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "消息", Toast.LENGTH_SHORT).show();
//            }
//        });
//        img_sao.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context,CaptureActivity.class);
//
//            }
//        });

    }
}
