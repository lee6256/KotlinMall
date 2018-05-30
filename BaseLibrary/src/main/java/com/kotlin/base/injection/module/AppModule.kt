package com.kotlin.base.injection.module

import android.content.Context
import com.kotlin.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by HelloWorld on 2018/5/30.
 */
@Module
class AppModule(private val context: BaseApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }
}