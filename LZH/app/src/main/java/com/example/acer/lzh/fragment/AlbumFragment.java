package com.example.acer.lzh.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.lzh.AlbumDetailActivity;
import com.example.acer.lzh.R;
import com.example.acer.lzh.adapter.Album_ViewPager_Adapter;
import com.example.acer.lzh.bean.Album_Bean;
import com.example.acer.lzh.transform.DepthPageTransformer;
import com.example.acer.lzh.url.Url;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 *页面---故事
 */
@ContentView(R.layout.fragment_album)
public class AlbumFragment extends Fragment {
    private int lastX =0;
    private int lastY =0;
    private int rawX=0;
    private int rawY=0;
    private int    offsetX ;
    private int offsetY ;
    @ViewInject(R.id.lzh_album_viewpager)
    private ViewPager  viewPager;

    private Album_ViewPager_Adapter adapter;
    private List<Album_Bean.AlbumsBean>  data ;
    public AlbumFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = x.view().inject(this,inflater,container);
        //下载数据
        getDataFromInternet();
        //初始化三要素
        initData();
        initAdapter();
//      这个值主要负责两边控件与中间控件的距离
        viewPager.setPageMargin(-130);
        viewPager.setOffscreenPageLimit(3);
        //设置缩放动画
        viewPager.setPageTransformer(false, new DepthPageTransformer());
        setViewPagerListener();
        return view;
    }

    private void setViewPagerListener() {
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        //获取手指落下的坐标并保存
                        rawX = (int)(event.getX());
                        rawY = (int)(event.getY());
                        break;
                    case MotionEvent.ACTION_UP:
                        lastX = (int)(event.getX());
                        lastY = (int)(event.getY());
                        offsetX=rawX-lastX;
                        offsetY=rawY-lastY;
                        if (offsetX<5 && offsetY<5 &&v instanceof ViewPager){
                            int position = viewPager.getCurrentItem();
                            Intent intent = new Intent(getActivity(), AlbumDetailActivity.class);
                            intent.putExtra("id",data.get(position).getAlbumId());
                            startActivity(intent);
                        }
                        break;
                }
                return false;
            }
        });
    }

    private void initAdapter() {
        adapter=new Album_ViewPager_Adapter(getActivity(),data);
        viewPager.setAdapter(adapter);
    }

    private void initData() {
        data = new ArrayList<>();
    }

    public void  getDataFromInternet() {
        RequestParams params = new RequestParams(Url.getAlbumPath());
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Album_Bean album_bean= gson.fromJson(result,Album_Bean.class);
                data.addAll(album_bean.getAlbums());
                initAdapter();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("加载失败",ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        }
    );
    }
}
