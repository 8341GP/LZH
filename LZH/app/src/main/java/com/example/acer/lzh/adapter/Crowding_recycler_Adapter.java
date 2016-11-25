package com.example.acer.lzh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.acer.lzh.R;
import com.example.acer.lzh.bean.Crowdfunding_Bean;
import com.example.acer.lzh.url.Url;
import com.squareup.picasso.Picasso;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by acer on 2016-11-25.
 */

public class Crowding_recycler_Adapter extends RecyclerView.Adapter<Crowding_recycler_Adapter.ReViewHolder>{
    private List<Crowdfunding_Bean.CrowdfundingBean> data ;
    private Context context;

    public Crowding_recycler_Adapter(List<Crowdfunding_Bean.CrowdfundingBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ReViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ReViewHolder holder = new ReViewHolder(LayoutInflater.from(context).inflate(R.layout.item_crowd_recyclerview,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ReViewHolder holder, int position) {
        holder.mainImage.setScaleType(ImageView.ScaleType.FIT_XY);
            setImage(Url.IMAGE_PATH+data.get(position).getMainImg(),holder.mainImage);
        holder.title.setText(data.get(position).getTitle());
        holder.originator.setText(data.get(position).getOriginator());
        holder.introduction.setText(data.get(position).getIntroduction());
        holder.textLike.setText("￥"+data.get(position).getTargetMoney());
        holder.textGet.setText("￥"+data.get(position).getMoney());
        holder.textPay.setText(data.get(position).getSupport()+"");
        holder.finish.setMax(100);
        holder.finish.setProgress(data.get(position).getFinish());
    }

    @Override
    public int getItemCount() {
        return data!=null ?data.size():0;
    }

    /**
     * 创建一个viewholder
     */
    public static class ReViewHolder extends RecyclerView.ViewHolder{
        @ViewInject(R.id.item_crowd_mainImage)
        ImageView  mainImage;
        @ViewInject(R.id.item_crowd_title)
        TextView title;
        @ViewInject(R.id.item_crowd_originator)
        TextView originator;
        @ViewInject(R.id.item_crowd_introduction)
        TextView introduction;
        @ViewInject(R.id.item_crowd_finish)
        ProgressBar finish;
        @ViewInject(R.id.item_crowd_text_like)
        TextView textLike;
        @ViewInject(R.id.item_crowd_text_get)
        TextView textGet;
        @ViewInject(R.id.item_crowd_text_pay)
        TextView textPay;
        public ReViewHolder(View itemView) {
            super(itemView);
            x.view().inject(ReViewHolder.this,itemView);
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
