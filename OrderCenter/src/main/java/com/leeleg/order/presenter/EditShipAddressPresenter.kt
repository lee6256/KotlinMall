package com.leeleg.order.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.leeleg.order.data.protocol.Order
import com.leeleg.order.data.protocol.ShipAddress
import com.leeleg.order.presenter.view.EditShipAddressView
import com.leeleg.order.presenter.view.OrderConfirmView
import com.leeleg.order.service.OrderService
import com.leeleg.order.service.ShipAddressService
import javax.inject.Inject

class EditShipAddressPresenter @Inject constructor(): BasePresenter<EditShipAddressView>() {

    @Inject
    lateinit var shipAddressService: ShipAddressService

    fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String) {
        if (!checkNetWork()) {
            println("无网络")
        }
        mView.showLoading()
        shipAddressService.addShipAddress(shipUserName, shipUserMobile, shipAddress)
                .execute(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        mView.onAddShipAddressResult(t)
                    }
                }, lifecycleProvider)
    }

    fun editShipAddress(address: ShipAddress) {
        if (!checkNetWork()) {
            println("无网络")
        }
        mView.showLoading()
        shipAddressService.editShipAddress(address)
                .execute(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        mView.onEditShipAddressResult(t)
                    }
                }, lifecycleProvider)
    }
}