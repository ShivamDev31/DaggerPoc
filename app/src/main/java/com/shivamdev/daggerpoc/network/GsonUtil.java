package com.shivamdev.daggerpoc.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by shivam on 11/9/16.
 */

public class GsonUtil {

    private static GsonUtil gsonUtil;
    private Gson gson;

    public static GsonUtil getInstance() {
        if (gsonUtil == null) {
            gsonUtil = new GsonUtil();
        }
        return gsonUtil;
    }

    private GsonUtil() {
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }

    public Gson getGson() {
        return gson;
    }
}
