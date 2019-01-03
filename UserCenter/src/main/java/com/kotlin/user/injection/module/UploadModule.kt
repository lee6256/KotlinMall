package com.kotlin.user.injection.module

import com.kotlin.user.service.UploadService
import com.kotlin.user.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by HelloWorld on 2018/5/29.
 */

@Module
class UploadModule {
    @Provides
    fun providesUploadService(service: UploadServiceImpl): UploadService {
        return service
    }
}