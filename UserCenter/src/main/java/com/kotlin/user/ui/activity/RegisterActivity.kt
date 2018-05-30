package com.kotlin.user.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.user.R
import com.kotlin.user.injection.component.DaggerUserComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    override fun onRegisterResult(result: Boolean) {
        toast("注册成功rx")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initInjection()

        mRegisterBtn.setOnClickListener {
            mPresenter.register(mMobileEt.text.toString(), mPwdEt.text.toString(), mVerifyCodeEt.text.toString())
        }
    }

    private fun initInjection() {
        DaggerUserComponent.builder()
                .activityComponent(activityComponent)
                .userModule(UserModule())
                .build()
                .inject(this)
        mPresenter.mView = this
    }
}
