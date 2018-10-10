package com.kotlin.goods.presenter.view

import com.kotlin.base.presenter.view.BaseView
import com.kotlin.goods.data.protocol.Category

/**
 * Created by HelloWorld on 2018/5/27.
 */
interface CategoryView: BaseView {
    fun onGetCategoryResult(result: MutableList<Category>?)
}