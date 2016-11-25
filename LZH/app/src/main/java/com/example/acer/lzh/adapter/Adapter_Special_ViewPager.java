package com.example.acer.lzh.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by --Rain-- on 2016/11/9.
 */
public class Adapter_Special_ViewPager extends FragmentStatePagerAdapter{

    private List<Fragment> fragmentList;

    public Adapter_Special_ViewPager(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList!=null?fragmentList.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
