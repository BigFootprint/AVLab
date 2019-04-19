package com.footprint.avlab.teclab.surfaceviewzoom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.footprint.avlab.R;

public class ZoomSurfaceViewActivity extends AppCompatActivity {
    private static final String TAG = "ZoomSurfaceViewActivity";

    private Button btnZoom;
    private SurfaceView surfaceView;
    private ViewGroup surfaceContainer;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_zoom_surfaceview);
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