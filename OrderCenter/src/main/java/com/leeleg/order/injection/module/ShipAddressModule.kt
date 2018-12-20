package com.leeleg.order.injection.module

import com.leeleg.order.service.ShipAddressService
import com.leeleg.order.service.impl.ShipAddressServiceImpl
import dagger.Module
import dagger.Provides

@Module
class ShipAddressModule {
    @Provides
    fun providesShipAddressService(shipAddressService: ShipAddressServiceImpl): ShipAddressService {
        return shipAddressService
    }
}