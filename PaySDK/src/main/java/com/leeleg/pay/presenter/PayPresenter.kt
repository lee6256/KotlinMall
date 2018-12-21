package com.leeleg.pay.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.leeleg.pay.presenter.view.PayView
import com.leeleg.pay.service.PayService
import javax.inject.Inject

class PayPresenter @Inject constructor() : BasePresenter<PayView>() {

    @Inject
    lateinit var payService: PayService

    fun getPaySign(orderId: Int, totalPrice: Long) {
        if (!checkNetWork()) {
            println("无网络")
        }
        mView.showLoading()
        payService.getPaySign(orderId, totalPrice)
                .execute(object : BaseSubscriber<String>(mView) {
                    override fun onNext(t: String) {
                        mView.onGetPaySignResult(t)
                    }
                }, lifecycleProvider)
    }
}