package com.example.acer.lzh.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.lzh.R;
import com.example.acer.lzh.adapter.Crowding_recycler_Adapter;
import com.example.acer.lzh.bean.Crowdfunding_Bean;
import com.example.acer.lzh.url.Url;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 页面--定制
 */
@ContentView(R.layout.fragment_crowdfunding)
public class CrowdfundingFragment extends Fragment implements PullToRefreshBase.OnRefreshListener2{
    @ViewInject(R.id.lzh_crowdfunding_recyclerview)
    private com.example.acer.lzh.wedget.PullToRefreshRecyclerView pullRecyclerView;
    private List<Crowdfunding_Bean.CrowdfundingBean>  data = new ArrayList<>();;
    private Crowding_recycler_Adapter adapter ;
    private RecyclerView recyclerView;
    private int index =1 ;
    public CrowdfundingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = x.view().inject(this,inflater,container);
        recyclerView = pullRecyclerView.getRefreshableView();
        getDataFromInterNet(index);
        return view;
    }

    public void getDataFromInterNet(int i) {
        RequestParams params = new RequestParams(Url.getCrowdfundingPath(i));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("111111111", "onSuccess: "+index );
                Gson gson = new Gson() ;
                Crowdfunding_Bean crowdfundingBean = gson.fromJson(result, Crowdfunding_Bean.class);
                data.addAll(crowdfundingBean.getCrowdfunding());
                if (index ==1){
                    setData_Adapter(crowdfundingBean);
                }else {
                    adapter.notifyDataSetChanged();
                    pullRecyclerView.onRefreshComplete();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("加载失败", "onError: "+ ex.toString() );
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void setData_Adapter( Crowdfunding_Bean crowdfundingBean) {

        adapter = new Crowding_recycler_Adapter(data,getActivity());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        pullRecyclerView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        pullRecyclerView.setOnRefreshListener(this);

    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
            return;
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        index++;
        getDataFromInterNet(index);
    }
}
