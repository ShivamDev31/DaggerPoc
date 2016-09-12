package com.shivamdev.daggerpoc.di;

import com.shivamdev.daggerpoc.network.api.GitHubApi;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by shivam on 11/9/16.
 */

@Singleton
@Component(modules = {NetworkModule.class})
public interface AppComponent {

    GitHubApi getGitApi();
}
