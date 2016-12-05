package com.shivamdev.daggerpoc.features.git.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shivamdev.daggerpoc.R;
import com.shivamdev.daggerpoc.commons.BaseActivity;
import com.shivamdev.daggerpoc.di.DaggerInjection;
import com.shivamdev.daggerpoc.features.git.contract.MainScreen;
import com.shivamdev.daggerpoc.features.git.presenter.MainPresenter;
import com.shivamdev.daggerpoc.network.data.GitData;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainScreen {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.tv_text)
    TextView tvText;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerInjection.get().inject(this);
        presenter.initView(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.b_submit)
    void submitClick() {
        String name = etName.getText().toString();
        if (TextUtils.isEmpty(name)) {
            showToast(R.string.error_enter_name);
            return;
        }
        presenter.loadGitData(name);
    }

    @Override
    public void showLoader(int message) {
        showProgressDialog(getString(message));
    }

    @Override
    public void hideLoader() {
        hideProgressDialog();
    }

    @Override
    public void updateGitData(List<GitData> gitDatas) {
        tvText.setText("");
        for (GitData data : gitDatas) {
            tvText.append(data.toString());
        }
    }

    @Override
    public void showToast(int message) {
        Toast.makeText(this, getString(message), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        tvText.setText(R.string.error_loading_git_data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroyView();
    }
}