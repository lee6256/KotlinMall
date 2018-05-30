package com.kotlin.user.injection.component

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.ui.activity.RegisterActivity
import dagger.Component

/**
 * Created by HelloWorld on 2018/5/29.
 */
@PerComponentScope
@Component(dependencies = [ActivityComponent::class], modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity: RegisterActivity)
}