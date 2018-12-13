package com.leeleg.order.service.impl

import com.kotlin.base.ext.convert
import com.leeleg.order.data.protocol.Order
import com.leeleg.order.data.repository.OrderRepository
import com.leeleg.order.service.OrderService
import rx.Observable
import javax.inject.Inject

class OrderServiceImpl @Inject constructor(): OrderService {

    @Inject
    lateinit var repository: OrderRepository

    override fun cancelOrder(orderId: Int): Observable<String> {
        return repository.cancelOrder(orderId).convert()
    }

    override fun confirmOrder(orderId: Int): Observable<String> {
        return repository.confirmOrder(orderId).convert()
    }

    override fun getOrderById(orderId: Int): Observable<Order> {
        return repository.getOrderById(orderId).convert()
    }

    override fun getOrderList(orderStatus: Int): Observable<MutableList<Order>?> {
        return repository.getOrderList(orderStatus).convert()
    }

    override fun submitOrder(order: Order): Observable<String> {
        return repository.submitOrder(order).convert()
    }
}