package com.leeleg.order.presenter.view

import com.kotlin.base.presenter.view.BaseView
import com.leeleg.order.data.protocol.Order

interface OrderListView : BaseView{
    fun onGetOrderListResult(result: MutableList<Order>?)
    fun onConfirmOrderResult(result: Boolean)
    fun onCancelOrderResult(result: Boolean)
}