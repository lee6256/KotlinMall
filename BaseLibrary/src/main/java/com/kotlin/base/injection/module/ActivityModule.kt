package com.kotlin.base.injection.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by HelloWorld on 2018/5/30.
 */
@Singleton
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }
}