package com.kotlin.base.injection.component

import android.app.Activity
import com.kotlin.base.injection.ActivityScope
import com.kotlin.base.injection.module.ActivityModule
import dagger.Component

/**
 * Created by HelloWorld on 2018/5/30.
 */
@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun activity(): Activity
}