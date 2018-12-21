package com.leeleg.pay.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.base.utils.YuanFenConverter
import com.kotlin.provider.common.ProviderConstant
import com.kotlin.provider.router.RouterPath
import com.leeleg.pay.R
import com.leeleg.pay.injection.component.DaggerPayComponent
import com.leeleg.pay.injection.module.PayModule
import com.leeleg.pay.presenter.PayPresenter
import com.leeleg.pay.presenter.view.PayView
import kotlinx.android.synthetic.main.activity_cash_register.*
import org.jetbrains.anko.toast

@Route(path = RouterPath.PaySDK.PATH_PAY)
class CashRegisterActivity : BaseMvpActivity<PayPresenter>(), PayView {

    override fun injectComponent() {
        DaggerPayComponent.builder()
                .activityComponent(activityComponent)
                .payModule(PayModule())
                .build()
                .inject(this)
        mPresenter.mView = this
    }

    @Autowired(name = ProviderConstant.KEY_ORDER_ID)
    @JvmField
    var mOrderId: Int = 0

    @Autowired(name = ProviderConstant.KEY_ORDER_PRICE)
    @JvmField
    var mTotalPrice: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_register)

        initView()
    }

    private fun initView() {
        mTotalPriceTv.text = YuanFenConverter.changeF2YWithUnit(mTotalPrice)

        mPayBtn.onClick {
            mPresenter.getPaySign(mOrderId, mTotalPrice)
        }
    }

    override fun onGetPaySignResult(result: String) {
        toast(result)
    }
}