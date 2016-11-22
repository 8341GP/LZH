package com.example.acer.lzh.wedget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Rain on 2016-10-24.
 */

public class CustomViewPager extends ViewPager{
    private int lastX =0;
    private int lastY =0;
    private int rawX=0;
    private int rawY=0;
    private int    offsetX ;
    private int offsetY ;
    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean ret = super.dispatchTouchEvent(ev);
        if(ret)
        {
            requestDisallowInterceptTouchEvent(true);
        }
        return ret;
    }




}
