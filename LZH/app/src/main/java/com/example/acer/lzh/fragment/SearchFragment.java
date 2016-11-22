package com.example.acer.lzh.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.acer.lzh.ClassifyActivity;
import com.example.acer.lzh.R;
import com.example.acer.lzh.adapter.Classify_GridView_Adapter;
import com.example.acer.lzh.adapter.Classify_ListView_Adapter;
import com.example.acer.lzh.adapter.Classify_RecylerView_Adapter;
import com.example.acer.lzh.bean.Classify_GridView_Bean;
import com.example.acer.lzh.bean.Classify_RecyclerView_Bean;
import com.example.acer.lzh.wedget.CustomListView;
import com.example.acer.lzh.wedget.MyGridView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 页面---发现
 */
@ContentView(R.layout.fragment_search)
public class SearchFragment extends Fragment {

    @ViewInject(R.id.classify_recyclerView)
    private RecyclerView recyclerView;
    private List<Classify_RecyclerView_Bean.SubjectTypesBean> subjectTypesBeen;
    private Classify_RecylerView_Adapter recylerView_adapter;
    private Classify_RecyclerView_Bean recyclerView_bean;


    @ViewInject(R.id.classify_gridView)
    private MyGridView classify_gridView;

    @ViewInject(R.id.classify_listVIew)
    private CustomListView listView;
    private List<Classify_RecyclerView_Bean.SubjectsBean> subjectBean;
    private Classify_ListView_Adapter listView_Adapter;


    private String path = "http://api.laozihaojia.com/icon/hot.do";
    private String path1 = "http://api.laozihaojia.com/subject/list.do?needType=1&pageNum=20&pageIndex=1";

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = x.view().inject(this, inflater, container);


        initData();


        //-------------------------------------------------------------------------------------------


        //发现分类板块    GridView


        RequestParams params = new RequestParams(path);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();

                final Classify_GridView_Bean gridView = gson.fromJson(result, Classify_GridView_Bean.class);

                final Classify_GridView_Bean.IconsBean iconsBean = new Classify_GridView_Bean.IconsBean();

                iconsBean.setLinkName("更多");
                gridView.getIcons().add(iconsBean);
                Classify_GridView_Adapter adapter = new Classify_GridView_Adapter(gridView.getIcons(), getActivity());
                classify_gridView.setAdapter(adapter);
                classify_gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(), ClassifyActivity.class);
                        intent.putExtra("linkId", gridView.getIcons().get(position).getLinkId());
                        intent.putExtra("linkName", gridView.getIcons().get(position).getLinkName());
                        startActivity(intent);
                    }
                });
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


    //----------------------------------------------------------------------------------------------

    //发现美物志板块  RecyclerView
    //下面的ListView


    private void initData() {

        RequestParams params1 = new RequestParams(path1);
        x.http().get(params1, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();

                recyclerView_bean = gson.fromJson(result, Classify_RecyclerView_Bean.class);

                setRecycleViewData(recyclerView_bean);

                setListViewData(recyclerView_bean);
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
    }

    private void setListViewData(Classify_RecyclerView_Bean recyclerBean) {
        subjectBean = new ArrayList<>();
        subjectBean.addAll(recyclerBean.getSubjects());
        listView_Adapter = new Classify_ListView_Adapter(getActivity(), subjectBean);
        listView.setAdapter(listView_Adapter);
    }

    private void setRecycleViewData(Classify_RecyclerView_Bean recylerBean) {
        subjectTypesBeen = new ArrayList<>();
        subjectTypesBeen.addAll(recylerBean.getSubjectTypes());
        recylerView_adapter = new Classify_RecylerView_Adapter(getActivity(), subjectTypesBeen);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(recylerView_adapter);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
    }


}
