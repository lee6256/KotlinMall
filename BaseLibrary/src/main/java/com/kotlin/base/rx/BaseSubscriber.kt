package com.kotlin.base.rx

import com.kotlin.base.presenter.view.BaseView
import rx.Subscriber

/**
 * Created by HelloWorld on 2018/5/27.
 */
open class BaseSubscriber<T>(private val baseView: BaseView): Subscriber<T>() {
    override fun onCompleted() {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
        if (e is BaseException){
            baseView.onError(e.msg)
        }
    }

    override fun onNext(t: T) {
    }
}