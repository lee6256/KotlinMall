package com.leeleg.pay.injection.component

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.leeleg.pay.injection.module.PayModule
import com.leeleg.pay.ui.activity.CashRegisterActivity
import dagger.Component

@PerComponentScope
@Component(dependencies = [ActivityComponent::class], modules = [(PayModule::class)])
interface PayComponent {
    fun inject(activity: CashRegisterActivity)
}