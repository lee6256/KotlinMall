package com.leeleg.order.presenter.view

import com.kotlin.base.presenter.view.BaseView

interface EditShipAddressView : BaseView{
    fun onAddShipAddressResult(result: Boolean)
    fun onEditShipAddressResult(result: Boolean)
}