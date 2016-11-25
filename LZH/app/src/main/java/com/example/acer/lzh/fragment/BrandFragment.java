package com.example.acer.lzh.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.lzh.R;
import com.example.acer.lzh.adapter.Brand_Gallery_Adapter;
import com.example.acer.lzh.wedget.GalleryFlow;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 *页面---字号
 */
@ContentView(R.layout.fragment_brand)
public class BrandFragment extends Fragment {
    @ViewInject(R.id.lzh_brand_gallery)
    private GalleryFlow galleryFlow;
    private Brand_Gallery_Adapter  adapter;
    public BrandFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = x.view().inject(this,inflater,container);
        adapter = new Brand_Gallery_Adapter(getActivity());
        galleryFlow.setAdapter(adapter);
        return view;
    }

}
