package com.kotlin.base.rx

import rx.Subscriber

/**
 * Created by HelloWorld on 2018/5/27.
 */
open class BaseSubscriber<T>: Subscriber<T>() {
    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {
    }

    override fun onNext(t: T) {
    }
}