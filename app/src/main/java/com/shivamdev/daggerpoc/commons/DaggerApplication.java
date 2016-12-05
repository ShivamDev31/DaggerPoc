package com.shivamdev.daggerpoc.commons;

import android.app.Application;

/**
 * Created by shivam on 11/9/16.
 */

public class DaggerApplication extends Application {

    private static DaggerApplication instance;

    public static DaggerApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }
}