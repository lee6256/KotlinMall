package com.kotlin.message.data.repository


import javax.inject.Inject

import rx.Observable
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.message.data.api.MessageApi
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.message.data.protocol.Message

class MessageRepository @Inject constructor() {

    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>> {
        return RetrofitFactory.instance.create(MessageApi::class.java).getMessageList()
    }
}
