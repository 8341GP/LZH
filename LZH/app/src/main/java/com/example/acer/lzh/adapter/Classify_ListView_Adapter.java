package com.example.acer.lzh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.lzh.R;
import com.example.acer.lzh.bean.Classify_RecyclerView_Bean;
import com.example.acer.lzh.url.Url;

import org.xutils.x;

import java.util.List;

/**
 * Created by --Rain-- on 2016/11/22.
 */
public class Classify_ListView_Adapter extends BaseAdapter{
    private Context context;
    private List<Classify_RecyclerView_Bean.SubjectsBean> data;

    public Classify_ListView_Adapter(Context context, List<Classify_RecyclerView_Bean.SubjectsBean> data) {
        this.context = context;
        this.data = data;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_search_listview,parent,false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.item_search_listView_image);
            holder.textView1 = (TextView) convertView.findViewById(R.id.item_search_listView_text1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.item_search_listView_text2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.item_search_listView_text3);

            x.view().inject(holder,convertView);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView1.setText(data.get(position).getSubjectTitle());
        holder.textView2.setText(data.get(position).getSubjectTypeName());
        holder.textView3.setText(data.get(position).getTime());

        x.image().bind(holder.imageView, Url.IMAGE_PATH+data.get(position).getMainImg());

        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView1,textView2,textView3;
    }
}
