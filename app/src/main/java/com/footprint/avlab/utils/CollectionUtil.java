package com.footprint.avlab.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by quanmin.li on 2019/4/19
 */
public class CollectionUtil {
    public static String toStr(final Collection<String> source, String split) {
        if (isEmpty(source)) {
            return "";
        }
        StringBuffer bfBuffer = new StringBuffer();
        for (String str : source) {
            bfBuffer.append(str).append(split);
        }
        String retValueString = bfBuffer.toString();
        return retValueString.substring(0, retValueString.length() - 1);
    }

    public static String toStr(final String[] source, String split) {
        if (isEmpty(source)) {
            return "";
        }
        return toStr(Arrays.asList(source), split);
    }

    public static String[] toArr(String source, String split) {
        if (TextUtils.isEmpty(source)) {
            return null;
        }
        return source.split(split);
    }

    public static ArrayList<String> toArrayList(String source, String split) {
        if (TextUtils.isEmpty(source)) {
            return null;
        }
        ArrayList<String> retList = new ArrayList<String>();
        toCollection(retList, source, split);
        return retList;
    }

    public static Set<String> toSet(String source, String split) {
        if (TextUtils.isEmpty(source)) {
            return null;
        }
        Set<String> set = new HashSet<String>();
        toCollection(set, source, split);
        return set;
    }

    private static void toCollection(Collection<String> collection, String source, String split) {
        collection.addAll(Arrays.asList(toArr(source, split)));
    }

    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Object[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.size() <= 0;
    }
}
