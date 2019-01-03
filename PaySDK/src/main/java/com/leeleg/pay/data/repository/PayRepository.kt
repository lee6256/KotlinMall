package com.leeleg.pay.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.leeleg.pay.data.api.PayApi
import com.leeleg.pay.data.protocol.GetPaySignReq
import com.leeleg.pay.data.protocol.PayOrderReq
import rx.Observable
import javax.inject.Inject

class PayRepository @Inject constructor() {

    fun getPaySign(orderId: Int, totalPrice: Long): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(PayApi::class.java)
                .getPaySign(GetPaySignReq(orderId, totalPrice))
    }

    fun payOrder(orderId: Int): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(PayApi::class.java)
                .payOrder(PayOrderReq(orderId))
    }
}