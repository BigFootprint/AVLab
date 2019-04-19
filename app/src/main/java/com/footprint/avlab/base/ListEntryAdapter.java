package com.footprint.avlab.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.footprint.avlab.R;
import com.footprint.avlab.main.EntryModel;
import com.footprint.avlab.utils.CollectionUtil;
import java.util.List;

/**
 * Created by quanmin.li on 2019/4/19
 */
public class ListEntryAdapter extends BJBaseRVAdapter<ListEntryAdapter.MyViewHolder> {
    private List<EntryModel> entryModels;

    public ListEntryAdapter(List<EntryModel> entryModels) {
        this.entryModels = entryModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_entry, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        super.onBindViewHolder(myViewHolder, i);
        myViewHolder.tvName.setText(entryModels.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return CollectionUtil.isEmpty(entryModels) ? 0 : entryModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
