package com.kotlin.user.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.ForgetPwdView
import com.kotlin.user.presenter.view.ResetPwdView
import com.kotlin.user.service.UserService
import javax.inject.Inject

/**
 * Created by HelloWorld on 2018/5/27.
 */
class ResetPwdPresenter @Inject constructor(): BasePresenter<ResetPwdView>() {

    @Inject
    lateinit var userService: UserService

    fun resetPwd(mobile: String, pwd: String) {
        if (!checkNetWork()) {
            println("无网络")
        }
        mView.showLoading()
        userService.resetPwd(mobile, pwd)
                .execute(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        if (t) {
                            mView.onResetPwdResult("重置成功")
                        }
                    }
                }, lifecycleProvider)
    }
}