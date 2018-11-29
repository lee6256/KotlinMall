package com.kotlin.base.common

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.base.injection.component.AppComponent
import com.kotlin.base.injection.component.DaggerAppComponent
import com.kotlin.base.injection.module.AppModule

/**
 * Created by HelloWorld on 2018/5/30.
 */
class BaseApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initAppInjection()

        context = this

        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        lateinit var context: Context
    }
}