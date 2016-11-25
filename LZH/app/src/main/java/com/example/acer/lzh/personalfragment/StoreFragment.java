package com.example.acer.lzh.personalfragment;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.acer.lzh.R;
import com.example.acer.lzh.adapter.Classify_Activity_GridView_Adapter01;
import com.example.acer.lzh.bean.Classify_Activity_RecyclerView_Bean;
import com.example.acer.lzh.db.DbService;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoreFragment extends Fragment {

    private GridView gridView;
    private List<Classify_Activity_RecyclerView_Bean.CommoditysBean> data;
    private Cursor cursor;
    private DbService dbService;

    public StoreFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_store, container, false);


        gridView = (GridView) view.findViewById(R.id.personal_like_gridView);

        dbService = new DbService(getActivity());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        delectadapter(dbService);
    }

    private void delectadapter(DbService dbService) {

        data = new ArrayList<>();
        cursor = dbService.getcursor();
        while (cursor.moveToNext()){
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String icon = cursor.getString(cursor.getColumnIndex("icon"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String price = cursor.getString(cursor.getColumnIndex("price"));

            Classify_Activity_RecyclerView_Bean.CommoditysBean bean = new Classify_Activity_RecyclerView_Bean.CommoditysBean(price,icon,id,name);

            data.add(bean);

        }

        Classify_Activity_GridView_Adapter01 adapter = new Classify_Activity_GridView_Adapter01(data,getActivity());

        gridView.setAdapter(adapter);
    }
}
