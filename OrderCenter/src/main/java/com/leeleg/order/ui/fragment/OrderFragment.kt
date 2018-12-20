package com.leeleg.order.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kennyc.view.MultiStateView
import com.kotlin.base.ext.startLoading
import com.kotlin.base.ui.fragment.BaseMvpFragment
import com.kotlin.order.ui.adapter.OrderAdapter
import com.leeleg.order.R
import com.leeleg.order.common.OrderConstant
import com.leeleg.order.data.protocol.Order
import com.leeleg.order.injection.component.DaggerOrderComponent
import com.leeleg.order.injection.module.OrderModule
import com.leeleg.order.presenter.OrderListPresenter
import com.leeleg.order.presenter.view.OrderListView
import kotlinx.android.synthetic.main.fragment_order.*

class OrderFragment : BaseMvpFragment<OrderListPresenter>(), OrderListView {

    private lateinit var mAdapter: OrderAdapter

    override fun injectComponent() {
        DaggerOrderComponent.builder()
                .activityComponent(activityComponent)
                .orderModule(OrderModule())
                .build()
                .inject(this)
        mPresenter.mView = this
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        loadData()
    }

    private fun initView() {
        mOrderRv.layoutManager = LinearLayoutManager(activity)
        mAdapter = OrderAdapter(activity)
        mOrderRv.adapter = mAdapter

        mAdapter.listener = object : OrderAdapter.OnOptClickListener {
            override fun onOptClick(optType: Int, order: Order) {
                when (optType) {
                    OrderConstant.OPT_ORDER_PAY -> {}
                    OrderConstant.OPT_ORDER_CONFIRM -> {}
                    OrderConstant.OPT_ORDER_CANCEL -> {}
                }
            }
        }
    }

    private fun loadData() {
        mMultiStateView.startLoading()
        mPresenter.getOrderList(arguments.getInt(OrderConstant.KEY_ORDER_STATUS, -1))
    }

    override fun onGetOrderListResult(result: MutableList<Order>?) {
        if (result != null && result.size > 0) {
            mAdapter.setData(result)
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
        } else {
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_EMPTY
        }
    }
}