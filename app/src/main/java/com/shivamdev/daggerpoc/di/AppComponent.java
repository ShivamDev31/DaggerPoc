package com.shivamdev.daggerpoc.di;

import com.shivamdev.daggerpoc.features.git.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by shivam on 11/9/16.
 */

@Singleton
@Component(modules = {NetworkModule.class})
public interface AppComponent {

    void inject(MainActivity activity);

}
