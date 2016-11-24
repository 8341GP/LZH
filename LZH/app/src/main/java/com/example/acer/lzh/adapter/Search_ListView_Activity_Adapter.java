package com.example.acer.lzh.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.lzh.R;
import com.example.acer.lzh.bean.Search_Activity_ListView_Bean;
import com.example.acer.lzh.url.Url;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by --Rain-- on 2016/11/24.
 */
public class Search_ListView_Activity_Adapter extends BaseAdapter{

    private List<Search_Activity_ListView_Bean.DetailsBean> data;
    private Context context;

    public Search_ListView_Activity_Adapter(List<Search_Activity_ListView_Bean.DetailsBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_search_activity_listview,parent,false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.item_search_activity_listView_image);
            holder.textView = (TextView) convertView.findViewById(R.id.item_search_activity_listView_text);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(data.get(position).getContent());

        if(data.get(position).getImgUrl()!=null){

            Picasso.with(context).load(Url.IMAGE_PATH+data.get(position).getImgUrl()).into(holder.imageView);
//            Glide.with(context).load(Url.IMAGE_PATH+data.get(position).getImgUrl()).asGif().into(holder.imageView);
            Log.e("EEEEEEE",Url.IMAGE_PATH+data.get(position).getImgUrl());
        }




        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
