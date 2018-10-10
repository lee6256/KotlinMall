package com.kotlin.goods.service

import com.kotlin.goods.data.protocol.Category
import rx.Observable

/**
 * Created by HelloWorld on 2018/5/27.
 */
interface CategoryService {
    fun getCategory(parentId: Int): Observable<MutableList<Category>?>
}