package com.footprint.avlab.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by quanmin.li on 2019/4/19
 */
public abstract class BJBaseRVAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    // Item 监听
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    protected OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(vh.itemView, i);
                }
            }
        });
    }
}