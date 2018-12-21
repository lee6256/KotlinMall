package com.leeleg.pay.presenter.view

import com.kotlin.base.presenter.view.BaseView

interface PayView : BaseView {
    fun onGetPaySignResult(result: String)
}