package com.example.acer.lzh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.acer.lzh.adapter.Adapter_Special_ViewPager;
import com.example.acer.lzh.personalfragment.SpecialFragment;
import com.example.acer.lzh.personalfragment.StoreFragment;
import com.example.acer.lzh.personalfragment.StoryFragment;
import com.example.acer.lzh.personalfragment.WordFragment;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class SaveActivity extends AppCompatActivity {

    @ViewInject(R.id.special_viewPager)
    private ViewPager viewPager;
    @ViewInject(R.id.special_table)
    private TabLayout tabLayout;

    private StoryFragment storyFragment;
    private SpecialFragment specialFragment;
    private WordFragment wordFragment;
    private StoreFragment storeFragment;

    private List<Fragment> fragmentList;

    private Adapter_Special_ViewPager adapter_special_viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        x.view().inject(this);

        initData();

        TabLayout.Tab tab1 = tabLayout.newTab();
        TabLayout.Tab tab2 = tabLayout.newTab();
        TabLayout.Tab tab3 = tabLayout.newTab();
        TabLayout.Tab tab4 = tabLayout.newTab();

        //设置标题
        tab1.setText("故事");
        tab2.setText("字号");
        tab3.setText("定制");
        tab4.setText("商品");


        //设置未选中和选中时的字体的颜色
        tabLayout.setTabTextColors(Color.BLACK,Color.GREEN);

        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);
        tabLayout.addTab(tab3);
        tabLayout.addTab(tab4);

        adapter_special_viewPager = new Adapter_Special_ViewPager(getSupportFragmentManager(),fragmentList);

         viewPager.setAdapter(adapter_special_viewPager);

        //设置监听
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void initData() {

        fragmentList = new ArrayList<>();

        specialFragment = new SpecialFragment();
        storeFragment = new StoreFragment();
        storyFragment = new StoryFragment();
        wordFragment = new WordFragment();

        fragmentList.add(storyFragment);
        fragmentList.add(wordFragment);
        fragmentList.add(specialFragment);
        fragmentList.add(storeFragment);
    }
}
