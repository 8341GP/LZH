package com.example.acer.lzh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.example.acer.lzh.adapter.Classify_Activity_RecyclerView_Adapter;
import com.example.acer.lzh.bean.Classify_Activity_RecyclerView_Bean;
import com.example.acer.lzh.url.Url;
import com.example.acer.lzh.wedget.MyGridView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class ClassifyActivity extends AppCompatActivity {

    private String path ="http://api.laozihaojia.com/icon/search.do?linkType=10&pageNum=20&pageIndex=1&linkId=";
    @ViewInject(R.id.classify_Activity_gridView)
    private MyGridView gridView;
    @ViewInject(R.id.classify_Activity_recyclerView)
    private RecyclerView recyclerView;
    @ViewInject(R.id.classifyActivity_Image)
    private ImageView imageView;

    private List<Classify_Activity_RecyclerView_Bean.BrandsBean>  activity_recyclerView_beenlist;
    private List<Classify_Activity_RecyclerView_Bean.CommoditysBean> commoditys_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify);

        x.view().inject(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("linkId");
        String name = intent.getStringExtra("lingName");
        String url = path+id+"&linkName="+name;

        Log.e("RAIN",url+"=================================");

        RequestParams params = new RequestParams(url);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Classify_Activity_RecyclerView_Bean activity_recyclerView_bean = gson.fromJson(result,Classify_Activity_RecyclerView_Bean.class);


                Picasso.with(ClassifyActivity.this).load(Url.IMAGE_PATH+activity_recyclerView_bean.getDetail().getImg()).into(imageView);


                activity_recyclerView_beenlist = new ArrayList<>();
                activity_recyclerView_beenlist.addAll(activity_recyclerView_bean.getBrands());
                Classify_Activity_RecyclerView_Adapter adapter = new Classify_Activity_RecyclerView_Adapter(ClassifyActivity.this,activity_recyclerView_beenlist);
                LinearLayoutManager manager =new LinearLayoutManager(ClassifyActivity.this);
                recyclerView.setAdapter(adapter);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(manager);


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

//        RequestParams params1 = new RequestParams(url);
//        x.http().get(params1, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
////                Gson gson = new Gson();
////                Classify_Activity_RecyclerView_Bean listViewBean = gson.fromJson(result,Classify_Activity_RecyclerView_Bean.class);
////                commoditys_list = new ArrayList<>();
////                commoditys_list.addAll(listViewBean.getCommoditys());
////                Classify_Activity_GridView_Adapter adapter = new Classify_Activity_GridView_Adapter(commoditys_list,ClassifyActivity.this);
////                gridView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });


    }
}
