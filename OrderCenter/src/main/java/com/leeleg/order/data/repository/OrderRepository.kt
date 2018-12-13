package com.leeleg.order.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.leeleg.order.data.api.OrderApi
import com.leeleg.order.data.protocol.*
import retrofit2.http.Body
import rx.Observable
import javax.inject.Inject

class OrderRepository @Inject constructor() {

    fun cancelOrder(@Body req: CancelOrderReq): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(OrderApi::class.java).cancelOrder(req)
    }

    fun confirmOrder(@Body req: ConfirmOrderReq): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(OrderApi::class.java).confirmOrder(req)
    }

    fun getOrderById(@Body req: GetOrderByIdReq): Observable<BaseResp<Order>> {
        return RetrofitFactory.instance.create(OrderApi::class.java).getOrderById(req)
    }

    fun getOrderList(@Body req: GetOrderListReq): Observable<BaseResp<MutableList<Order>?>> {
        return RetrofitFactory.instance.create(OrderApi::class.java).getOrderList(req)
    }

    fun submitOrder(@Body req: SubmitOrderReq): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(OrderApi::class.java).submitOrder(req)
    }
}