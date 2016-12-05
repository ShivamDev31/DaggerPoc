package com.shivamdev.daggerpoc.commons.mvp;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by shivam on 5/12/16.
 */

public abstract class Presenter {

    private CompositeSubscription compositeSubscription;

    protected Presenter() {
        compositeSubscription = new CompositeSubscription();
    }

    public void addSubscription(Subscription subs) {
        compositeSubscription.add(subs);
    }

    public void destroyView() {
        compositeSubscription.clear();
    }
}