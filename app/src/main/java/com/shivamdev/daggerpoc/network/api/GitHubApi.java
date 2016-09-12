package com.shivamdev.daggerpoc.network.api;

import com.shivamdev.daggerpoc.network.data.GitData;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by shivam on 11/9/16.
 */

public interface GitHubApi {

    @GET("/users/{username}/repos")
    Observable<List<GitData>> getUserRepos(@Path("username") String userName);
}
