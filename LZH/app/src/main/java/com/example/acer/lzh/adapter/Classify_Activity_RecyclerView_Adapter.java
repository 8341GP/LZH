package com.example.acer.lzh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.lzh.R;
import com.example.acer.lzh.bean.Classify_Activity_RecyclerView_Bean;
import com.example.acer.lzh.url.Url;
import com.squareup.picasso.Picasso;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by --Rain-- on 2016/11/22.
 */
public class Classify_Activity_RecyclerView_Adapter extends RecyclerView.Adapter<Classify_Activity_RecyclerView_Adapter.Re1ViewHolder>{

    private static Context context;
    private static List<Classify_Activity_RecyclerView_Bean.BrandsBean> data;

    public Classify_Activity_RecyclerView_Adapter(Context context,List<Classify_Activity_RecyclerView_Bean.BrandsBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public Re1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Re1ViewHolder holder = new Re1ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_classify_activity_recyclerview,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(Re1ViewHolder holder, int position) {
        holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        setImage(Url.IMAGE_PATH+data.get(position).getBrandImg(),holder.imageView);
        holder.textView.setText(data.get(position).getBrandName());
        Log.e("Rain---",data.get(position).getBrandName());
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    public static class Re1ViewHolder extends RecyclerView.ViewHolder{
        @ViewInject(R.id.item_classify_activity_recyclerView_image)
        ImageView imageView;
        @ViewInject(R.id.item_classify_activity_recyclerView_text)
        TextView textView;

        public Re1ViewHolder(View itemView) {
            super(itemView);
            x.view().inject(Re1ViewHolder.this,itemView);
        }
    }
    public void setImage(String url ,ImageView imageView ){
        Picasso.with(context)//获取对象
                .load(url)//下载地址
                .placeholder(R.mipmap.ic_launcher)//现载时默认展示的图片
                .error(R.mipmap.ic_launcher)//下载失败错误 展示的图片
                .into(imageView);//下载的图片展示的控件
    }

}
