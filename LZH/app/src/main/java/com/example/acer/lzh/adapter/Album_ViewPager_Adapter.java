package com.example.acer.lzh.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.acer.lzh.R;
import com.example.acer.lzh.bean.Album_Bean;
import com.example.acer.lzh.url.Url;
import com.squareup.picasso.Picasso;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by acer on 2016-11-22.
 */

public class Album_ViewPager_Adapter extends PagerAdapter{
    private Context context;
    private List<Album_Bean.AlbumsBean> data ;

    public Album_ViewPager_Adapter(Context context, List<Album_Bean.AlbumsBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main_viewpager,container,false);
        AblumViewPagerViewHolder holder = null;
        if (holder ==null){
            holder = new AblumViewPagerViewHolder();
        }
        //注入view
        x.view().inject(holder,view);
        holder.RelativeLayout.setTag(position);
        initUI(position,holder);
        view.setPadding(80, 80, 80, 80);
        container.addView(view);
        return view;
    }

    private void initUI(int position, AblumViewPagerViewHolder holder ) {
        //图片
        holder.mainImg.setScaleType(ImageView.ScaleType.FIT_XY);
        setImage(Url.IMAGE_PATH+data.get(position).getMainImg(),holder.mainImg);
        holder.ablumTitle.setText(data.get(position).getAlbumTitle());
        holder.brandName.setText(data.get(position).getBrandInfo().getBrandName());
        holder.brandDesc.setText(data.get(position).getBrandInfo().getBrandDesc());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (object instanceof  View){
            View view = (View) object;
            container.removeView(view);
        }
    }
    public void setImage(String url ,ImageView imageView ){
        Picasso.with(context)//获取对象
                .load(url)//下载地址
                .placeholder(R.mipmap.album_nopic)//现载时默认展示的图片
                .error(R.mipmap.album_nopic)//下载失败错误 展示的图片
                .into(imageView);//下载的图片展示的控件
    }
    class AblumViewPagerViewHolder{
        @ViewInject(R.id.item_album_viewpager_image)
        ImageView mainImg;
        @ViewInject(R.id.item_album_viewpager_albumTitle)
        TextView ablumTitle;
        @ViewInject(R.id.item_album_viewpager_brandName)
        TextView brandName;
        @ViewInject(R.id.item_album_viewpager_brandDesc)
        TextView brandDesc;
        @ViewInject(R.id.item_album_viewpager_relative)
        RelativeLayout RelativeLayout;
    }


}
