package com.footprint.avlab.base;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.footprint.avlab.R;
import com.footprint.avlab.main.EntryModel;
import java.util.List;

/**
 * List 入口的基础类，简单配置入口列表即可使用
 *
 * Created by quanmin.li on 2019/4/19
 */
public abstract class BJBaseListActivity extends BJBaseActivity {
    private RecyclerView recyclerView;
    private List<EntryModel> entryModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base_list;
    }

    @Override
    protected void initView() {
        super.initView();
        recyclerView = findViewById(R.id.rv_entry);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new SimpleItemDecoration());
    }

    @Override
    protected void loadData() {
        super.loadData();

        entryModels = getEntryList();

        BJBaseRVAdapter adapter = new ListEntryAdapter(getEntryList());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BJBaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                EntryModel model = entryModels.get(position);
                bundle.putString(KEY_TITLE, model.getName());
                startActivity(model.getUrl(), bundle);
            }
        });
    }

    protected abstract List<EntryModel> getEntryList();
}
