package com.leeleg.order.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kennyc.view.MultiStateView
import com.kotlin.base.ext.onClick
import com.kotlin.base.ext.startLoading
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.order.ui.adapter.ShipAddressAdapter
import com.leeleg.order.R
import com.leeleg.order.data.protocol.ShipAddress
import com.leeleg.order.injection.component.DaggerShipAddressComponent
import com.leeleg.order.injection.module.ShipAddressModule
import com.leeleg.order.presenter.ShipAddressPresenter
import com.leeleg.order.presenter.view.ShipAddressView
import kotlinx.android.synthetic.main.activity_address.*
import org.jetbrains.anko.startActivity

class ShipAddressActivity : BaseMvpActivity<ShipAddressPresenter>(), ShipAddressView {

    private lateinit var mAdapter: ShipAddressAdapter

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
        setContentView(R.layout.activity_address)

        initView()
    }

    private fun initView() {
        mAddressRv.layoutManager = LinearLayoutManager(this)
        mAdapter = ShipAddressAdapter(this)
        mAddressRv.adapter = mAdapter

        mAdapter.mOptClickListener = object : ShipAddressAdapter.OnOptClickListener {
            override fun onSetDefault(address: ShipAddress) {
            }

            override fun onEdit(address: ShipAddress) {
            }

            override fun onDelete(address: ShipAddress) {
            }
        }

        mAddAddressBtn.onClick {
            startActivity<ShipAddressEditActivity>()
        }
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    private fun loadData() {
        mMultiStateView.startLoading()
        mPresenter.getShipAddressList()
    }

    override fun onGetShipAddressResult(result: MutableList<ShipAddress>?) {
        if (result != null && result.size > 0) {
            mAdapter.setData(result)
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
        } else {
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_EMPTY
        }
    }
}