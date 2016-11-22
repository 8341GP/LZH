package com.example.acer.lzh.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.lzh.R;
import com.example.acer.lzh.adapter.Classify_GridView_Adapter;
import com.example.acer.lzh.bean.Classify_GridView_Bean;
import com.example.acer.lzh.wedget.CustomListView;
import com.example.acer.lzh.wedget.MyGridView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * 页面---发现
 */
@ContentView(R.layout.fragment_search)
public class SearchFragment extends Fragment {

    @ViewInject(R.id.classify_recyclerView)
    private RecyclerView recyclerView;
    @ViewInject(R.id.classify_gridView)
    private MyGridView classify_gridView;
    @ViewInject(R.id.classify_listVIew)
    private CustomListView listView;

    private String path ="http://api.laozihaojia.com/icon/hot.do";
    private String path1 ="http://api.laozihaojia.com/subject/list.do?needType=1&pageNum=20&pageIndex=1";

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = x.view().inject(this,inflater,container);

        RequestParams params = new RequestParams(path);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();

                final Classify_GridView_Bean gridView = gson.fromJson(result,Classify_GridView_Bean.class);

                Classify_GridView_Bean.IconsBean iconsBean = new Classify_GridView_Bean.IconsBean();

                iconsBean.setLinkName("更多");

                gridView.getIcons().add(iconsBean);

                Classify_GridView_Adapter adapter = new Classify_GridView_Adapter(gridView.getIcons(),getActivity());

                classify_gridView.setAdapter(adapter);

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

        return view;
    }


}
