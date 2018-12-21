package com.leeleg.pay.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.base.utils.YuanFenConverter
import com.kotlin.provider.common.ProviderConstant
import com.kotlin.provider.router.RouterPath
import com.leeleg.pay.R
import kotlinx.android.synthetic.main.activity_cash_register.*

@Route(path = RouterPath.PaySDK.PATH_PAY)
class CashRegisterActivity : BaseActivity() {

    @Autowired(name = ProviderConstant.KEY_ORDER_ID)
    @JvmField
    var mOrderId: Int = 0

    @Autowired(name = ProviderConstant.KEY_ORDER_PRICE)
    @JvmField
    var mTotalPrice: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_register)

        ARouter.getInstance().inject(this)
        initView()
    }

    private fun initView() {
        mTotalPriceTv.text = YuanFenConverter.changeF2YWithUnit(mTotalPrice)
    }
}