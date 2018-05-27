package com.kotlin.base.presenter

import com.kotlin.base.presenter.view.BaseView

/**
 * Created by HelloWorld on 2018/5/27.
 */
open class BasePresenter<T: BaseView> {
    lateinit var mView: T
}