package com.example.acer.lzh;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.acer.lzh.fragment.AlbumFragment;
import com.example.acer.lzh.fragment.BrandFragment;
import com.example.acer.lzh.fragment.CrowdfundingFragment;
import com.example.acer.lzh.fragment.PersonalFragment;
import com.example.acer.lzh.fragment.SearchFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    @ViewInject(R.id.lzh_main_rg)
    private RadioGroup radioGroup;
    @ViewInject(R.id.lzh_main_album)
    private RadioButton album;
    @ViewInject(R.id.lzh_main_search)
    private RadioButton search;
    @ViewInject(R.id.lzh_main_crowdfunding)
    private RadioButton crowdfunding;
    @ViewInject(R.id.lzh_main_brand)
    private RadioButton brand;
    @ViewInject(R.id.lzh_main_personal)
    private RadioButton personal;

    private FragmentManager manager;
    private List<Fragment>  data  ;
    private int currentIndex =0;

    private  AlbumFragment albumfragment ;
    private  SearchFragment searchfragment ;
    private   CrowdfundingFragment crowdfundingFragment;
    private   BrandFragment brandfragment;
    private  PersonalFragment personalfragment ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //进行xutils注册
        x.view().inject(this);
        //获取fragment的管理器
        manager= getSupportFragmentManager();
        //初始化fragment
        initFragment();
        //默认
        album.setChecked(true);
        //添加第一个fragment
        manager.beginTransaction().add(R.id.lzh_main_container,albumfragment).commit();
        radioGroup.setOnCheckedChangeListener(this);

    }

    private void initFragment() {
        data = new ArrayList<>();
         albumfragment = new AlbumFragment();
         searchfragment = new SearchFragment();
         crowdfundingFragment = new CrowdfundingFragment();
         brandfragment = new BrandFragment();
         personalfragment = new PersonalFragment();
        data.add(albumfragment);
        data.add(searchfragment);
        data.add(crowdfundingFragment);
        data.add(brandfragment);
        data.add(personalfragment);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case  R.id.lzh_main_album:
                switchFragment(0);
                break;
            case  R.id.lzh_main_search:
                switchFragment(1);
                break;
            case  R.id.lzh_main_crowdfunding:
                switchFragment(2);
                break;
            case  R.id.lzh_main_brand:
                switchFragment(3);
                break;
            case  R.id.lzh_main_personal:
                switchFragment(4);
                break;
        }
    }

    private void switchFragment(int targetIndex) {
        FragmentTransaction transaction=manager.beginTransaction();
        Fragment currentFragment = data.get(currentIndex);
        Fragment targetFragment = data.get(targetIndex);
        if (!targetFragment.isAdded()){
            transaction.add(R.id.lzh_main_container,targetFragment).hide(currentFragment).commit();
        }else {
            transaction.show(targetFragment).hide(currentFragment).commit();
        }
        currentIndex = targetIndex;

    }
}
