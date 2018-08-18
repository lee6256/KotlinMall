package com.kotlin.user.presenter.view

import com.kotlin.base.presenter.view.BaseView
import com.kotlin.user.data.protocol.UserInfo

/**
 * Created by HelloWorld on 2018/5/27.
 */
interface LoginView: BaseView {
    fun onLoginResult(result: UserInfo)
}