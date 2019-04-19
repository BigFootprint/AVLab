package com.footprint.avlab.main;

import com.footprint.avlab.base.BJBaseListActivity;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends BJBaseListActivity {
    @Override
    protected List<EntryModel> getEntryList() {
        List<EntryModel> entryModels = new LinkedList<>();
        entryModels.add(new EntryModel("JNI", "jni"));
        entryModels.add(new EntryModel("Surface", "sv"));
        return entryModels;
    }
}