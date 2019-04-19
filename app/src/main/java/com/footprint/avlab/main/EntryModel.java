package com.footprint.avlab.main;

/**
 * Created by quanmin.li on 2019/4/19
 */
public class EntryModel {
    private String name;
    private String url;

    public EntryModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
