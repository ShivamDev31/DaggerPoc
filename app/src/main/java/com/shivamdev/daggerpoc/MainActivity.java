package com.shivamdev.daggerpoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shivamdev.daggerpoc.commons.DaggerApplication;
import com.shivamdev.daggerpoc.network.api.GitHubApi;
import com.shivamdev.daggerpoc.network.data.GitData;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compositeSubscription = new CompositeSubscription();

        final EditText etName = (EditText) findViewById(R.id.et_name);
        final TextView tvText = (TextView) findViewById(R.id.tv_text);
        final Button bSubmit = (Button) findViewById(R.id.b_submit);

        bSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString();
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(MainActivity.this, "Please enter the name.", Toast.LENGTH_LONG).show();
                return;
            }

            GitHubApi gitHubApi = DaggerApplication.getInstance().component().getGitApi();
            Subscription subs = gitHubApi.getUserRepos(name)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<List<GitData>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError: " + e);
                        }

                        @Override
                        public void onNext(List<GitData> gitDatas) {
                            tvText.setText("");
                            for (GitData data : gitDatas) {
                                tvText.append(data.toString());
                            }
                        }
                    });

            compositeSubscription.add(subs);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeSubscription.clear();
    }
}
