package com.kotlin.goods.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.goods.data.protocol.CartGoods
import com.kotlin.goods.presenter.view.CartListView
import com.kotlin.goods.service.CartService
import javax.inject.Inject

class CartListPresenter @Inject constructor(): BasePresenter<CartListView>() {

    @Inject
    lateinit var cartService: CartService

    fun getCartList() {
        if (!checkNetWork()) {
            println("无网络")
        }
        mView.showLoading()
        cartService.getCartList()
                .execute(object : BaseSubscriber<MutableList<CartGoods>?>(mView) {
                    override fun onNext(t: MutableList<CartGoods>?) {
                            mView.onGetCartListResult(t)
                    }
                }, lifecycleProvider)
    }
}