package com.footprint.avlab.teclab.surfaceview.zoom;

import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.footprint.avlab.R;
import com.footprint.avlab.base.BJBaseActivity;

public class ZoomSurfaceViewActivity extends BJBaseActivity {
    private static final String TAG = "ZoomSurfaceViewActivity";

    private Button btnZoom;
    private SurfaceView surfaceView;
    private ViewGroup surfaceContainer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zoom_surfaceview;
    }

    @Override
    protected void initView() {
        super.initView();

        surfaceContainer = findViewById(R.id.surface_holder);

        surfaceView = findViewById(R.id.surfaceview);
        surfaceView.getHolder().setSizeFromLayout();
        btnZoom = findViewById(R.id.btn_zoom);

        btnZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, surfaceView.getWidth() + " # " + surfaceView.getHeight());

                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) surfaceView.getLayoutParams();
                params.setMargins(20, 20, 20, 20);
                params.width = 1000;
                params.height = 2000;
                surfaceContainer.setLayoutParams(params);
            }
        });
    }
}