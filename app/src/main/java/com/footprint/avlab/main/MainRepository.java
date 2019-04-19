package com.footprint.avlab.main;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by quanmin.li on 2019/4/19
 */
public class MainRepository {
    private List<EntryModel> entryModels;

    public MainRepository() {
        entryModels = new LinkedList<>();
        entryModels.add(new EntryModel("JNI", "jni"));
    }

    public List<EntryModel> getEntryList() {
        return entryModels;
    }
}