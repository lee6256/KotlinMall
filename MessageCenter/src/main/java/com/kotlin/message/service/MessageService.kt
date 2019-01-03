package com.kotlin.message.service

import com.kotlin.message.data.protocol.Message
import rx.Observable

interface MessageService {
    fun getMessageList(): Observable<MutableList<Message>?>
}