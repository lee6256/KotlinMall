package com.leeleg.order.injection.component

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.leeleg.order.injection.module.ShipAddressModule
import com.leeleg.order.ui.activity.ShipAddressActivity
import com.leeleg.order.ui.activity.ShipAddressEditActivity
import dagger.Component

@PerComponentScope
@Component(dependencies = [ActivityComponent::class], modules = [(ShipAddressModule::class)])
interface ShipAddressComponent {
    fun inject(activity: ShipAddressEditActivity)
    fun inject(activity: ShipAddressActivity)
}