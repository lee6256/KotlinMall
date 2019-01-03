package com.kotlin.message.injection.component

import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.message.injection.module.MessageModule
import com.kotlin.message.ui.fragment.MessageFragment
import dagger.Component

@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)], modules = [(MessageModule::class)])
interface MessageComponent {
    fun inject(fragment: MessageFragment)
}