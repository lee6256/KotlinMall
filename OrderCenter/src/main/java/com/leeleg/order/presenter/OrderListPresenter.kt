package com.leeleg.order.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.leeleg.order.data.protocol.Order
import com.leeleg.order.presenter.view.OrderListView
import com.leeleg.order.service.OrderService
import javax.inject.Inject

class OrderListPresenter @Inject constructor(): BasePresenter<OrderListView>() {

    @Inject
    lateinit var orderService: OrderService

    fun getOrderList(orderStatus: Int) {
        if (!checkNetWork()) {
            println("无网络")
        }
        mView.showLoading()
        orderService.getOrderList(orderStatus)
                .execute(object : BaseSubscriber<MutableList<Order>?>(mView) {
                    override fun onNext(t: MutableList<Order>?) {
                        mView.onGetOrderListResult(t)
                    }
                }, lifecycleProvider)
    }
}