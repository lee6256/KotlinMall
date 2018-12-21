package com.leeleg.pay.injection.module

import com.leeleg.pay.service.PayService
import com.leeleg.pay.service.impl.PayServiceImpl
import dagger.Module
import dagger.Provides

@Module
class PayModule {
    @Provides
    fun providesPayService(payService: PayServiceImpl): PayService {
        return payService
    }
}