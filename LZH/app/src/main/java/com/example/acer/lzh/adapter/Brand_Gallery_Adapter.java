package com.example.acer.lzh.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.acer.lzh.R;

/**
 * Created by acer on 2016-11-24.
 */

public class Brand_Gallery_Adapter  extends BaseAdapter{
    private Context context;
    private  int [] image = new int [] {R.mipmap.customer_service,R.mipmap.customer_service,R.mipmap.customer_service,R.mipmap.customer_service,R.mipmap.customer_service,R.mipmap.customer_service,R.mipmap.customer_service,R.mipmap.customer_service,R.mipmap.customer_service,R.mipmap.customer_service,R.mipmap.customer_service,R.mipmap.customer_service,R.mipmap.customer_service,R.mipmap.customer_service};

    public Brand_Gallery_Adapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return image[position];
    }

    @Override
    public long getItemId(int position) {
        return image[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv = new ImageView(context);
        iv.setBackgroundColor(0xFFFFFFFF);
        iv.setImageResource(image[position]);// 给ImageView设置资源
        iv.setScaleType(ImageView.ScaleType.CENTER);// 设置对齐方式
        iv.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        return iv;
    }
}
