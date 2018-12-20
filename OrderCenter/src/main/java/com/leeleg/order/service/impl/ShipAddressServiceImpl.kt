package com.leeleg.order.service.impl

import com.kotlin.base.ext.convert
import com.leeleg.order.data.protocol.ShipAddress
import com.leeleg.order.data.repository.ShipAddressRepository
import com.leeleg.order.service.ShipAddressService
import rx.Observable
import javax.inject.Inject

class ShipAddressServiceImpl @Inject constructor(): ShipAddressService {

    @Inject
    lateinit var repository: ShipAddressRepository

    override fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String): Observable<String> {
        return repository.addShipAddress(shipUserName, shipUserMobile, shipAddress).convert()
    }

    override fun deleteShipAddress(id: Int): Observable<String> {
        return repository.deleteShipAddress(id).convert()
    }

    override fun editShipAddress(id: Int, shipUserName: String, shipUserMobile: String, shipAddress: String, shipIsDefault: Int): Observable<String> {
        return repository.editShipAddress(id, shipUserName, shipUserMobile, shipAddress, shipIsDefault).convert()
    }

    override fun getShipAddressList(): Observable<MutableList<ShipAddress>?> {
        return repository.getShipAddressList().convert()
    }
}