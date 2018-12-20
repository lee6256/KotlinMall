package com.leeleg.order.ui.activity

import android.os.Bundle
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.leeleg.order.R
import com.leeleg.order.injection.component.DaggerShipAddressComponent
import com.leeleg.order.injection.module.ShipAddressModule
import com.leeleg.order.presenter.EditShipAddressPresenter
import com.leeleg.order.presenter.view.EditShipAddressView
import kotlinx.android.synthetic.main.activity_edit_address.*
import org.jetbrains.anko.toast

class ShipAddressEditActivity : BaseMvpActivity<EditShipAddressPresenter>(), EditShipAddressView {

    override fun injectComponent() {
        DaggerShipAddressComponent.builder()
                .activityComponent(activityComponent)
                .shipAddressModule(ShipAddressModule())
                .build()
                .inject(this)
        mPresenter.mView = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_address)

        initView()
    }

    private fun initView() {
        mSaveBtn.onClick {
            if (mShipNameEt.text.isNullOrEmpty()) {
                toast("名称不能为空")
                return@onClick
            }
            if (mShipMobileEt.text.isNullOrEmpty()) {
                toast("电话不能为空")
                return@onClick
            }
            if (mShipAddressEt.text.isNullOrEmpty()) {
                toast("地址不能为空")
                return@onClick
            }
            mPresenter.addShipAddress(
                    mShipNameEt.text.toString(),
                    mShipMobileEt.text.toString(),
                    mShipAddressEt.text.toString()
            )
        }
    }

    override fun onAddShipAddressResult(result: Boolean) {
        toast("地址添加成功")
    }
}