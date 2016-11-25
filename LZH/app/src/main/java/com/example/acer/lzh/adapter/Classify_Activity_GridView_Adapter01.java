package com.example.acer.lzh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.lzh.R;
import com.example.acer.lzh.bean.Classify_Activity_RecyclerView_Bean;

import org.xutils.x;

import java.util.List;

/**
 * Created by --Rain-- on 2016/11/22.
 */
public class Classify_Activity_GridView_Adapter01 extends BaseAdapter{

    private List<Classify_Activity_RecyclerView_Bean.CommoditysBean> data;
    private Context context;
    private boolean isSave = false;

    public Classify_Activity_GridView_Adapter01(List<Classify_Activity_RecyclerView_Bean.CommoditysBean> data, Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_classify_activity_gridview,parent,false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.item_classify_activity_gridView_image);
            holder.textView1 = (TextView) convertView.findViewById(R.id.item_classify_activity_gridView_text1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.item_classify_activity_gridView_text2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.item_classify_activity_gridView_text3);

            x.view().inject(holder,convertView);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView1.setText(data.get(position).getCommodityTitle());
        holder.textView2.setText("￥"+data.get(position).getPrice());
//        holder.textView3.setText(data.get(position).getCollect()+"");
        x.image().bind(holder.imageView,data.get(position).getBannerImg());


        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView1,textView2,textView3;
    }

}
