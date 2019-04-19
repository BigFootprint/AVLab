package com.footprint.avlab.utils;

import android.content.Context;

/**
 * Created by quanmin.li on 2019/4/19
 */
public class ViewUtil {
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}