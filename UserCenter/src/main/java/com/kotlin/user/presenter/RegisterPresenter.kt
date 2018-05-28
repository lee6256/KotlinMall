package com.kotlin.user.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.service.impl.UserServiceImpl

/**
 * Created by HelloWorld on 2018/5/27.
 */
class RegisterPresenter: BasePresenter<RegisterView>() {

    fun register(mobile: String, pwd: String, verifyCode: String) {

        val userService = UserServiceImpl()
        userService.register(mobile, pwd, verifyCode)
                .execute(object : BaseSubscriber<Boolean>() {
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                })
    }
}