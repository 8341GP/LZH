package com.example.acer.lzh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.lzh.adapter.Album_Detail_listview_Adapter;
import com.example.acer.lzh.bean.Album_Detail_Bean;
import com.example.acer.lzh.url.Url;
import com.example.acer.lzh.wedget.CustomListView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_album_detail)
public class AlbumDetailActivity extends AppCompatActivity {
    @ViewInject(R.id.item_album_detail_mianimage)
    private ImageView mainImage;
    @ViewInject(R.id.item_album_detail_albumTitle)
    private TextView title;
    @ViewInject(R.id.item_album_detail_albumSubTitle)
    private TextView subTitle;
    @ViewInject(R.id.item_album_detail_listview)
    private CustomListView listview;
    private List<Album_Detail_Bean.DetailsBean> data ;
    private Album_Detail_listview_Adapter adapter ;
    private Album_Detail_Bean album_Detail_Bean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        Intent intent = getIntent();
        int  id = intent.getIntExtra("id",0);
        initData();
        getDataFromInterner(id+"");
    }

    private void initData() {
        data = new ArrayList<>();
        adapter = new Album_Detail_listview_Adapter(data,this);
        listview.setAdapter(adapter);

    }

    public void getDataFromInterner(String id ) {
        RequestParams params = new RequestParams(Url.getAlbumDetail(id));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                album_Detail_Bean=gson.fromJson(result,Album_Detail_Bean.class);
                upDataUI(album_Detail_Bean );
                adapter.addAllDatas(album_Detail_Bean.getDetails());
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("下载失败", "onError: "+ex.toString() );
            }
            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {

            }
        });
    }
    //更新ui
    private void upDataUI(Album_Detail_Bean album_detail_bean) {
        setImage(Url.IMAGE_PATH+album_detail_bean.getAlbum().getMainImg(),mainImage);
        title.setText(album_detail_bean.getAlbum().getAlbumTitle());
        subTitle.setText(album_detail_bean.getAlbum().getAlbumSubTitle());

    }
    public void setImage(String url ,ImageView imageView ){
        Picasso.with(this)//获取对象
                .load(url)//下载地址
                .placeholder(R.mipmap.album_nopic)//现载时默认展示的图片
                .error(R.mipmap.album_nopic)//下载失败错误 展示的图片
                .into(imageView);//下载的图片展示的控件
    }
}
