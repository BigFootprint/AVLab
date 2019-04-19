package com.footprint.avlab.base;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.footprint.avlab.R;

/**
 * Created by quanmin.li on 2019/4/19
 */
public abstract class BJBaseActivity extends AppCompatActivity {
    private static final String TAG = "BJBaseActivity";

    public static String KEY_TITLE = "intent_key_activity_title";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() == 0) {
            View view = new View(this);
            view.setBackgroundColor(Color.parseColor("#FF0000"));
            setContentView(view);
        } else {
            setContentView(getLayoutId());
        }

        // 基础 UI 设置
        addBg();

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            if (showBackButton()) {
                actionBar.setHomeButtonEnabled(true);
                actionBar.setDisplayHomeAsUpEnabled(true);
            }

            Intent intent = getIntent();
            if (intent != null) {
                String title = intent.getStringExtra(KEY_TITLE);
                if (!TextUtils.isEmpty(title)) {
                    actionBar.setTitle(title);
                }
            }
        }

        initView();
        loadData();
    }

    /**
     * 添加背景图片
     */
    private void addBg() {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.app_logo);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setAlpha(0.2f);
        ((ViewGroup) getWindow().getDecorView()).addView(imageView, 0);
    }

    protected boolean showBackButton() {
        return true;
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected void initView() {
    }

    protected void loadData() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * ========================== startActivity ==========================
     */
    /**
     * 1. xbl://  直接打开
     * 2.http(https)://www.baidu.com 打开网页
     * 3.home 当成打开应用内页面
     */
    protected String formatScheme(String scheme) {
        if (TextUtils.isEmpty(scheme)) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        if (scheme.startsWith("bj://")) {
            buffer.append(scheme);
        } else {
            if (scheme.startsWith("http") || scheme.startsWith("https")) {
                buffer.append("bj://web?url=");
                buffer.append(Uri.encode(scheme));
            } else {
                buffer.append("bj://");
                buffer.append(scheme);
            }
        }

        return buffer.toString();
    }

    protected void startActivity(String scheme) {
        this.startActivity(scheme, null);
    }

    protected void startActivity(String scheme, Bundle bundle) {
        try {
            Uri uri = Uri.parse(formatScheme(scheme));
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "start activity error.", e);
        }
    }

    protected void startActivityForResult(String scheme, int requestCode) {
        startActivityForResult(scheme, requestCode, null, null);
    }

    protected void startActivityForResult(String scheme, int requestCode, String key, Parcelable object) {
        try {
            Uri uri = Uri.parse(formatScheme(scheme));
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (!TextUtils.isEmpty(key)) {
                intent.putExtra(key, object);
            }
            startActivityForResult(intent, requestCode);
        } catch (Exception e) {
            Log.e(TAG, "start activity error.", e);
        }
    }
}
