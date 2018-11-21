package com.kotlin.goods.injection.module

import com.kotlin.goods.service.CategoryService
import com.kotlin.goods.service.GoodsService
import com.kotlin.goods.service.impl.CategoryServiceImpl
import com.kotlin.goods.service.impl.GoodsServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by HelloWorld on 2018/5/29.
 */

@Module
class GoodsModule {

    @Provides
    fun providesGoodsService(goodsService: GoodsServiceImpl): GoodsService {
        return goodsService
    }
}