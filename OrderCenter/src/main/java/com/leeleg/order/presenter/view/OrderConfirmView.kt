package com.leeleg.order.presenter.view

import com.kotlin.base.presenter.view.BaseView
import com.leeleg.order.data.protocol.Order

interface OrderConfirmView : BaseView{
    fun onGetOrderByIdResult(result: Order)
}