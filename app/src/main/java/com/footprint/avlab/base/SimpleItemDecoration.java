package com.footprint.avlab.base;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.footprint.avlab.BJApplication;
import com.footprint.avlab.utils.ViewUtil;

/**
 * Created by quanmin.li on 2019/4/19
 */
public class SimpleItemDecoration extends RecyclerView.ItemDecoration {
    private Paint mPaint;
    private int dividerHeight;
    private int horPadding;

    public SimpleItemDecoration() {
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#CCCCCC"));

        dividerHeight = ViewUtil.dip2px(BJApplication.instance, 1);
        horPadding = ViewUtil.dip2px(BJApplication.instance, 15);
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount - 1; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = view.getBottom() + dividerHeight;
            c.drawRect(left + horPadding, top, right - horPadding, bottom, mPaint);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect,
                               @NonNull View view,
                               @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state) {
        outRect.bottom = dividerHeight;
    }
}
