package com.example.acer.lzh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.lzh.bean.CommodityBuy_Bean;
import com.example.acer.lzh.url.Url;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class CommodityBuyActivity extends AppCompatActivity {

    private String path = "http://api.laozihaojia.com/commodity/view.do?commodityId=";
    private String path1 = "&_=1480041621705";

    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private ImageView imageView;
    private TextView text1,text2,text3,text4,text5;

    private List<View> viewList = new ArrayList<>();


    private List<CommodityBuy_Bean.CommodityBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_buy);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String url = path+id+path1;

        initView();




        RequestParams params = new RequestParams(url);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                data = new ArrayList<CommodityBuy_Bean.CommodityBean>();

                Gson gson = new Gson();
                final CommodityBuy_Bean commoditybuy_Bean = gson.fromJson(result,CommodityBuy_Bean.class);

//                Log.e("AAAAAAAAAAAAAAAA",commoditybuy_Bean.toString()+"=============================================");
//                commoditybuy_Bean.getCommodity().getBannerImgs();
//
//                data.add(commoditybuy_Bean.getCommodity());

                for (int i = 0; i < commoditybuy_Bean.getCommodity().getBannerImgs().size(); i++) {

                    final String sss = commoditybuy_Bean.getCommodity().getBannerImgs().get(i);

                    Log.e("SSSSSSSSSSS",sss+"+++++++++++++++++++++++++");


                    ImageView image = new ImageView(CommodityBuyActivity.this);

                    Picasso.with(CommodityBuyActivity.this).load(sss).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(image);

                    viewList.add(image);

                }

                Special_ViewPager_Adapter adapter = new Special_ViewPager_Adapter();

                viewPager.setAdapter(adapter);


                Picasso.with(CommodityBuyActivity.this).load(Url.IMAGE_PATH+commoditybuy_Bean.getCommodity().getBrand().getBrandLogoImg()).into(imageView);

                Log.e("DDDDDDDDD",commoditybuy_Bean.getCommodity().getBrand().getBigLogoImg());


                text1.setText(commoditybuy_Bean.getCommodity().getCommodityTitle());
                text3.setText(commoditybuy_Bean.getCommodity().getBrand().getBrandName());
                text2.setText("￥"+commoditybuy_Bean.getCommodity().getPrice());

                text4.setText("始于"+commoditybuy_Bean.getCommodity().getBrand().getSince()+"年");

                text5.setText(commoditybuy_Bean.getCommodity().getBrand().getBrandDesc());




//                Log.e("AAAAAAAAAAAAAAAA",data.size()+"=============================================");











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

        viewPager = (ViewPager) findViewById(R.id.commodity_buy_viewPager);
        recyclerView = (RecyclerView) findViewById(R.id.commodity_buy_recyclerView);
        imageView = (ImageView) findViewById(R.id.commodity_buy_image1);
        text1 = (TextView) findViewById(R.id.commodity_buy_text1);
        text2 = (TextView) findViewById(R.id.commodity_buy_text2);
        text3 = (TextView) findViewById(R.id.commodity_buy_text3);
        text4 = (TextView) findViewById(R.id.commodity_buy_text4);
        text5 = (TextView) findViewById(R.id.commodity_buy_text5);

    }
    //ViewPager的适配器
    class Special_ViewPager_Adapter extends PagerAdapter {
        @Override
        public int getCount() {
            return viewList!=null?viewList.size():0;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View ret = null;
            ret = viewList.get(position);
            container.addView(ret);
            return ret;
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            if(object instanceof  View){
                View view = (View) object;
                container.removeView(view);
            }
        }
    }
}
