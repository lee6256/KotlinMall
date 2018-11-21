package com.kotlin.goods.injection.component

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.goods.injection.module.CategoryModule
import com.kotlin.goods.injection.module.GoodsModule
import com.kotlin.goods.ui.activity.GoodsActivity
import com.kotlin.goods.ui.fragment.CategoryFragment
import dagger.Component

@PerComponentScope
@Component(dependencies = [ActivityComponent::class], modules = arrayOf(GoodsModule::class))
interface GoodsComponent {
    fun inject(activity: GoodsActivity)
}