package com.kotlin.message.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.message.data.protocol.Message
import retrofit2.http.POST
import rx.Observable

interface MessageApi {
    @POST("msg/getList")
    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>>
}