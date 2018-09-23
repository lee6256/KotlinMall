package com.kotlin.user.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.presenter.view.ForgetPwdView
import com.kotlin.user.presenter.view.UserInfoView
import com.kotlin.user.service.UserService
import javax.inject.Inject

/**
 * Created by HelloWorld on 2018/5/27.
 */
class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {

    @Inject
    lateinit var userService: UserService

    fun editUser(userIcon: String, userName: String, userGender: String, userSign: String) {
        if (!checkNetWork())
            return

        mView.showLoading()
        userService.editUser(userIcon, userName, userGender, userSign)
                .execute(object : BaseSubscriber<UserInfo>(mView) {
                    override fun onNext(t: UserInfo) {
                        mView.onEditUserResult(t)
                    }
                }, lifecycleProvider)
    }
}