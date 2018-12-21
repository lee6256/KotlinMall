package com.leeleg.pay.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.leeleg.pay.data.protocol.GetPaySignReq
import com.leeleg.pay.data.protocol.PayOrderReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface PayApi {
    @POST("pay/getPaySign")
    fun getPaySign(@Body req: GetPaySignReq): Observable<BaseResp<String>>

    @POST("order/pay")
    fun payOrder(@Body req: PayOrderReq): Observable<BaseResp<String>>
}