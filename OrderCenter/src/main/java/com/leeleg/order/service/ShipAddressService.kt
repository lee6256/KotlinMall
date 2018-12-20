package com.leeleg.order.service

import com.leeleg.order.data.protocol.ShipAddress
import rx.Observable

interface ShipAddressService {
    fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String): Observable<Boolean>
    fun deleteShipAddress(id: Int): Observable<String>
    fun editShipAddress(id: Int, shipUserName: String, shipUserMobile: String, shipAddress: String,
                        shipIsDefault: Int): Observable<String>
    fun getShipAddressList(): Observable<MutableList<ShipAddress>?>
}