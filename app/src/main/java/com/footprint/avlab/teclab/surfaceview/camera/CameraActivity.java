package com.footprint.avlab.teclab.surfaceview.camera;

import android.view.SurfaceView;
import com.footprint.avlab.R;
import com.footprint.avlab.base.BJBaseActivity;

/**
 * Created by quanmin.li on 2019/4/19
 */
public class CameraActivity extends BJBaseActivity {
    private SurfaceView sv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sv_camera;
    }

    @Override
    protected void initView() {
        super.initView();

        sv = findViewById(R.id.sv);
    }

    @Override
    protected void loadData() {
        super.loadData();
    }
}