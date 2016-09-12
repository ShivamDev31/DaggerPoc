package com.shivamdev.daggerpoc.commons;

import android.app.Application;

import com.shivamdev.daggerpoc.di.AppComponent;
import com.shivamdev.daggerpoc.di.DaggerAppComponent;

/**
 * Created by shivam on 11/9/16.
 */

public class DaggerApplication extends Application {

    private static DaggerApplication instance;
    private AppComponent component;

    public static DaggerApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        component = DaggerAppComponent.builder().build();
    }

    public AppComponent component() {
        return component;
    }
}
