package com.kotlin.user.presenter.view

import com.kotlin.base.presenter.view.BaseView

/**
 * Created by HelloWorld on 2018/5/27.
 */
interface RegisterView: BaseView {
    fun onRegisterResult(result: String)
}