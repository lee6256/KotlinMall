package com.leeleg.order.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.leeleg.order.data.protocol.*
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface OrderApi {

    @POST("order/cancel")
    fun cancelOrder(@Body req: CancelOrderReq): Observable<BaseResp<String>>

    @POST("order/confirm")
    fun confirmOrder(@Body req: ConfirmOrderReq): Observable<BaseResp<String>>

    @POST("order/getOrderById")
    fun getOrderById(@Body req: GetOrderByIdReq): Observable<BaseResp<Order>>

    @POST("order/getOrderList")
    fun getOrderList(@Body req: GetOrderListReq): Observable<BaseResp<MutableList<Order>?>>

    @POST("order/submitOrder")
    fun submitOrder(@Body req: SubmitOrderReq): Observable<BaseResp<String>>
}