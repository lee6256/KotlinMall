package com.kotlin.base.presenter.view

/**
 * Created by HelloWorld on 2018/5/27.
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text:String)
}