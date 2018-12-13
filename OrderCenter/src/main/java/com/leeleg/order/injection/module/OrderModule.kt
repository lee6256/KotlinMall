package com.leeleg.order.injection.module

import com.leeleg.order.service.OrderService
import com.leeleg.order.service.impl.OrderServiceImpl
import dagger.Module

@Module
class OrderModule {
    fun providesGoodsService(orderService: OrderServiceImpl): OrderService {
        return orderService
    }
}