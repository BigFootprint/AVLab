package com.footprint.avlab;

import android.app.Application;

/**
 * Created by quanmin.li on 2019/4/19
 */
public class BJApplication extends Application {
    public static BJApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }
}