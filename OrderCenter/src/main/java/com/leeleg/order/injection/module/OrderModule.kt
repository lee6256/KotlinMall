package com.leeleg.order.injection.module

import com.leeleg.order.service.OrderService
import com.leeleg.order.service.impl.OrderServiceImpl
import dagger.Module
import dagger.Provides

@Module
class OrderModule {
    @Provides
    fun providesGoodsService(orderService: OrderServiceImpl): OrderService {
        return orderService
    }
}