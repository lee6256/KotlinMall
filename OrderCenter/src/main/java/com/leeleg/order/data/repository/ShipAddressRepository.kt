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
    fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(ShipAddressApi::class.java)
                .addShipAddress(AddShipAddressReq(shipUserName, shipUserMobile, shipAddress))
    }

    fun deleteShipAddress(id: Int): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(ShipAddressApi::class.java)
                .deleteShipAddress(DeleteShipAddressReq(id))
    }

    fun editShipAddress(id: Int, shipUserName: String, shipUserMobile: String, shipAddress: String,
                        shipIsDefault: Int): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(ShipAddressApi::class.java)
                .editShipAddress(EditShipAddressReq(
                        id, shipUserName, shipUserMobile, shipAddress, shipIsDefault
                ))
    }

    fun getShipAddressList(): Observable<BaseResp<MutableList<ShipAddress>?>> {
        return RetrofitFactory.instance.create(ShipAddressApi::class.java).getShipAddressList()
    }
}