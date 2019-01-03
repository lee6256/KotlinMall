package com.kotlin.goods.service

import com.kotlin.goods.data.protocol.CartGoods
import rx.Observable

interface CartService {
    fun getCartList(): Observable<MutableList<CartGoods>?>
    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                goodsCount: Int, goodsSku: String): Observable<Int>
    fun deleteCartList(cartIdList: List<Int>): Observable<Boolean>
    fun submitCart(goodsList: List<CartGoods>, totalPrice: Long): Observable<Int>
}