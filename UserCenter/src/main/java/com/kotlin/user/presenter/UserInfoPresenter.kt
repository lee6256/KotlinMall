package com.kotlin.user.presenter

import com.kotlin.base.common.BaseConstant
import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.presenter.view.ForgetPwdView
import com.kotlin.user.presenter.view.UserInfoView
import com.kotlin.user.service.UploadService
import com.kotlin.user.service.UserService
import com.qiniu.util.Auth
import javax.inject.Inject

/**
 * Created by HelloWorld on 2018/5/27.
 */
class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {

    @Inject
    lateinit var userService: UserService

    @Inject
    lateinit var uploadService: UploadService

    fun getUploadToken() {
        if (!checkNetWork())
            return

        mView.showLoading()
        uploadService.getUploadToken().execute(object : BaseSubscriber<String>(mView) {
            override fun onNext(t: String) {
                // 此处服务器获取的token有误，需改动服务器代码：com\module\user\controller\UploadController.java
                // 在客户端生成token
                val token = Auth.create(BaseConstant.ACCESS_KEY, BaseConstant.SECRET_KEY)
                        .uploadToken(BaseConstant.BUCKET_NAME)

                mView.onGetUploadTokenResult(token)
            }
        }, lifecycleProvider)
    }

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