package com.example.acer.lzh;

import android.app.Application;

import org.xutils.x;

/**
 * Created by acer on 2016-11-19.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
