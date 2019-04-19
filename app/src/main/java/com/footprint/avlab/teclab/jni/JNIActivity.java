package com.footprint.avlab.teclab.jni;

import android.os.Bundle;
import com.footprint.avlab.base.BJBaseActivity;

/**
 * Created by quanmin.li on 2019/4/19
 */
public class JNIActivity extends BJBaseActivity {
    static {
        System.loadLibrary("audioencoder");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Mp3Endocder endocder = new Mp3Endocder();
        endocder.encode();
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
