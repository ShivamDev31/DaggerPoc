package com.shivamdev.daggerpoc.di;

import com.shivamdev.daggerpoc.network.RetrofitAdapter;
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
    RetrofitAdapter provideRetrofitAdapter() {
        return RetrofitAdapter.getInstance();
    }

    @Provides @Singleton
    GitHubApi provideGitHubApi(RetrofitAdapter adapter) {
        return adapter.get().create(GitHubApi.class);
    }
}
