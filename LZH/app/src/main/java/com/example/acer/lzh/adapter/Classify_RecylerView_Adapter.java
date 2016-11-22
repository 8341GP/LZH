package com.example.acer.lzh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.lzh.R;
import com.example.acer.lzh.bean.Classify_RecyclerView_Bean;
import com.example.acer.lzh.url.Url;
import com.squareup.picasso.Picasso;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by --Rain-- on 2016/11/22.
 */
public class Classify_RecylerView_Adapter extends RecyclerView.Adapter<Classify_RecylerView_Adapter.ReViewHolder>{
    private static Context context;
    private static List<Classify_RecyclerView_Bean.SubjectTypesBean> data;

    public Classify_RecylerView_Adapter(Context context,List<Classify_RecyclerView_Bean.SubjectTypesBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ReViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ReViewHolder holder = new ReViewHolder(LayoutInflater.from(context).inflate(R.layout.item_search_recylerview,parent,false));

        return holder;
    }

    @Override
    public void onBindViewHolder(ReViewHolder holder, int position) {
        holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        setImage(Url.IMAGE_PATH+data.get(position).getMainImg(),holder.imageView);
        holder.textView.setText(data.get(position).getSubjectTypeTitle());
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }


    public static class ReViewHolder extends RecyclerView.ViewHolder{

        @ViewInject(R.id.item_search_recylerView_image)
        ImageView imageView;
        @ViewInject(R.id.item_search_recylerView_text)
        TextView textView;

        public ReViewHolder(View itemView) {
            super(itemView);
//            x.view().inject(ReViewHolder.this,itemView);
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
