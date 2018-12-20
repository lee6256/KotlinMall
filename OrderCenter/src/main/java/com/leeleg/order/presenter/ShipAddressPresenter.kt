package com.leeleg.order.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.leeleg.order.data.protocol.ShipAddress
import com.leeleg.order.presenter.view.ShipAddressView
import com.leeleg.order.service.ShipAddressService
import javax.inject.Inject

class ShipAddressPresenter @Inject constructor(): BasePresenter<ShipAddressView>() {

    @Inject
    lateinit var shipAddressService: ShipAddressService

    fun getShipAddressList() {
        if (!checkNetWork()) {
            println("无网络")
        }
        mView.showLoading()
        shipAddressService.getShipAddressList()
                .execute(object : BaseSubscriber<MutableList<ShipAddress>?>(mView) {
                    override fun onNext(t: MutableList<ShipAddress>?) {
                        mView.onGetShipAddressResult(t)
                    }
                }, lifecycleProvider)
    }

    fun setDefaultShipAddress(address: ShipAddress) {
        if (!checkNetWork()) {
            println("无网络")
        }
        mView.showLoading()
        shipAddressService.editShipAddress(address)
                .execute(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        mView.onSetDefaultResult(t)
                    }
                }, lifecycleProvider)
    }
}