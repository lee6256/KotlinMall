package com.leeleg.order.injection.component

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.leeleg.order.injection.module.OrderModule
import com.leeleg.order.ui.activity.OrderConfirmActivity
import dagger.Component

@PerComponentScope
@Component(dependencies = [ActivityComponent::class], modules = [(OrderModule::class)])
interface OrderComponent {
    fun inject(activity: OrderConfirmActivity)
}