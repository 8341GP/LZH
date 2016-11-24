package com.example.acer.lzh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.lzh.adapter.Search_ListView_Activity_Adapter;
import com.example.acer.lzh.bean.Search_Activity_ListView_Bean;
import com.example.acer.lzh.url.Url;
import com.example.acer.lzh.wedget.CustomListView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class Search_ListView_Activity extends AppCompatActivity {

    private String path ="http://api.laozihaojia.com/subject/view.do?subjectId=";
    private String path2 = "&pageIndex=1&pageNum=10&_=1479478781900";

    private ImageView imageView;
    private TextView text1,text2;
    private CustomListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__list_view_);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);

        Log.e("DDDDDD",id+"");

        String url = path+id+path2;



        Log.e("BBBBBBBBBBBB",url+"");

        initView();

        RequestParams params = new RequestParams(url);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Search_Activity_ListView_Bean listViewBean = gson.fromJson(result,Search_Activity_ListView_Bean.class);

                text1.setText(listViewBean.getSubject().getSubjectTitle());
                text2.setText(listViewBean.getSubject().getSubjectSubTitle());

                Picasso.with(Search_ListView_Activity.this).load(Url.IMAGE_PATH+listViewBean.getSubject().getMainImg()).into(imageView);


                Search_ListView_Activity_Adapter adapter = new Search_ListView_Activity_Adapter(listViewBean.getDetails(),Search_ListView_Activity.this);
                listView.setAdapter(adapter);

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

    private void initView() {
        imageView = (ImageView) findViewById(R.id.search_listView_image);
        text1 = (TextView) findViewById(R.id.search_listView_text1);
        text2 = (TextView) findViewById(R.id.search_listView_text2);
        listView = (CustomListView) findViewById(R.id.search_listView_listView);
    }
}
