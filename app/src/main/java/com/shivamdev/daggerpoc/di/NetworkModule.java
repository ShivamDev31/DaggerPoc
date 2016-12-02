package com.shivamdev.daggerpoc.di;

import com.shivamdev.daggerpoc.network.RetrofitAdapter;
import com.shivamdev.daggerpoc.network.api.GitApi;
import com.shivamdev.daggerpoc.network.api.GitHubApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shivam on 11/9/16.
 */

@Module
public class NetworkModule {

    @Provides @Singleton
    public GitHubApi provideGitHubApi() {
        return RetrofitAdapter.getInstance().get().create(GitHubApi.class);
    }

    @Provides @Singleton
    public GitApi provideGitApi() {
        return RetrofitAdapter.getInstance().get().create(GitApi.class);
    }
}
