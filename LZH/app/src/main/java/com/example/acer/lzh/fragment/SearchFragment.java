package com.example.acer.lzh.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.lzh.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * 页面---发现
 */
@ContentView(R.layout.fragment_search)
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = x.view().inject(this,inflater,container);
        return view;
    }

}
