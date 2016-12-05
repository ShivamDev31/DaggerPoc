package com.shivamdev.daggerpoc.di;

/**
 * Created by shivam on 5/12/16.
 */

public final class DaggerInjection {

    private static DaggerInjection injection;
    private AppComponent component;

    private DaggerInjection() {
        component = DaggerAppComponent.builder().build();
    }

    public static DaggerInjection getInstance() {
        if (injection == null) {
            injection = new DaggerInjection();
        }
        return injection;
    }

    public AppComponent component() {
        return component;
    }

}