package com.kotlin.goods.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.goods.data.protocol.Category
import com.kotlin.goods.presenter.view.CategoryView
import com.kotlin.goods.service.CategoryService
import javax.inject.Inject

/**
 * Created by HelloWorld on 2018/5/27.
 */
class CategoryPresenter @Inject constructor(): BasePresenter<CategoryView>() {

    @Inject
    lateinit var categoryService: CategoryService

    fun getCategory(parentId: Int) {
        if (!checkNetWork()) {
            println("无网络")
        }
        mView.showLoading()
        categoryService.getCategory(parentId)
                .execute(object : BaseSubscriber<MutableList<Category>?>(mView) {
                    override fun onNext(t: MutableList<Category>?) {
                            mView.onGetCategoryResult(t)
                    }
                }, lifecycleProvider)
    }
}