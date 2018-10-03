package com.kotlin.user.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.ForgetPwdView
import com.kotlin.user.service.UserService
import javax.inject.Inject

/**
 * Created by HelloWorld on 2018/5/27.
 */
class ForgetPwdPresenter @Inject constructor(): BasePresenter<ForgetPwdView>() {

    @Inject
    lateinit var userService: UserService

    fun forgetPwd(mobile: String, verifyCode: String) {
        if (!checkNetWork()) {
            println("无网络")
        }
        mView.showLoading()
        userService.forgetPwd(mobile, verifyCode)
                .execute(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        if (t) {
                            mView.onForgetPwdResult("验证成功")
                        }
                    }
                }, lifecycleProvider)
    }
}