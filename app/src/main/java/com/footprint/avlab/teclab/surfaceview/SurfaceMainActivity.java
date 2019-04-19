package com.footprint.avlab.teclab.surfaceview;

import com.footprint.avlab.base.BJBaseListActivity;
import com.footprint.avlab.main.EntryModel;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by quanmin.li on 2019/4/19
 */
public class SurfaceMainActivity extends BJBaseListActivity {
    @Override
    protected List<EntryModel> getEntryList() {
        List<EntryModel> entryModels = new LinkedList<>();
        entryModels.add(new EntryModel("放缩", "svzoom"));
        return entryModels;
    }
}
