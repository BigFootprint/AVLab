package com.footprint.avlab.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.footprint.avlab.R;
import com.footprint.avlab.base.BJBaseActivity;
import com.footprint.avlab.base.BJBaseRVAdapter;

public class MainActivity extends BJBaseActivity {
    private RecyclerView recyclerView;
    private MainRepository mainRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        recyclerView = findViewById(R.id.rv_entry);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void loadData() {
        super.loadData();
        mainRepository = new MainRepository();

        BJBaseRVAdapter adapter = new MainEntryAdapter(mainRepository.getEntryList());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BJBaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(mainRepository.getEntryList().get(position).getUrl());
            }
        });
    }
}