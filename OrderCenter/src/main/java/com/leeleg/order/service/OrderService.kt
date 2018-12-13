package com.leeleg.order.service

import com.leeleg.order.data.protocol.Order
import rx.Observable

interface OrderService {
    fun cancelOrder(orderId: Int): Observable<String>
    fun confirmOrder(orderId: Int): Observable<String>
    fun getOrderById(orderId: Int): Observable<Order>
    fun getOrderList(orderStatus: Int): Observable<MutableList<Order>?>
    fun submitOrder(order: Order): Observable<String>
}