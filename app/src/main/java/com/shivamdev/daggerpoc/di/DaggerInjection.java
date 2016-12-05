package com.shivamdev.daggerpoc.di;

/**
 * Created by shivam on 5/12/16.
 */

public final class DaggerInjection {
    private static final AppComponent component = DaggerAppComponent.builder().build();

    public static AppComponent get() {
        return component;
    }
}