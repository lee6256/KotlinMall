package com.kotlin.goods.injection.module

import com.kotlin.goods.service.CategoryService
import com.kotlin.goods.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by HelloWorld on 2018/5/29.
 */

@Module
class CategoryModule {

    @Provides
    fun providesCategoryService(categoryService: CategoryServiceImpl): CategoryService {
        return categoryService
    }
}