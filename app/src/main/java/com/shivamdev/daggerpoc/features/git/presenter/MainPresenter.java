package com.shivamdev.daggerpoc.features.git.presenter;

import com.shivamdev.daggerpoc.R;
import com.shivamdev.daggerpoc.commons.mvp.Presenter;
import com.shivamdev.daggerpoc.features.git.contract.MainScreen;
import com.shivamdev.daggerpoc.network.api.GitHubApi;
import com.shivamdev.daggerpoc.network.data.GitData;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by shivam on 5/12/16.
 */

public class MainPresenter extends Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName();
    private GitHubApi gitHubApi;
    private MainScreen screen;

    @Inject
    MainPresenter(GitHubApi gitApi) {
        this.gitHubApi = gitApi;
    }

    public void initView(MainScreen screen) {
        this.screen = screen;
    }

    public void loadGitData(String name) {
        screen.showLoader(R.string.loading);
        Subscription subs = gitHubApi.getUserRepos(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<GitData>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        screen.hideLoader();
                        screen.showError();
                    }

                    @Override
                    public void onNext(List<GitData> gitDatas) {
                        screen.hideLoader();
                        screen.updateGitData(gitDatas);
                    }
                });

        addSubscription(subs);
    }
}