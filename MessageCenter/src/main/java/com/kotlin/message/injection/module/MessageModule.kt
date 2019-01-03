package com.kotlin.message.injection.module

import com.kotlin.message.service.MessageService
import com.kotlin.message.service.impl.MessageServiceImpl
import dagger.Module
import dagger.Provides

@Module
class MessageModule {

    @Provides
    fun providerMessageService(messageService: MessageServiceImpl): MessageService {
        return messageService
    }
}