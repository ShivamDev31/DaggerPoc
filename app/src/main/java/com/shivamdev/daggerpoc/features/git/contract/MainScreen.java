package com.shivamdev.daggerpoc.features.git.contract;

import com.shivamdev.daggerpoc.commons.mvp.Screen;
import com.shivamdev.daggerpoc.network.data.GitData;

import java.util.List;

/**
 * Created by shivam on 5/12/16.
 */

public interface MainScreen extends Screen {

    void showLoader(int message);

    void hideLoader();

    void updateGitData(List<GitData> gitDatas);

    void showToast(int message);

    void showError();
}
