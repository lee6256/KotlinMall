package com.leeleg.order.presenter.view

import com.kotlin.base.presenter.view.BaseView
import com.leeleg.order.data.protocol.ShipAddress

interface ShipAddressView : BaseView{
    fun onGetShipAddressResult(result: MutableList<ShipAddress>?)
    fun onSetDefaultResult(result: Boolean)
    fun onDeleteShipAddressResult(result: Boolean)
}