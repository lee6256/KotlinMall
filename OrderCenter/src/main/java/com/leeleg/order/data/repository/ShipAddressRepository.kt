package com.leeleg.order.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.order.data.protocol.AddShipAddressReq
import com.kotlin.order.data.protocol.DeleteShipAddressReq
import com.kotlin.order.data.protocol.EditShipAddressReq
import com.leeleg.order.data.api.ShipAddressApi
import com.leeleg.order.data.protocol.ShipAddress
import retrofit2.http.Body
import rx.Observable
import javax.inject.Inject

class ShipAddressRepository @Inject constructor() {
    fun addShipAddress(@Body req: AddShipAddressReq): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(ShipAddressApi::class.java).addShipAddress(req)
    }

    fun deleteShipAddress(@Body req: DeleteShipAddressReq): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(ShipAddressApi::class.java).deleteShipAddress(req)
    }

    fun editShipAddress(@Body req: EditShipAddressReq): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(ShipAddressApi::class.java).editShipAddress(req)
    }

    fun getShipAddressList(): Observable<BaseResp<MutableList<ShipAddress>?>> {
        return RetrofitFactory.instance.create(ShipAddressApi::class.java).getShipAddressList()
    }
}