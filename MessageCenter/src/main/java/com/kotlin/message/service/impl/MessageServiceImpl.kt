package com.kotlin.message.service.impl

import com.kotlin.base.ext.convert
import com.kotlin.message.data.protocol.Message
import com.kotlin.message.data.repository.MessageRepository
import com.kotlin.message.service.MessageService
import rx.Observable
import javax.inject.Inject

class MessageServiceImpl @Inject constructor(): MessageService {

    @Inject
    lateinit var repository: MessageRepository

    override fun getMessageList(): Observable<MutableList<Message>?> {
        return repository.getMessageList().convert()
    }
}