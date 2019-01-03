package com.leeleg.order.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.leeleg.order.data.api.OrderApi
import com.leeleg.order.data.protocol.*
import rx.Observable
import javax.inject.Inject

class OrderRepository @Inject constructor() {

    fun cancelOrder(orderId: Int): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(OrderApi::class.java)
                .cancelOrder(CancelOrderReq(orderId))
    }

    fun confirmOrder(orderId: Int): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(OrderApi::class.java)
                .confirmOrder(ConfirmOrderReq(orderId))
    }

    fun getOrderById(orderId: Int): Observable<BaseResp<Order>> {
        return RetrofitFactory.instance.create(OrderApi::class.java)
                .getOrderById(GetOrderByIdReq(orderId))
    }

    fun getOrderList(orderStatus: Int): Observable<BaseResp<MutableList<Order>?>> {
        return RetrofitFactory.instance.create(OrderApi::class.java)
                .getOrderList(GetOrderListReq(orderStatus))
    }

    fun submitOrder(order: Order): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(OrderApi::class.java)
                .submitOrder(SubmitOrderReq(order))
    }
}