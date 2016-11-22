package com.example.acer.lzh.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.lzh.R;
import com.example.acer.lzh.bean.Album_Detail_Bean;
import com.example.acer.lzh.url.Url;
import com.squareup.picasso.Picasso;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by acer on 2016-11-22.
 */

public class Album_Detail_listview_Adapter extends MyBaseAdapter<Album_Detail_Bean.DetailsBean> {
    /**
     * 构造方法
     * 获取数据,上下文对象
     *
     * @param datas
     * @param context
     */
    private List<Album_Detail_Bean.DetailsBean> data ;
    private Context context;

    public Album_Detail_listview_Adapter(List<Album_Detail_Bean.DetailsBean> datas, Context context) {
        super(datas, context);
        this.data=datas;
        this.context =context;
    }

    @Override
    public int getItemViewType(int position) {
        int  t=data.get(position).getType();
        if (t==1){
            //图片
            return  0;
        }else if (t ==2 ){
            //链接
           return  1;

        }else if (t ==3 ){
            //文字
           return  2;
        }
        return super.getItemViewType(position);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        int type =0;
        if (data.get(position).getType() ==2){
            type=1;
        }else if (data.get(position).getType() ==3){
            type=2;
        }
        Album_DetailViewHolder1 holder1=null;
        Album_DetailViewHolder2 holder2=null;
        Album_DetailViewHolder3 holder3=null;
        if (convertView ==null){
            if (type==0){
                //图片
              convertView=  getLaytoutInflater().inflate(R.layout.item_ablum_listview_type1,parent,false);
                holder1 = new Album_DetailViewHolder1();
                x.view().inject(holder1,convertView);
                convertView.setTag(holder1);
            }else if (type ==1){
                //链接
                convertView=  getLaytoutInflater().inflate(R.layout.item_ablum_listview_type2,parent,false);
                holder2 = new Album_DetailViewHolder2();
                x.view().inject(holder2,convertView);
                convertView.setTag(holder2);

            }else if(type ==2){
                //文字
                convertView=  getLaytoutInflater().inflate(R.layout.item_ablum_listview_type3,parent,false);
                holder3 = new Album_DetailViewHolder3();
                x.view().inject(holder3,convertView);
                convertView.setTag(holder3);
            }
        }else {
            if (type==0){
                //图片
              holder1 = (Album_DetailViewHolder1) convertView.getTag();
            }else if (type ==1){
                //链接
                holder2 = (Album_DetailViewHolder2) convertView.getTag();
            }else if(type ==2){
                //文字
                holder3 = (Album_DetailViewHolder3) convertView.getTag();
            }
        }
        if (type==0){
            //图片
            setImage(Url.IMAGE_PATH+data.get(position).getImgUrl(),holder1.imageView1);
            holder1.content1.setText(data.get(position).getContent());
        }else if (type ==1){
            //链接
            setImage(Url.IMAGE_PATH+data.get(position).getImgUrl(),holder2.imageView2);
            holder2.title2.setText(data.get(position).getTitle());
            holder2.price2.setText("￥"+data.get(position).getPrice());
        }else if(type ==2){
            //文字
            holder3.content3.setText(data.get(position).getContent());

        }
        return convertView;
    }
    @Override
    public int getViewTypeCount() {
        return 3;
    }
    class Album_DetailViewHolder1 {
        @ViewInject(R.id.item_album_type1_image)
        ImageView imageView1;
        @ViewInject(R.id.item_album_type1_content)
        TextView  content1;
    }

    class Album_DetailViewHolder2 {
        @ViewInject(R.id.item_album_type2_image)

        ImageView imageView2;
        @ViewInject(R.id.item_album_type2_title)

        TextView title2;
        @ViewInject(R.id.item_album_type2_price)

        TextView price2;

    }

    class Album_DetailViewHolder3 {
        @ViewInject(R.id.item_album_type3_content)

        TextView content3;

    }
    public void setImage(String url ,ImageView imageView ){
        Picasso.with(context)//获取对象
                .load(url)//下载地址
                .placeholder(R.mipmap.album_nopic)//现载时默认展示的图片
                .error(R.mipmap.album_nopic)//下载失败错误 展示的图片
                .into(imageView);//下载的图片展示的控件
    }

}
