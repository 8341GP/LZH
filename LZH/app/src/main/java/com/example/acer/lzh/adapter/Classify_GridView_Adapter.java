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
import com.example.acer.lzh.bean.Classify_GridView_Bean;
import com.example.acer.lzh.url.Url;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by --Rain-- on 2016/11/21.
 */
public class Classify_GridView_Adapter extends BaseAdapter{
    private List<Classify_GridView_Bean.IconsBean> data;
    private Context context;

    public Classify_GridView_Adapter(List<Classify_GridView_Bean.IconsBean> data, Context context) {
        this.data = data;
        this.context = context;
        Log.e("111111111", "getView: "+data.size() );

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
        Log.e("111111111", "getView: "+data.size() );
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_search_gridview,parent,false);
            holder = new ViewHolder();
            x.view().inject(holder,convertView);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(data.get(position).getLinkName());


        if(data.get(position).getIconImg()!=null){
            x.image().bind(holder.imageView, Url.IMAGE_PATH+data.get(position).getIconImg());
        }else {

        }




        return convertView;
    }
    class ViewHolder{
        @ViewInject(R.id.item_search_gridView_image)
        ImageView imageView;
        @ViewInject(R.id.item_search_gridView_text)
        TextView textView;
    }
}
