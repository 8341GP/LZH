package com.example.acer.lzh.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acer.lzh.R;
import com.example.acer.lzh.SaveActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 *页面---我的
 */
@ContentView(R.layout.fragment_personal)
public class PersonalFragment extends Fragment {

    @ViewInject(R.id.personal_like_text)
    private TextView textView;

    public PersonalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = x.view().inject(this,inflater,container);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), SaveActivity.class);

                startActivity(intent);

            }
        });

        return view;
    }

}
