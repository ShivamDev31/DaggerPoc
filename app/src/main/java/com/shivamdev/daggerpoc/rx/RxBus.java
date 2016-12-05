package com.shivamdev.daggerpoc.rx;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by shivam on 2/12/16.
 */

public class RxBus<T> {

    private final Subject<T, T> bus;

    private RxBus() {
        bus = new SerializedSubject<>(PublishSubject.create());
    }

    public static RxBus getDefault() {
        return RxBusHolder.sInstance;
    }

    private static class RxBusHolder {
        private static final RxBus sInstance = new RxBus();
    }


    public void post(T t) {
        bus.onNext(t);
    }

    public <E> Observable<E> toObservable(Class<E> eventType) {
        return bus.ofType(eventType);
    }
}